package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Ingreso;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class IngresoDAO extends BaseDAO<Ingreso, Integer> 
{
    private static Logger log = LogManager.getLogger(IngresoDAO.class);

    public IngresoDAO(TransactionManager transactManager) {
        super(Ingreso.class, transactManager);
    }

}
