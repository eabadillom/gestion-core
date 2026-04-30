package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.ConstanciaDepositoDetalle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class ConstanciaDepositoDetalleDAO extends BaseDAO<ConstanciaDepositoDetalle,Integer> 
{
    private static Logger log = LogManager.getLogger(ConstanciaDepositoDetalleDAO.class);

    public ConstanciaDepositoDetalleDAO(TransactionManager executor) {
        super(ConstanciaDepositoDetalle.class, executor);
    }
    
}
