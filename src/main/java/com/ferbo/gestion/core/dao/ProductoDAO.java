package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Producto;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductoDAO extends BaseDAO<Producto, Integer>
{
    private static Logger log = LogManager.getLogger(ProductoDAO.class);
    
    public ProductoDAO(){
        super(Producto.class);
    }
    
    public List<Producto> buscarPorCliente(Integer idCliente) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("Producto.findByCliente", Producto.class)
                .setParameter("idCliente", idCliente)
                .getResultList()
        );
    }
    
}
