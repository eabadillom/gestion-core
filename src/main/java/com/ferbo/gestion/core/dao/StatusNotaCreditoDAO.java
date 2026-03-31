package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.StatusNotaCredito;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StatusNotaCreditoDAO extends BaseDAO<StatusNotaCredito, Integer> 
{
    private static Logger log = LogManager.getLogger(StatusNotaCreditoDAO.class);

    public StatusNotaCreditoDAO(Class<StatusNotaCredito> modelClass) {
        super(modelClass);
    }
    
    public List<StatusNotaCredito> buscarTodos()
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("StatusFactura.findAll", StatusNotaCredito.class)
                .getResultList()
        );
    }
    
}
