package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.NotaPorFactura;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NotaPorFacturaDAO extends BaseDAO<NotaPorFactura ,Integer > 
{
    private static Logger log = LogManager.getLogger(NotaPorFacturaDAO.class);

    public NotaPorFacturaDAO() {
        super(NotaPorFactura.class);
    }
    
}
