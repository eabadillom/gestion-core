package com.ferbo.gestion.core.dao.catalogo.egresos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.catalogo.egresos.CategoriaEgreso;

public class CategoriaEgresoDAO extends BaseDAO<CategoriaEgreso, Long> {

    private static final Logger log = LogManager.getLogger(CategoriaEgreso.class);

    public CategoriaEgresoDAO(TransactionManager execute) {
        super(CategoriaEgreso.class, execute);

    }

}
