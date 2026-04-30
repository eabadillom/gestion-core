package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.IngresoProducto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class IngresoProductoDAO extends BaseDAO<IngresoProducto, Integer> 
{
    private static Logger log = LogManager.getLogger(IngresoProductoDAO.class);

    public IngresoProductoDAO(TransactionManager executor) {
        super(IngresoProducto.class, executor);
    }
    
}
