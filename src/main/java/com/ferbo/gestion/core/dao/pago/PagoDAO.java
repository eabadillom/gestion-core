package com.ferbo.gestion.core.dao.pago;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.cliente.Cliente;
import com.ferbo.gestion.core.model.pago.Pago;

import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class PagoDAO extends BaseDAO<Pago, Integer> 
{
    private static Logger log = LogManager.getLogger(PagoDAO.class);

    public PagoDAO(TransactionManager transactManager) {
        super(Pago.class, transactManager);
    }
}
