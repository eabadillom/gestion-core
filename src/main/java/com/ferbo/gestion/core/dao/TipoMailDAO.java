package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.TipoMail;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TipoMailDAO extends BaseDAO <TipoMail, Integer>
{
    private static Logger log = LogManager.getLogger(TipoMailDAO.class);

    public TipoMailDAO() {
        super(TipoMail.class);
    }
    
    public List<TipoMail> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("TipoMail.findAll", TipoMail.class)
                .getResultList()
        );
    }
    
}
