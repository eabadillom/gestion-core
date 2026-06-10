package com.ferbo.gestion.core.dao.pago;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.pago.TipoPago;

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
