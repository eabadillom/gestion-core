package com.ferbo.gestion.core.dao.catalogo.producto;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.catalogo.producto.Producto;

public class ProductoDAO extends BaseDAO<Producto, Integer>
{
    private static Logger log = LogManager.getLogger(ProductoDAO.class);
    
    public ProductoDAO(TransactionManager executor){
        super(Producto.class, executor);
    }
    
}
