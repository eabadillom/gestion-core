package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.TipoFacturacion;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TipoFacturacionDAO extends BaseDAO<TipoFacturacion, Integer> 
{
    private static Logger log = LogManager.getLogger(TipoFacturacionDAO.class);

    public TipoFacturacionDAO() {
        super(TipoFacturacion.class);
    }
    
    public List<TipoFacturacion> buscarTodos()
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("TipoFacturacion.findAll", TipoFacturacion.class)
                .getResultList()
        );
    }
    
}
