package com.ferbo.gestion.core.dao.catalogo.servicio;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.catalogo.servicio.TipoCobro;

public class TipoCobroDAO extends BaseDAO<TipoCobro, Integer> 
{
    private static Logger log = LogManager.getLogger(TipoCobroDAO.class);

    public TipoCobroDAO(TransactionManager transactManager) {
        super(TipoCobro.class, transactManager);
    }
    
    public List<TipoCobro> buscarTodos() 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("TipoCobro.findAll", TipoCobro.class)
                .getResultList()
        );
    }
    
}
