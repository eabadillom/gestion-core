package com.ferbo.gestion.core.tools;

import com.ferbo.gestion.core.tools.exception.ExceptionTranslator;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JpaExecutor 
{
    private static Logger log = LogManager.getLogger(JpaExecutor.class);
    
    public static EntityManager getEntityManager() {
        EntityManager em = null;
        try {
            em = EntityManagerUtil.getEntityManager();
        } catch (Exception ex) {
            log.error("Problema para obtener el entity manager...", ex);
            throw ExceptionTranslator.translate(ex);
        }

        return em;
    }
    
    public static <T> T executeRead(Function<EntityManager, T> action) {
        EntityManager em = getEntityManager();

        try {
            return action.apply(em);
        } catch (Exception e) {
            throw ExceptionTranslator.translate(e);
        } finally {
            EntityManagerUtil.close(em);
        }
    }
    
    public static <T> T executeWrite(Function<EntityManager, T> action) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            T result = action.apply(em);
            em.getTransaction().commit();
            return result;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) 
                EntityManagerUtil.rollback(em);
            throw ExceptionTranslator.translate(e);
        } finally {
            EntityManagerUtil.close(em);
        }
    }

    public static void executeVoid(Consumer<EntityManager> action) {
        executeWrite(em -> {
            action.accept(em);
            return null;
        });
    }
    
}
