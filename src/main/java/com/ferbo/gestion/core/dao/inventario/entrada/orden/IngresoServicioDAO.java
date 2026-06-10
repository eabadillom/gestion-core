package com.ferbo.gestion.core.dao.inventario.entrada.orden;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.inventario.entrada.orden.IngresoServicio;

public class IngresoServicioDAO extends BaseDAO<IngresoServicio , Integer>
{
    private static Logger log = LogManager.getLogger(IngresoServicioDAO.class);

    public IngresoServicioDAO(TransactionManager executor) {
        super(IngresoServicio.class, executor);
    }
    
}
