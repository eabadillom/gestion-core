package com.ferbo.gestion.core.dao.cliente.detalle;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.cliente.detalle.ProductoPorCliente;

public class ProductoClienteDAO extends BaseDAO<ProductoPorCliente, Integer> 
{
    private static Logger log = LogManager.getLogger(ProductoClienteDAO.class);

    public ProductoClienteDAO(TransactionManager transactManager) {
        super(ProductoPorCliente.class, transactManager);
    }
    
    public List<ProductoPorCliente> buscarTodos() 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("ProductoPorCliente.findAll", ProductoPorCliente.class)
                .getResultList()
        );
    }
    
    public List<ProductoPorCliente> buscarPorCliente(Integer idCliente) 
    {
        return transactManager.executeRead(em ->
            em.createNamedQuery("ProductoPorCliente.findByCliente",ProductoPorCliente.class)
                .setParameter("idCliente", idCliente)
                .getResultList()
        );

    }
    
    public List<ProductoPorCliente> buscarPorClienteProducto(Integer idCliente) 
    {
        return transactManager.executeRead(em ->
            em.createNamedQuery("ProductoPorCliente.findByClienteProducto",ProductoPorCliente.class)
                .setParameter("idCliente", idCliente)
                .getResultList()
        );

    }
    
}
