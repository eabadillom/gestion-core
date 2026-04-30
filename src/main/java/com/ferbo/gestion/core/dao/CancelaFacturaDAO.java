package com.ferbo.gestion.core.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.CancelaFactura;

public class CancelaFacturaDAO extends BaseDAO<CancelaFactura, Integer> 
{
    private static Logger log = LogManager.getLogger(CancelaFacturaDAO.class);

    public CancelaFacturaDAO() {
        super(CancelaFactura.class);
    }

}
