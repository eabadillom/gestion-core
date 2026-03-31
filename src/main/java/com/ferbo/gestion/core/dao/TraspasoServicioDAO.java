package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.ConstanciaTraspaso;
import com.ferbo.gestion.core.model.TraspasoServicio;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TraspasoServicioDAO extends BaseDAO<TraspasoServicio, Integer>
{	
    private static Logger log = LogManager.getLogger(TraspasoServicioDAO.class);

    public TraspasoServicioDAO() {
        super(TraspasoServicio.class);
    }
    
    public List<TraspasoServicio> buscarPorConstancia(ConstanciaTraspaso ct) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("TraspasoServicio.findByTraspaso", TraspasoServicio.class)
                .setParameter("idTraspaso", ct.getId())
                .getResultList()
        );
    }
    
}
