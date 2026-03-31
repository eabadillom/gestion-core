package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.SerieNota;
import com.ferbo.gestion.core.model.StatusSerie;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SerieNotaDAO extends BaseDAO<SerieNota, Integer>
{
    private static Logger log = LogManager.getLogger(SerieNotaDAO.class);

    public SerieNotaDAO() {
        super(SerieNota.class);
    }
    
    public List<SerieNota> buscarTodos() {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("SerieNota.findAll", SerieNota.class)
                .getResultList()
        );
    }

    public List<StatusSerie> buscarTodosStatusSerie() {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("StatusSerie.findAll", StatusSerie.class)
                .getResultList()
        );
    }
    
}
