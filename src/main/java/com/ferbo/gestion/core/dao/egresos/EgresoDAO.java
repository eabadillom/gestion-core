package com.ferbo.gestion.core.dao.egresos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.egresos.Egreso;

public class EgresoDAO extends BaseDAO<Egreso, Long> {

    private static final Logger log = LogManager.getLogger(EgresoDAO.class);

    public EgresoDAO(TransactionManager excutor) {
        super(Egreso.class, excutor);
    }

}
