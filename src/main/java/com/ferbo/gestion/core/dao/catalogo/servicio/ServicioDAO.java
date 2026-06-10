package com.ferbo.gestion.core.dao.catalogo.servicio;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.dao.domicilio.TipoAsentamientoDAO;
import com.ferbo.gestion.core.model.catalogo.servicio.Servicio;

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
