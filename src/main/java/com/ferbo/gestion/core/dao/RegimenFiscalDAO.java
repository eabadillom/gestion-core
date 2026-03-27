package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.RegimenFiscal;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegimenFiscalDAO extends BaseDAO<RegimenFiscal, Integer> 
{
    private static Logger log = LogManager.getLogger(RegimenFiscalDAO.class);

    public RegimenFiscalDAO() {
        super(RegimenFiscal.class);
    }
    
    public List<RegimenFiscal> buscarTodos()
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("RegimenFiscal.findAll", RegimenFiscal.class)
                .getResultList()
        );
    }

    public List<RegimenFiscal> buscarPorTipoPersona(String tipoPersona) 
    {
        return JpaExecutor.executeRead(em -> {
            String namedQuery;
            if ("F".equalsIgnoreCase(tipoPersona)) {
                namedQuery = "RegimenFiscal.findByst_per_fisica";
            } else if ("M".equalsIgnoreCase(tipoPersona)) {
                namedQuery = "RegimenFiscal.findByst_per_moral";
            } else {
                throw new IllegalStateException("Tipo de persona no válido: " + tipoPersona);
            }
            return em.createNamedQuery(namedQuery, RegimenFiscal.class)
                .getResultList();
        });
    }
    
}
