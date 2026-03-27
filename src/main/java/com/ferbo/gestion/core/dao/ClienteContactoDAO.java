package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Cliente;
import com.ferbo.gestion.core.model.ClienteContacto;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClienteContactoDAO extends BaseDAO<ClienteContacto, Integer>
{
    private static Logger log = LogManager.getLogger(ClienteContactoDAO.class);

    public ClienteContactoDAO() {
        super(ClienteContacto.class);
    }
    
    public List<ClienteContacto> obtenerPorIdCliente(Cliente cliente) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("ClienteContacto.findAllByIdCliente", ClienteContacto.class)
                .setParameter("idCliente", cliente.getId())
                .getResultList()
        );
    }
    
}
