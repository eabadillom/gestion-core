package com.ferbo.gestion.core.dao.pago;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.config.TransactionManager;

public class SerieComplementoPagoStatusDAO extends BaseDAO<SerieComplementoPagoStatusDAO, Integer> {

	public SerieComplementoPagoStatusDAO(TransactionManager transactManager) {
		super(SerieComplementoPagoStatusDAO.class, transactManager);
	}
}
