package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Pais;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaisDAO extends BaseDAO<Pais, Integer>
{
    private static Logger log = LogManager.getLogger(PaisDAO.class);
    
    public PaisDAO(Class<Pais> modelClass) {
        super(modelClass);
    }
    
    public PaisDAO(){
        super(Pais.class);
    }
    
}
