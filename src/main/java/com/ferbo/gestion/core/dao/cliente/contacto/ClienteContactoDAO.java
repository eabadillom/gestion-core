package com.ferbo.gestion.core.dao.cliente.contacto;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.cliente.Cliente;
import com.ferbo.gestion.core.model.cliente.contacto.ClienteContacto;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class ClienteContactoDAO extends BaseDAO<ClienteContacto, Integer>
{
    private static Logger log = LogManager.getLogger(ClienteContactoDAO.class);

    public ClienteContactoDAO(TransactionManager transactManager) {
        super(ClienteContacto.class, transactManager);
    }
    
    public List<ClienteContacto> obtenerPorIdCliente(Cliente cliente) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("ClienteContacto.findAllByIdCliente", ClienteContacto.class)
                .setParameter("idCliente", cliente.getId())
                .getResultList()
        );
    }
    
}
