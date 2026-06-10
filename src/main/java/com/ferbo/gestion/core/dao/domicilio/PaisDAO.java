package com.ferbo.gestion.core.dao.domicilio;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.domicilio.Pais;

public class PaisDAO extends BaseDAO<Pais, Integer>
{
    private static Logger log = LogManager.getLogger(PaisDAO.class);
    
    public PaisDAO(TransactionManager executor){
        super(Pais.class, executor);
    }
    
}
