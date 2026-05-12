package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Mail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class MailDAO extends BaseDAO<Mail, Integer>
{
    private static Logger log = LogManager.getLogger(IngresoServicioDAO.class);

    public MailDAO(TransactionManager executor) {
        super(Mail.class, executor);
    }
    
}
