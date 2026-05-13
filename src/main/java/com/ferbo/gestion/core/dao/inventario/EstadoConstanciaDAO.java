package com.ferbo.gestion.core.dao.inventario;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.inventario.EstadoConstancia;

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
