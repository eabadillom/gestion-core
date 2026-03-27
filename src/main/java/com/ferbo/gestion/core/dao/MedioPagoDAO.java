package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.MedioPago;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MedioPagoDAO extends BaseDAO<MedioPago, Integer> 
{
    private static Logger log = LogManager.getLogger(MedioPagoDAO.class);

    public MedioPagoDAO() {
        super(MedioPago.class);
    }

    public List<MedioPago> buscarVigentes(LocalDate fecha) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("MedioPago.findVigentes", MedioPago.class)
                .setParameter("fecha", fecha)
                .getResultList()
        );
    }

}
