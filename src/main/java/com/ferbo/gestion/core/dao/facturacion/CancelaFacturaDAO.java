package com.ferbo.gestion.core.dao.facturacion;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.facturacion.CancelaFactura;

public class CancelaFacturaDAO extends BaseDAO<CancelaFactura, Integer> 
{
    private static Logger log = LogManager.getLogger(CancelaFacturaDAO.class);

    public CancelaFacturaDAO(TransactionManager executor) {
        super(CancelaFactura.class, executor);
    }

}
