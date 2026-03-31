package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Cliente;
import com.ferbo.gestion.core.model.Pago;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PagoDAO extends BaseDAO<Pago, Integer> 
{
    private static Logger log = LogManager.getLogger(PagoDAO.class);

    public PagoDAO() {
        super(Pago.class);
    }
    
    public List<Pago> buscarTodos() {
        return JpaExecutor.executeRead(em ->
            em.createNamedQuery("Pago.findAll", Pago.class)
                .getResultList()
        );
    }
    
    public List<Pago> buscarPorFactura(Integer id) 
    {
        return JpaExecutor.executeRead(em ->
            em.createNamedQuery("Pago.findByFacturaId", Pago.class)
                .setParameter("facturaId", id)
                .getResultList()
        );
    }
    
    public List<Pago> buscaPorClienteFechas(Cliente c, LocalDate startDate, LocalDate endDate) {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("Pago.findByClienteFechas", Pago.class).setParameter("idCliente", (c == null ? null : c.getId()))
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList()
        );
    }
    
}
