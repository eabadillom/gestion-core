package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.NotaCredito;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NotaCreditoDAO extends BaseDAO<NotaCredito, Integer>
{
    private static Logger log = LogManager.getLogger(NotaCreditoDAO.class);

    public NotaCreditoDAO() {
        super(NotaCredito.class);
    }
    
    public List<NotaCredito> buscarPorPeriodoCliente(LocalDate fechaInicio, LocalDate fechaFin, Integer idCliente) {
        return JpaExecutor.executeRead(em ->
            em.createNamedQuery("NotaCredito.findByPeriodoCliente", NotaCredito.class)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .setParameter("idCliente", idCliente)
                .getResultList()
        );
    }
    
}
