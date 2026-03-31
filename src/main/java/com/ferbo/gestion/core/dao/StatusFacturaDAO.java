package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.StatusFactura;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StatusFacturaDAO extends BaseDAO<StatusFactura, Integer>
{
    private static Logger log = LogManager.getLogger(StatusFacturaDAO.class);

    public StatusFacturaDAO() {
        super(StatusFactura.class);
    }
    
    public List<StatusFactura> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("StatusFactura.findAll", StatusFactura.class)
                .getResultList()
        );
    }
    
}
