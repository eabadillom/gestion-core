package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.TipoTelefono;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

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
