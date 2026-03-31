package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Telefono;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TelefonoDAO extends BaseDAO<Telefono, Integer> 
{
    private static Logger log = LogManager.getLogger(TelefonoDAO.class);

    public TelefonoDAO() {
        super(Telefono.class);
    }
    
}
