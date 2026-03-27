package com.ferbo.gestion.core.commons.dao;

import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BaseDAO<MODEL, PK> 
{
    private static Logger log = LogManager.getLogger(BaseDAO.class);
    
    protected Class<MODEL> modelClass;

    public BaseDAO(Class<MODEL> modelClass) {
        this.modelClass = modelClass;
    }

    public Optional<MODEL> buscarPorId(PK id) {
        return JpaExecutor.executeRead(em -> {
            MODEL model = em.find(modelClass, id);
            return Optional.of(model);
        });
    }

    public synchronized void guardar(MODEL model) {
        JpaExecutor.executeVoid(em -> {
            em.persist(model);
        });
    }

    public synchronized void actualizar(MODEL model) {
        JpaExecutor.executeVoid(em -> {
            em.merge(model);    
        });
    }

    public synchronized void eliminar(MODEL model) {
        JpaExecutor.executeVoid(em -> {
            em.remove(em.contains(model) ? model : em.merge(model));
        });
    }

}
