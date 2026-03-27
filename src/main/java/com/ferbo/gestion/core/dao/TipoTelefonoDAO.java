package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.TipoTelefono;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TipoTelefonoDAO extends BaseDAO<TipoTelefono, Integer> 
{
    private static Logger log = LogManager.getLogger(TipoTelefonoDAO.class);

    public TipoTelefonoDAO() {
        super(TipoTelefono.class);
    }

    public List<TipoTelefono> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("TipoTelefono.findAll", TipoTelefono.class)
                .getResultList()
        );
    }
    
}
