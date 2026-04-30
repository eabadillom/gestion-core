package com.ferbo.gestion.core.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Aviso;
import com.ferbo.gestion.core.tools.JpaExecutor;

public class AvisoDAO extends BaseDAO<Aviso, Integer> 
{
    private static Logger log = LogManager.getLogger(AvisoDAO.class);

    public AvisoDAO() {
        super(Aviso.class);
    }

    public List<Aviso> buscarPorCliente(Integer idCliente) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("Aviso.findByCliente", Aviso.class)
                .setParameter("idCliente", idCliente)
                .getResultList()
        );
    }
}
