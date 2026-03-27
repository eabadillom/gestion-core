package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Servicio;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServicioDAO extends BaseDAO<Servicio, Integer> 
{
    private static Logger log = LogManager.getLogger(TipoAsentamientoDAO.class);
    
    public ServicioDAO() {
        super(Servicio.class);
    }

    public List<Servicio> buscarTodos() {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("Servicio.findAll", Servicio.class)
                .getResultList()
        );
    }
}
