package com.ferbo.gestion.core.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.EntidadPostal;
import com.ferbo.gestion.core.tools.JpaExecutor;

public class EntidadPostalDAO extends BaseDAO<EntidadPostal, Integer> 
{
    private static Logger log = LogManager.getLogger(EntidadPostal.class);

    public EntidadPostalDAO() {
        super(EntidadPostal.class);
    }

    public List<EntidadPostal> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("EntidadPostal.findAll", EntidadPostal.class)
                .getResultList()
        );
    }
    
}
