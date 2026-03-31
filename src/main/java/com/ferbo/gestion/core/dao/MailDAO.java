package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Mail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MailDAO extends BaseDAO<Mail, Integer>
{
    private static Logger log = LogManager.getLogger(IngresoServicioDAO.class);

    public MailDAO() {
        super(Mail.class);
    }
    
}
