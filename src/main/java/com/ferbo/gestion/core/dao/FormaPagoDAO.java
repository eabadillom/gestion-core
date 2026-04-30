package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.FormaPago;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FormaPagoDAO extends BaseDAO<FormaPago, Integer> 
{
    private static Logger log = LogManager.getLogger(FormaPagoDAO.class);

    public FormaPagoDAO() {
        super(FormaPago.class);
    }

    public List<FormaPago> buscarVigentes(LocalDate fecha) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("FormaPago.findVigentes", FormaPago.class)
                .setParameter("fecha", fecha)
                .getResultList()
        );
    }

}
