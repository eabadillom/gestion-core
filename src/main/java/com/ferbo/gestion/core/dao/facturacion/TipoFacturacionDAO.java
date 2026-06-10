package com.ferbo.gestion.core.dao.facturacion;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.facturacion.TipoFacturacion;

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
