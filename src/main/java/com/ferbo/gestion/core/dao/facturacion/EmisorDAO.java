package com.ferbo.gestion.core.dao.facturacion;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.facturacion.Emisor;

public class EmisorDAO extends BaseDAO<Emisor, Integer>
{	
    private static Logger log = LogManager.getLogger(EmisorDAO.class);

    public EmisorDAO(TransactionManager transactManager) {
        super(Emisor.class, transactManager);
    }
    
    public List<Emisor> buscarTodos() {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("Emisor.findAll", Emisor.class)
                .getResultList()
        );
    }
    
    public List<Emisor> buscarPorCriterios(Emisor e) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("Emisor.findByRegimenFiscal", Emisor.class)
                .setParameter("regimen", e.getRegimen())
                .getResultList()
        );
    }
    
}
