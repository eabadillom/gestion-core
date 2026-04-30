package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Cliente;
import com.ferbo.gestion.core.model.Factura;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class FacturaDAO extends BaseDAO <Factura, Integer>
{
    private static Logger log = LogManager.getLogger(FacturaDAO.class);

    public FacturaDAO(TransactionManager transactManager){
        super(Factura.class, transactManager);
    }
    
    public List<Factura> obtenerPorFolioDeposito(Integer folio)
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("Factura.findByFolioDeposito", Factura.class)
                .setParameter("folio",folio)
                .getResultList()
        );
    }
    
    public List<Factura> buscaFacturas(Cliente c, LocalDate fechaInicio, LocalDate fechaFin, boolean isFullInfo) 
    {
        return transactManager.executeRead(em -> {
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
        return transactManager.executeRead(em -> {
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
        return transactManager.executeRead(em -> {
            List<Factura> list = em.createNamedQuery("Factura.findByNoCFDI", Factura.class)
                .setParameter("idCliente", idCliente)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .getResultList();

            return list;
        });
    }
    
}
