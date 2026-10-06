package com.ferbo.gestion.core.dao.pago;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.config.TransactionManager;

public class SerieComplementoPagoStatus extends BaseDAO<SerieComplementoPagoStatus, Integer> {

	public SerieComplementoPagoStatus(TransactionManager transactManager) {
		super(SerieComplementoPagoStatus.class, transactManager);
	}
}
