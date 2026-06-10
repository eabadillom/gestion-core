package com.ferbo.gestion.core.dao.catalogo.sat;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.catalogo.sat.RegimenFiscal;

public class RegimenFiscalDAO extends BaseDAO<RegimenFiscal, Integer> 
{
    private static Logger log = LogManager.getLogger(RegimenFiscalDAO.class);

    public RegimenFiscalDAO(TransactionManager transactManager) {
        super(RegimenFiscal.class, transactManager);
    }
    
    public List<RegimenFiscal> buscarTodos()
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("RegimenFiscal.findAll", RegimenFiscal.class)
                .getResultList()
        );
    }

    public List<RegimenFiscal> buscarPorTipoPersona(String tipoPersona) 
    {
        return transactManager.executeRead(em -> {
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
