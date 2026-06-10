package com.ferbo.gestion.core.dao.domicilio;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.domicilio.EntidadPostal;

public class EntidadPostalDAO extends BaseDAO<EntidadPostal, Integer> 
{
    private static Logger log = LogManager.getLogger(EntidadPostal.class);

    public EntidadPostalDAO(TransactionManager transactManager) {
        super(EntidadPostal.class, transactManager);
    }

    public List<EntidadPostal> buscarTodos() 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("EntidadPostal.findAll", EntidadPostal.class)
                .getResultList()
        );
    }
    
}
