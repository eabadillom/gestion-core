package com.ferbo.gestion.core.dao.cliente.contacto;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.dao.inventario.entrada.orden.IngresoServicioDAO;
import com.ferbo.gestion.core.model.cliente.contacto.Mail;

public class MailDAO extends BaseDAO<Mail, Integer>
{
    private static Logger log = LogManager.getLogger(IngresoServicioDAO.class);

    public MailDAO(TransactionManager executor) {
        super(Mail.class, executor);
    }
    
}
