package com.ferbo.gestion.core.dao.pago;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.pago.ComplementoPago;

public class ComplementoPagoDAO extends BaseDAO<ComplementoPago, Integer> {

	public ComplementoPagoDAO(TransactionManager transactManager) {
		super(ComplementoPago.class, transactManager);
	}
}
