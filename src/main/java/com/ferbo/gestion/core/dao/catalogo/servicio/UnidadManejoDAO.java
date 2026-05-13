package com.ferbo.gestion.core.dao.catalogo.servicio;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.catalogo.servicio.UnidadManejo;

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
