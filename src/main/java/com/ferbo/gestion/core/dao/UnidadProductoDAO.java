package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.UnidadProducto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UnidadProductoDAO extends BaseDAO<UnidadProducto, Integer> 
{
    private static Logger log = LogManager.getLogger(UnidadProductoDAO.class);

    public UnidadProductoDAO(TransactionManager transactManager) {
        super(UnidadProducto.class, transactManager);
    }

}
