package com.ferbo.gestion.core.dao.cliente;

import java.util.List;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.cliente.Cliente;
import com.ferbo.gestion.core.tools.exception.CoreException;

public class ClienteDAO extends BaseDAO<Cliente, Integer> 
{
    private static Logger log = LogManager.getLogger(ClienteDAO.class);

    public ClienteDAO(TransactionManager transactManager) {
        super(Cliente.class, transactManager);
    }
    
    public List<Cliente> buscarTodos() 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("Cliente.findAll", Cliente.class)
                .getResultList()
        );
    }

    public Cliente obtenerPorId(Integer idCliente) throws CoreException 
    {
        return transactManager.executeRead(em -> {
            return em.createQuery("SELECT DISTINCT cl FROM Cliente cl \n" +
                        "INNER JOIN cl.candadoSalida cs \n" +
                        "INNER JOIN cl.clienteContactoList cc \n" +
                        "INNER JOIN cc.contacto c \n" +
                        "INNER JOIN c.mediosContacto mc \n" +
                        "LEFT JOIN mc.mail m \n" +
                        "LEFT JOIN mc.telefono t \n" +
                        "INNER JOIN cl.clienteDomiciliosList cd \n" +
                        "INNER JOIN cd.domicilio d \n" +
                        "WHERE cl.id = :idCliente", Cliente.class)
                .setParameter("idCliente", idCliente)
                .getSingleResult();
        });
    }
    
    public Cliente buscarPorCodigoUnico(String codigoUnico) throws CoreException 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("Cliente.findByCodUnico", Cliente.class)
                .setParameter("codUnico", codigoUnico)
                .getSingleResult()
        );
    }

}
