package com.ferbo.gestion.core.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.TraspasoServicio;

public class TraspasoServicioDAO extends BaseDAO<TraspasoServicio, Integer>
{	
    private static Logger log = LogManager.getLogger(TraspasoServicioDAO.class);

    public TraspasoServicioDAO() {
        super(TraspasoServicio.class);
    }
}
