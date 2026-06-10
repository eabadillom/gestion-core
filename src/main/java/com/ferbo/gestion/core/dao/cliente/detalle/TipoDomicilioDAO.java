package com.ferbo.gestion.core.dao.cliente.detalle;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.cliente.detalle.TipoDomicilio;

public class TipoDomicilioDAO extends BaseDAO<TipoDomicilio, Integer> 
{
    private static Logger log = LogManager.getLogger(TipoDomicilio.class);

    public TipoDomicilioDAO(TransactionManager transactManager) {
        super(TipoDomicilio.class, transactManager);
    }

    public List<TipoDomicilio> buscarTodos() 
    {    
        return transactManager.executeRead(em -> 
            em.createNamedQuery("TiposDomicilio.findAll", TipoDomicilio.class)
                .getResultList()
        );
    }
    
}
