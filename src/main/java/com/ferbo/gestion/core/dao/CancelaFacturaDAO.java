package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.CancelaFactura;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class CancelaFacturaDAO extends BaseDAO<CancelaFactura, Integer> 
{
    private static Logger log = LogManager.getLogger(CancelaFacturaDAO.class);

    public CancelaFacturaDAO(TransactionManager executor) {
        super(CancelaFactura.class, executor);
    }

}
