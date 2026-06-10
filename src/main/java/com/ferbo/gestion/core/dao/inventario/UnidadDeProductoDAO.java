package com.ferbo.gestion.core.dao.inventario;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.inventario.UnidadProducto;

public class UnidadDeProductoDAO extends BaseDAO<UnidadProducto, Integer>
{
    private static Logger log = LogManager.getLogger(UnidadProducto.class);

    public UnidadDeProductoDAO(TransactionManager transactManager) {
        super(UnidadProducto.class, transactManager);
    }
    
    public UnidadProducto buscarPorProductoUnidad(Integer idProducto, Integer idUnidad) 
    {
        return transactManager.executeRead(em ->
            em.createNamedQuery("UnidadProducto.findByIdUnidadProducto", UnidadProducto.class)
                .setParameter("idProducto", idProducto)
                .setParameter("idUnidadManejo", idUnidad)
                .getSingleResult()
        );
    }
    
}
