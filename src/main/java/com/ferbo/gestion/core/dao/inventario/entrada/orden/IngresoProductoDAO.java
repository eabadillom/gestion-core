package com.ferbo.gestion.core.dao.inventario.entrada.orden;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.inventario.entrada.orden.IngresoProducto;

public class IngresoProductoDAO extends BaseDAO<IngresoProducto, Integer> 
{
    private static Logger log = LogManager.getLogger(IngresoProductoDAO.class);

    public IngresoProductoDAO(TransactionManager executor) {
        super(IngresoProducto.class, executor);
    }
    
}
