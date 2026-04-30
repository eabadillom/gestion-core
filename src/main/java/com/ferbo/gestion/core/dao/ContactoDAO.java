package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Contacto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class ContactoDAO extends BaseDAO<Contacto, Integer>
{
    private static Logger log = LogManager.getLogger(ContactoDAO.class);
    
    public ContactoDAO(TransactionManager executor) {
        super(Contacto.class, executor);
    }
    
}
