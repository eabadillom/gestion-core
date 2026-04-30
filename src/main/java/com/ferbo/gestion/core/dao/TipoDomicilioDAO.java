package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.TipoDomicilio;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TipoDomicilioDAO extends BaseDAO<TipoDomicilio, Integer> 
{
    private static Logger log = LogManager.getLogger(TipoDomicilio.class);

    public TipoDomicilioDAO() {
        super(TipoDomicilio.class);
    }

    public List<TipoDomicilio> buscarTodos() 
    {    
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("TiposDomicilio.findAll", TipoDomicilio.class)
                .getResultList()
        );
    }
    
}
