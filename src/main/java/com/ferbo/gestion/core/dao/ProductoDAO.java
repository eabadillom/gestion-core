package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Producto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class ProductoDAO extends BaseDAO<Producto, Integer>
{
    private static Logger log = LogManager.getLogger(ProductoDAO.class);
    
    public ProductoDAO(TransactionManager executor){
        super(Producto.class, executor);
    }
    
}
