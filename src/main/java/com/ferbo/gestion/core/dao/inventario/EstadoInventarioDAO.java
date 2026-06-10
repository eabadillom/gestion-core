package com.ferbo.gestion.core.dao.inventario;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.inventario.EstadoInventario;

public class EstadoInventarioDAO extends BaseDAO<EstadoInventario, Integer>
{
    private static Logger log = LogManager.getLogger(EstadoInventarioDAO.class);
    
    public EstadoInventarioDAO(TransactionManager transactManager) {
        super(EstadoInventario.class, transactManager);
    }
    
    public List<EstadoInventario> buscarTodos() 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("EstadoInventario.findAll", EstadoInventario.class)
                .getResultList()
        );
    }
    
}
