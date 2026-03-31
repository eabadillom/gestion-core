package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.TipoPago;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TipoPagoDAO extends BaseDAO<TipoPago, Integer> 
{
    private static Logger log = LogManager.getLogger(TipoPagoDAO.class);

    public TipoPagoDAO(Class<TipoPago> modelClass) {
        super(modelClass);
    }
    
    public List<TipoPago> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("TipoPago.findAll", TipoPago.class)
                .getResultList()
        );
    }
    
}
