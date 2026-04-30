package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.MetodoPago;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class MetodoPagoDAO extends BaseDAO<MetodoPago, Integer> 
{
    private static Logger log = LogManager.getLogger(MetodoPago.class);

    public MetodoPagoDAO(TransactionManager transactManager) {
        super(MetodoPago.class, transactManager);
    }
    
    public List<MetodoPago> buscarVigentes(LocalDate fecha) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("MetodoPago.buscarVigentes", MetodoPago.class)
                .setParameter("fecha", fecha)
                .getResultList()
        );
    }
    
}
