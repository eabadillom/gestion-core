package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.ConstanciaFactura;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConstanciaFacturaDAO extends BaseDAO<ConstanciaFactura, Integer> 
{	
    private static Logger log = LogManager.getLogger(ConstanciaFacturaDAO.class);

    public ConstanciaFacturaDAO() {
        super(ConstanciaFactura.class);
    }
    
    public List<ConstanciaFactura> buscarPorFolioVigencia(Integer folio, LocalDate vigenciaInicio, LocalDate vigenciaFin) 
    {
        return JpaExecutor.executeRead(em ->
            em.createNamedQuery("ConstanciaFactura.findByFolioVigenciaInicioVigenciaFin", ConstanciaFactura.class)
                .setParameter("folio", folio)
                .setParameter("vigenciaInicio", vigenciaInicio)
                .setParameter("vigenciaFin", vigenciaFin)
                .getResultList()
        );
    }
    
}
