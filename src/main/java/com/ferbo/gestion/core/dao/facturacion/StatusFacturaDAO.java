package com.ferbo.gestion.core.dao.facturacion;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.facturacion.StatusFactura;

public class StatusFacturaDAO extends BaseDAO<StatusFactura, Integer>
{
    private static Logger log = LogManager.getLogger(StatusFacturaDAO.class);

    public StatusFacturaDAO(TransactionManager transactManager) {
        super(StatusFactura.class, transactManager);
    }
    
    public List<StatusFactura> buscarTodos() 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("StatusFactura.findAll", StatusFactura.class)
                .getResultList()
        );
    }
    
}
