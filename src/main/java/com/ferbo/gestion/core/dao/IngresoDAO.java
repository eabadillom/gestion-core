package com.ferbo.gestion.core.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Ingreso;

public class IngresoDAO extends BaseDAO<Ingreso, Integer> 
{
    private static Logger log = LogManager.getLogger(IngresoDAO.class);

    public IngresoDAO() {
        super(Ingreso.class);
    }
}
