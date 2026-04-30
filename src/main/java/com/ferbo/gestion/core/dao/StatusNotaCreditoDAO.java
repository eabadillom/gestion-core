package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.StatusNotaCredito;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class StatusNotaCreditoDAO extends BaseDAO<StatusNotaCredito, Integer> 
{
    private static Logger log = LogManager.getLogger(StatusNotaCreditoDAO.class);

    public StatusNotaCreditoDAO(TransactionManager transactManager) {
        super(StatusNotaCredito.class, transactManager);
    }
    
    public List<StatusNotaCredito> buscarTodos()
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("StatusFactura.findAll", StatusNotaCredito.class)
                .getResultList()
        );
    }
    
}
