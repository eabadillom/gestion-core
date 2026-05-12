package com.ferbo.gestion.core.config;

import com.ferbo.gestion.core.provider.EntityManagerProvider;
import com.ferbo.gestion.core.tools.exception.ExceptionTranslator;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TransactionManagerImpl implements TransactionManager
{
    private static Logger log = LogManager.getLogger(TransactionManagerImpl.class);
    
    private final EntityManagerProvider provider;
    
    public TransactionManagerImpl(EntityManagerProvider provider) {
        this.provider = provider;
    }
    
    @Override
    public <T> T executeRead(Function<EntityManager, T> action) {
        EntityManager em = provider.getEntityManager();

        try {
            return action.apply(em);
        } catch (Exception e) {
            throw ExceptionTranslator.translate(e);
        } finally {
            provider.close(em);
        }
    }
    
    @Override
    public <T> T executeWrite(Function<EntityManager, T> action) {
        EntityManager em = provider.getEntityManager();

        try {
            em.getTransaction().begin();
            T result = action.apply(em);
            em.getTransaction().commit();
            return result;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) 
                em.getTransaction().rollback();
            throw ExceptionTranslator.translate(e);
        } finally {
            provider.close(em);
        }
    }

    @Override
    public void executeVoid(Consumer<EntityManager> action) {
        executeWrite(em -> {
            action.accept(em);
            return null;
        });
    }
    
}
