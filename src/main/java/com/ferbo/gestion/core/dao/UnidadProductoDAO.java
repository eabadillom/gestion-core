package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.UnidadProducto;

public class UnidadProductoDAO extends BaseDAO<UnidadProducto, Integer> {

	public UnidadProductoDAO(TransactionManager transactManager) {
		super(UnidadProducto.class, transactManager);
		// TODO Auto-generated constructor stub
	}
	
	

}
