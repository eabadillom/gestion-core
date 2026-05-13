package com.ferbo.gestion.core.dao.facturacion.detalle;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.facturacion.detalle.ConstanciaFactura;

public class ConstanciaFacturaDAO extends BaseDAO<ConstanciaFactura, Integer> 
{	
    private static Logger log = LogManager.getLogger(ConstanciaFacturaDAO.class);

    public ConstanciaFacturaDAO(TransactionManager transactManager) {
        super(ConstanciaFactura.class, transactManager);
    }
    
    public List<ConstanciaFactura> buscarPorFolioVigencia(Integer folio, LocalDate vigenciaInicio, LocalDate vigenciaFin) 
    {
        return transactManager.executeRead(em ->
            em.createNamedQuery("ConstanciaFactura.findByFolioVigenciaInicioVigenciaFin", ConstanciaFactura.class)
                .setParameter("folio", folio)
                .setParameter("vigenciaInicio", vigenciaInicio)
                .setParameter("vigenciaFin", vigenciaFin)
                .getResultList()
        );
    }
    
}
