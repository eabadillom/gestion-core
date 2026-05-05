package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Cliente;
import com.ferbo.gestion.core.model.Factura;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class FacturaDAO extends BaseDAO <Factura, Integer>
{
    private static Logger log = LogManager.getLogger(FacturaDAO.class);

    public FacturaDAO(TransactionManager transactManager){
        super(Factura.class, transactManager);
    }
}
