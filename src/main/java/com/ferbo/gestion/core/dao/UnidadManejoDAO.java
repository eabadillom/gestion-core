package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.UnidadManejo;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class UnidadManejoDAO extends BaseDAO<UnidadManejo, Integer> 
{
    private static Logger log = LogManager.getLogger(UnidadManejoDAO.class);

    public UnidadManejoDAO(TransactionManager transactManager) {
        super(UnidadManejo.class, transactManager);
    }

    public List<UnidadManejo> buscarTodos()  {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("UnidadManejo.findAll", UnidadManejo.class)
                .getResultList()
        );
    }

}
