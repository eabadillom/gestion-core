package com.ferbo.gestion.core.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Factura;

public class FacturaDAO extends BaseDAO <Factura, Integer>
{
    private static Logger log = LogManager.getLogger(FacturaDAO.class);

    public FacturaDAO(){
        super(Factura.class);
    }
}
