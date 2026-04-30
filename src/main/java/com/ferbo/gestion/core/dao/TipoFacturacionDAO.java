package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.TipoFacturacion;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class TipoFacturacionDAO extends BaseDAO<TipoFacturacion, Integer> 
{
    private static Logger log = LogManager.getLogger(TipoFacturacionDAO.class);

    public TipoFacturacionDAO(TransactionManager transactManager) {
        super(TipoFacturacion.class, transactManager);
    }
    
    public List<TipoFacturacion> buscarTodos()
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("TipoFacturacion.findAll", TipoFacturacion.class)
                .getResultList()
        );
    }
    
}
