package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Asentamiento;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class AsentamientoDAO extends BaseDAO<Asentamiento, Integer>
{
    private static Logger log = LogManager.getLogger(AsentamientoDAO.class);

    public AsentamientoDAO(TransactionManager transactManager) {
        super(Asentamiento.class, transactManager);
    }
    
}
