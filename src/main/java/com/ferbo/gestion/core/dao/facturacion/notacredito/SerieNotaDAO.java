package com.ferbo.gestion.core.dao.facturacion.notacredito;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.facturacion.StatusSerie;
import com.ferbo.gestion.core.model.facturacion.notacredito.SerieNota;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class SerieNotaDAO extends BaseDAO<SerieNota, Integer>
{
    private static Logger log = LogManager.getLogger(SerieNotaDAO.class);

    public SerieNotaDAO(TransactionManager transactManager) {
        super(SerieNota.class, transactManager);
    }
    
    public List<SerieNota> buscarTodos() {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("SerieNota.findAll", SerieNota.class)
                .getResultList()
        );
    }

    public List<StatusSerie> buscarTodosStatusSerie() {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("StatusSerie.findAll", StatusSerie.class)
                .getResultList()
        );
    }
    
}
