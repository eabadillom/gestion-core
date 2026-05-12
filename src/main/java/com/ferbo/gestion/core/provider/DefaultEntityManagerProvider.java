package com.ferbo.gestion.core.provider;

import com.ferbo.gestion.core.tools.exception.ExceptionTranslator;
import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;

public class DefaultEntityManagerProvider implements EntityManagerProvider
{
    private static Logger log = LogManager.getLogger(DefaultEntityManagerProvider.class);
    
    private final EntityManagerFactory emf;
    
    public DefaultEntityManagerProvider(String persistenceUnit) {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnit);
    }
    
    public Connection getConnection() {	
    	Connection connection;
    	Session session = emf.unwrap(Session.class);
    	SessionImpl sessionImpl = (SessionImpl) session;
    	connection = sessionImpl.connection();
    	return connection;
    }

    @Override
    public EntityManager getEntityManager() {
        try{
            if (emf == null) {
                throw new Exception("Inicializar constructor con Entity Manager.");
            }
            
            return emf.createEntityManager();
        } catch (Exception e) {
            throw ExceptionTranslator.translate(e);
        }
    }

    @Override
    public void close(EntityManager em) {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

}
