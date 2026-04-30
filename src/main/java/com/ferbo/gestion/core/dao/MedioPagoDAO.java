package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.MedioPago;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class MedioPagoDAO extends BaseDAO<MedioPago, Integer> 
{
    private static Logger log = LogManager.getLogger(MedioPagoDAO.class);

    public MedioPagoDAO(TransactionManager transactManager) {
        super(MedioPago.class, transactManager);
    }

    public List<MedioPago> buscarVigentes(LocalDate fecha) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("MedioPago.findVigentes", MedioPago.class)
                .setParameter("fecha", fecha)
                .getResultList()
        );
    }

}
