package com.ferbo.gestion.core.dao.facturacion.notacredito;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.facturacion.notacredito.NotaCredito;

public class NotaCreditoDAO extends BaseDAO<NotaCredito, Integer>
{
    private static Logger log = LogManager.getLogger(NotaCreditoDAO.class);

    public NotaCreditoDAO(TransactionManager transactManager) {
        super(NotaCredito.class, transactManager);
    }
    
    public List<NotaCredito> buscarTodos()
    {
        return transactManager.executeRead(em ->
            em.createNamedQuery("NotaCredito.findAll", NotaCredito.class)
                .getResultList()
        );
    }
    
    public List<NotaCredito> buscarPorPeriodoCliente(LocalDate fechaInicio, LocalDate fechaFin, Integer idCliente) {
        return transactManager.executeRead(em ->
            em.createNamedQuery("NotaCredito.findByPeriodoCliente", NotaCredito.class)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .setParameter("idCliente", idCliente)
                .getResultList()
        );
    }
    
}
