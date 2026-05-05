package com.ferbo.gestion.core.provider;

import javax.persistence.EntityManager;

public interface EntityManagerProvider 
{
    EntityManager getEntityManager();
    void close(EntityManager em);
}
