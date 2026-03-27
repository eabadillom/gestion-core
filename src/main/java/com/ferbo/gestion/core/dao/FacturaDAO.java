package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Cliente;
import com.ferbo.gestion.core.model.Factura;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FacturaDAO extends BaseDAO <Factura, Integer>
{
    private static Logger log = LogManager.getLogger(FacturaDAO.class);

    public FacturaDAO(){
        super(Factura.class);
    }
    
    public List<Factura> obtenerPorFolioDeposito(Integer folio)
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("Factura.findByFolioDeposito", Factura.class)
                .setParameter("folio",folio)
                .getResultList()
        );
    }
    
    public List<Factura> buscaFacturas(Cliente c, LocalDate fechaInicio, LocalDate fechaFin, boolean isFullInfo) 
    {
        return JpaExecutor.executeRead(em -> {
            List<Factura> list = em.createNamedQuery("Factura.findByClientePeriodo", Factura.class)
                .setParameter("cliente", c)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .getResultList();

            if (isFullInfo == false) {
                return list;
            }

            for (Factura factura : list) {
                log.debug("Status id: {}", factura.getStatus().getId());
            }

            return list;
        });
    }
    
    public List<Factura> buscaFacturas(LocalDate fechaInicio, LocalDate fechaFin, boolean isFullInfo) 
    {
        return JpaExecutor.executeRead(em -> {
            List<Factura> list = em.createNamedQuery("Factura.findByPeriodo", Factura.class)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .getResultList();

            if (isFullInfo == false) {
                return list;
            }

            for (Factura factura : list) {
                log.debug("Status id: {}", factura.getStatus().getId());
            }

            return list;
        });
    }
    
    public List<Factura> consultaFacturas(Integer idCliente, LocalDate fechaInicio, LocalDate fechaFin) 
    {
        return JpaExecutor.executeRead(em -> {
            List<Factura> list = em.createNamedQuery("Factura.findByNoCFDI", modelClass)
                .setParameter("idCliente", idCliente)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .getResultList();

            return list;
        });
    }
    
}
