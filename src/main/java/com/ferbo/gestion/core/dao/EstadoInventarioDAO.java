package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.EstadoInventario;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EstadoInventarioDAO extends BaseDAO<EstadoInventario, Integer>
{
    private static Logger log = LogManager.getLogger(EstadoInventarioDAO.class);
    
    public EstadoInventarioDAO(){
        super(EstadoInventario.class);
    }
    
    public List<EstadoInventario> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("EstadoInventario.findAll", EstadoInventario.class)
                .getResultList()
        );
    }
    
}
