package com.ferbo.gestion.core.dao.domicilio;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.domicilio.Asentamiento;

public class AsentamientoDAO extends BaseDAO<Asentamiento, Integer>
{
    private static Logger log = LogManager.getLogger(AsentamientoDAO.class);

    public AsentamientoDAO(TransactionManager transactManager) {
        super(Asentamiento.class, transactManager);
    }
    
}
