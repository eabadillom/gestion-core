package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Servicio;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class ServicioDAO extends BaseDAO<Servicio, Integer> 
{
    private static Logger log = LogManager.getLogger(TipoAsentamientoDAO.class);
    
    public ServicioDAO(TransactionManager transactManager) {
        super(Servicio.class, transactManager);
    }

    public List<Servicio> buscarTodos() {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("Servicio.findAll", Servicio.class)
                .getResultList()
        );
    }
}
