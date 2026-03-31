package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.UnidadProducto;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UnidadDeProductoDAO extends BaseDAO<UnidadProducto, Integer>
{
    private static Logger log = LogManager.getLogger(UnidadProducto.class);

    public UnidadDeProductoDAO() {
        super(UnidadProducto.class);
    }
    
    public List<UnidadProducto> buscarPorCliente(Integer idCliente) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("UnidadProducto.findByCliente", UnidadProducto.class)
                .setParameter("idCliente", idCliente)
                .getResultList()
        );
    }
    
    public UnidadProducto buscarPorProductoUnidad(Integer idProducto, Integer idUnidad) 
    {
        return JpaExecutor.executeRead(em ->
            em.createNamedQuery("UnidadProducto.findByIdUnidadProducto", UnidadProducto.class)
                .setParameter("idProducto", idProducto)
                .setParameter("idUnidadManejo", idUnidad)
                .getSingleResult()
        );
    }
    
}
