package com.ferbo.gestion.core.dao.cliente.contacto;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.cliente.contacto.TipoTelefono;

public class TipoTelefonoDAO extends BaseDAO<TipoTelefono, Integer> 
{
    private static Logger log = LogManager.getLogger(TipoTelefonoDAO.class);

    public TipoTelefonoDAO(TransactionManager transactManager) {
        super(TipoTelefono.class, transactManager);
    }

    public List<TipoTelefono> buscarTodos() 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("TipoTelefono.findAll", TipoTelefono.class)
                .getResultList()
        );
    }
    
}
