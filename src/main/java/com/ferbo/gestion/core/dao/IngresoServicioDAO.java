package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.IngresoServicio;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IngresoServicioDAO extends BaseDAO<IngresoServicio , Integer>
{
    private static Logger log = LogManager.getLogger(IngresoServicioDAO.class);

    public IngresoServicioDAO() {
        super(IngresoServicio.class);
    }
    
}
