package com.ferbo.gestion.core.dao.egresos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.egresos.CancelaEgreso;

public class CancelaEgresoDAO extends BaseDAO<CancelaEgreso, Long> {

    private static final Logger log = LogManager.getLogger(CancelaEgresoDAO.class);

    public CancelaEgresoDAO(TransactionManager executor) {
        super(CancelaEgreso.class, executor);
    }

}
