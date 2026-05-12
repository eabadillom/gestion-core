package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Camara;
import com.ferbo.gestion.core.model.Planta;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class CamaraDAO extends BaseDAO<Camara, Integer> 
{
    private static Logger log = LogManager.getLogger(CamaraDAO.class);

    public CamaraDAO(TransactionManager transactManager) {
        super(Camara.class, transactManager);
    }

    public List<Camara> buscarTodos() 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("Camara.findAll", Camara.class)
                .getResultList()
        );
    }
    
    public List<Camara> buscarPorPlanta(Planta p) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("Camara.findByPlanta", Camara.class)
            .setParameter("idPlanta", p.getId())
            .getResultList()
        );
    }

}
