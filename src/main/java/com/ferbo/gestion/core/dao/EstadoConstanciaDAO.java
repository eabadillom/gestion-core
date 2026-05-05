package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.EstadoConstancia;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class EstadoConstanciaDAO extends BaseDAO <EstadoConstancia, Integer>
{
    private static Logger log = LogManager.getLogger(EstadoConstanciaDAO.class);

    public EstadoConstanciaDAO(TransactionManager transactManager){
        super(EstadoConstancia.class, transactManager);
    }
    
    public List<EstadoConstancia> buscarTodos() 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("EntidadPostal.findAll", EstadoConstancia.class)
                .getResultList()
        );
    }
    
}
