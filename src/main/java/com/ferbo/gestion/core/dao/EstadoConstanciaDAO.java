package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.EstadoConstancia;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EstadoConstanciaDAO extends BaseDAO <EstadoConstancia, Integer>
{
    private static Logger log = LogManager.getLogger(EstadoConstanciaDAO.class);

    public EstadoConstanciaDAO(){
        super(EstadoConstancia.class);
    }
    
    public List<EstadoConstancia> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("EntidadPostal.findAll", EstadoConstancia.class)
                .getResultList()
        );
    }
    
}
