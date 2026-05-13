package com.ferbo.gestion.core.dao.catalogo.sat;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.catalogo.sat.FormaPago;

public class FormaPagoDAO extends BaseDAO<FormaPago, Integer> 
{
    private static Logger log = LogManager.getLogger(FormaPagoDAO.class);

    public FormaPagoDAO(TransactionManager transactManager) {
        super(FormaPago.class, transactManager);
    }

    public List<FormaPago> buscarVigentes(LocalDate fecha) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("FormaPago.findVigentes", FormaPago.class)
                .setParameter("fecha", fecha)
                .getResultList()
        );
    }

}
