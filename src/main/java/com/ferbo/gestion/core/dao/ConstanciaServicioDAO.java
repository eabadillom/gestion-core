package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.ConstanciaDeServicio;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConstanciaServicioDAO extends BaseDAO<ConstanciaDeServicio, Integer>
{
    private static Logger log = LogManager.getLogger(ConstanciaServicioDAO.class);

    public ConstanciaServicioDAO() {
        super(ConstanciaDeServicio.class);
    }

    public List<ConstanciaDeServicio> buscarPorFolioCliente(String folioCliente) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("ConstanciaDeServicio.findByFolioCliente", ConstanciaDeServicio.class)
                .setParameter("folioCliente", folioCliente)
                .getResultList()
        );
    }
    
}
