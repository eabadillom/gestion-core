package com.ferbo.gestion.core.commons.dao;

import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public abstract class BaseDAO<T, ID> implements GenericDAO<T, ID>
{
    private static Logger log = LogManager.getLogger(BaseDAO.class);
    
    protected final TransactionManager transactManager;
    protected Class<T> clazz;

    public BaseDAO(Class<T> clazz, TransactionManager transactManager) {
        this.clazz = clazz;
        this.transactManager = transactManager;
    }
    
    @Override
    public Optional<T> buscarPorId(ID id) {
        return transactManager.executeRead(em -> {
            T model = em.find(clazz, id);
            return Optional.of(model);
        });
    }
    
    @Override
    public synchronized void guardar(T model) {
        transactManager.executeVoid(em -> em.persist(model));
    }

    @Override
    public synchronized void actualizar(T model) {
        transactManager.executeVoid(em -> em.merge(model));
    }
    
    @Override
    public synchronized void eliminar(T model) {
        transactManager.executeVoid(em -> em.remove(em.contains(model) ? model : em.merge(model)));
    }

}
