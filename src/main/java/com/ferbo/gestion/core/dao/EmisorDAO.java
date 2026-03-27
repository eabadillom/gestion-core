package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Emisor;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmisorDAO extends BaseDAO<Emisor, Integer>
{	
    private static Logger log = LogManager.getLogger(EmisorDAO.class);

    public EmisorDAO() {
        super(Emisor.class);
    }
    
    public List<Emisor> buscarTodos() {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("Emisor.findAll", Emisor.class)
                .getResultList()
        );
    }
    
    public List<Emisor> buscarPorCriterios(Emisor e) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("Emisor.findByRegimenFiscal", Emisor.class)
                .setParameter("regimen", e.getRegimen())
                .getResultList()
        );
    }
    
}
