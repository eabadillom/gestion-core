package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.PartidaServicio;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PartidaServicioDAO extends BaseDAO<PartidaServicio, Integer>
{
    private static Logger log = LogManager.getLogger(PartidaServicioDAO.class);

    public PartidaServicioDAO() {
        super(PartidaServicio.class);
    }
    
    public List<PartidaServicio> buscarTodos() 
    {
        return JpaExecutor.executeRead(em ->
            em.createNamedQuery("PartidaServicio.findAll", PartidaServicio.class)
                .getResultList()
        );
    }
    
    public List<PartidaServicio> buscarPorFolio(Integer folio) {
        return JpaExecutor.executeRead(em ->
            em.createNamedQuery("PartidaServicio.findByFolio", PartidaServicio.class)
                .setParameter("folio", folio)
                .getResultList()
        );
    }
    
}
