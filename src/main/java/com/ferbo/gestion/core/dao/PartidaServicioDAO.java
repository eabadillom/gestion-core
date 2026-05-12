package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.PartidaServicio;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class PartidaServicioDAO extends BaseDAO<PartidaServicio, Integer>
{
    private static Logger log = LogManager.getLogger(PartidaServicioDAO.class);

    public PartidaServicioDAO(TransactionManager transactManager) {
        super(PartidaServicio.class, transactManager);
    }
    
    public List<PartidaServicio> buscarTodos() 
    {
        return transactManager.executeRead(em ->
            em.createNamedQuery("PartidaServicio.findAll", PartidaServicio.class)
                .getResultList()
        );
    }
    
    public List<PartidaServicio> buscarPorFolio(Integer folio) {
        return transactManager.executeRead(em ->
            em.createNamedQuery("PartidaServicio.findByFolio", PartidaServicio.class)
                .setParameter("folio", folio)
                .getResultList()
        );
    }
    
}
