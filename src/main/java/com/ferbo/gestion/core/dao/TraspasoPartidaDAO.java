package com.ferbo.gestion.core.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.TraspasoPartida;

public class TraspasoPartidaDAO extends BaseDAO<TraspasoPartida, Integer>
{
    private static Logger log = LogManager.getLogger(TraspasoPartidaDAO.class);

    public TraspasoPartidaDAO(Class<TraspasoPartida> modelClass) {
        super(modelClass);
    }
}
