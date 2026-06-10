package com.ferbo.gestion.core.dao.facturacion;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.facturacion.Factura;

public class FacturaDAO extends BaseDAO <Factura, Integer>
{
    private static Logger log = LogManager.getLogger(FacturaDAO.class);

    public FacturaDAO(TransactionManager transactManager){
        super(Factura.class, transactManager);
    }

}
