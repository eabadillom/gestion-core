package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.TipoMail;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class TipoMailDAO extends BaseDAO <TipoMail, Integer>
{
    private static Logger log = LogManager.getLogger(TipoMailDAO.class);

    public TipoMailDAO(TransactionManager transactManager) {
        super(TipoMail.class, transactManager);
    }
    
    public List<TipoMail> buscarTodos() 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("TipoMail.findAll", TipoMail.class)
                .getResultList()
        );
    }
    
}
