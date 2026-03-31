package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.ProductoPorCliente;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductoClienteDAO extends BaseDAO<ProductoPorCliente, Integer> 
{
    private static Logger log = LogManager.getLogger(ProductoClienteDAO.class);

    public ProductoClienteDAO() {
        super(ProductoPorCliente.class);
    }
    
    public List<ProductoPorCliente> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("ProductoPorCliente.findAll", ProductoPorCliente.class)
                .getResultList()
        );
    }
    
    public List<ProductoPorCliente> buscarPorCliente(Integer idCliente) 
    {
        return JpaExecutor.executeRead(em ->
            em.createNamedQuery("ProductoPorCliente.findByCliente",ProductoPorCliente.class)
                .setParameter("idCliente", idCliente)
                .getResultList()
        );

    }
    
    public List<ProductoPorCliente> buscarPorClienteProducto(Integer idCliente) 
    {
        return JpaExecutor.executeRead(em ->
            em.createNamedQuery("ProductoPorCliente.findByClienteProducto",ProductoPorCliente.class)
                .setParameter("idCliente", idCliente)
                .getResultList()
        );

    }
    
}
