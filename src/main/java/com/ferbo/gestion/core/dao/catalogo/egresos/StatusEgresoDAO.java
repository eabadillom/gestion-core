package com.ferbo.gestion.core.dao.catalogo.egresos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.catalogo.egresos.StatusEgreso;

public class StatusEgresoDAO extends BaseDAO<StatusEgreso, Long> {

    private static final Logger log = LogManager.getLogger(StatusEgresoDAO.class);

    public StatusEgresoDAO(TransactionManager execute) {
        super(StatusEgreso.class, execute);
    }

}
