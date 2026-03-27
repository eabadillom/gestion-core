package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.CancelaFactura;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CancelaFacturaDAO extends BaseDAO<CancelaFactura, Integer> 
{
    private static Logger log = LogManager.getLogger(CancelaFacturaDAO.class);

    public CancelaFacturaDAO() {
        super(CancelaFactura.class);
    }

}
