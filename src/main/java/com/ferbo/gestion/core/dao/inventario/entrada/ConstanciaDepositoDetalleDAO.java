package com.ferbo.gestion.core.dao.inventario.entrada;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.inventario.entrada.ConstanciaDepositoDetalle;

public class ConstanciaDepositoDetalleDAO extends BaseDAO<ConstanciaDepositoDetalle,Integer> 
{
    private static Logger log = LogManager.getLogger(ConstanciaDepositoDetalleDAO.class);

    public ConstanciaDepositoDetalleDAO(TransactionManager executor) {
        super(ConstanciaDepositoDetalle.class, executor);
    }
    
}
