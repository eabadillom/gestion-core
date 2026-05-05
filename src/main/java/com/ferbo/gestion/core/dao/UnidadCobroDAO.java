package com.ferbo.gestion.core.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.UnidadCobro;

public class UnidadCobroDAO extends BaseDAO <UnidadCobro, Integer> 
{
    private static Logger log = LogManager.getLogger(UnidadCobroDAO.class);

    public UnidadCobroDAO (TransactionManager transactManager){
        super(UnidadCobro.class, transactManager);
    }
}
