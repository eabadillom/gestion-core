package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Tarima;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TarimaDAO extends BaseDAO<Tarima, Integer>
{
    private static Logger log = LogManager.getLogger(TarimaDAO.class);

    public TarimaDAO() {
        super(Tarima.class);
    }
    
}
