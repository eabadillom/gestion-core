package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.UnidadManejo;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UnidadManejoDAO extends BaseDAO<UnidadManejo, Integer> 
{
    private static Logger log = LogManager.getLogger(UnidadManejoDAO.class);

    public UnidadManejoDAO() {
        super(UnidadManejo.class);
    }

    public List<UnidadManejo> buscarTodos()  {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("UnidadManejo.findAll", UnidadManejo.class)
                .getResultList()
        );
    }

}
