package com.ferbo.gestion.core.dao.inventario.traspaso;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.inventario.traspaso.ConstanciaTraspaso;
import com.ferbo.gestion.core.model.inventario.traspaso.TraspasoServicio;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class TraspasoServicioDAO extends BaseDAO<TraspasoServicio, Integer>
{	
    private static Logger log = LogManager.getLogger(TraspasoServicioDAO.class);

    public TraspasoServicioDAO(TransactionManager transactManager) {
        super(TraspasoServicio.class, transactManager);
    }
    
    public List<TraspasoServicio> buscarPorConstancia(ConstanciaTraspaso ct) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("TraspasoServicio.findByTraspaso", TraspasoServicio.class)
                .setParameter("idTraspaso", ct.getId())
                .getResultList()
        );
    }
    
}
