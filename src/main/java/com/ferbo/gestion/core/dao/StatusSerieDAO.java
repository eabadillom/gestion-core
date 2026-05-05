package com.ferbo.gestion.core.dao;

import java.util.List;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.StatusSerie;

public class StatusSerieDAO extends BaseDAO<StatusSerie, Integer> {

	public StatusSerieDAO(TransactionManager transactManager) {
		super(StatusSerie.class, transactManager);
	}
	
	public List<StatusSerie> buscarTodos() {
		return transactManager.executeRead(em -> 
        em.createNamedQuery("StatusSerie.findAll", StatusSerie.class)
            .getResultList()
    );
	}

}
