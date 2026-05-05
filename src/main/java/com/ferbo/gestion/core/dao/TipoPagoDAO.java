package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.TipoPago;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class TipoPagoDAO extends BaseDAO<TipoPago, Integer> 
{
    private static Logger log = LogManager.getLogger(TipoPagoDAO.class);

    public TipoPagoDAO(TransactionManager transactManager) {
        super(TipoPago.class, transactManager);
    }
    
    public List<TipoPago> buscarTodos() 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("TipoPago.findAll", TipoPago.class)
                .getResultList()
        );
    }
    
}
