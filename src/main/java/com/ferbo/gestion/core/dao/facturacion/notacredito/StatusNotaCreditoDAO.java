package com.ferbo.gestion.core.dao.facturacion.notacredito;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.facturacion.notacredito.StatusNotaCredito;

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
