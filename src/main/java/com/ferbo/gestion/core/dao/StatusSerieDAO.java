package com.ferbo.gestion.core.dao;

import java.util.List;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.StatusSerie;
import com.ferbo.gestion.core.tools.JpaExecutor;

public class StatusSerieDAO extends BaseDAO<StatusSerie, Integer> {

	public StatusSerieDAO() {
		super(StatusSerie.class);
	}
	
	public List<StatusSerie> buscarTodos() {
		return JpaExecutor.executeRead(em -> 
        em.createNamedQuery("StatusSerie.findAll", StatusSerie.class)
            .getResultList()
    );
	}

}
