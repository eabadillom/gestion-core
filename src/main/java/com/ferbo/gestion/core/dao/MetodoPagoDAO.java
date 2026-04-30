package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.MetodoPago;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MetodoPagoDAO extends BaseDAO<MetodoPago, Integer> 
{
    private static Logger log = LogManager.getLogger(MetodoPago.class);

    public MetodoPagoDAO() {
        super(MetodoPago.class);
    }
    
    public List<MetodoPago> buscarVigentes(LocalDate fecha) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("MetodoPago.findVigentes", MetodoPago.class)
                .setParameter("fecha", fecha)
                .getResultList()
        );
    }
    
}
