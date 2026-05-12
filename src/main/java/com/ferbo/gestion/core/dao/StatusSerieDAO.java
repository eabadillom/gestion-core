package com.ferbo.gestion.core.dao;

import java.util.List;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.StatusSerie;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StatusSerieDAO extends BaseDAO<StatusSerie, Integer> 
{
    private static Logger log = LogManager.getLogger(StatusSerieDAO.class);

    public StatusSerieDAO(TransactionManager transactManager) {
        super(StatusSerie.class, transactManager);
    }

    public List<StatusSerie> buscarTodos() {
        return transactManager.executeRead(em
                -> em.createNamedQuery("StatusSerie.findAll", StatusSerie.class)
                        .getResultList()
        );
    }

}
