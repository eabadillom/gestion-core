package com.ferbo.gestion.core.dao.catalogo.sat;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.catalogo.sat.UsoCfdi;

public class UsoCfdiDAO extends BaseDAO<UsoCfdi, Integer> 
{
    private static Logger log = LogManager.getLogger(UsoCfdiDAO.class);

    public UsoCfdiDAO(TransactionManager transactManager) {
        super(UsoCfdi.class, transactManager);
    }

    public List<UsoCfdi> buscarTodos() 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("UsoCfdi.findAll", UsoCfdi.class)
                .getResultList()
        );
    }

    public List<UsoCfdi> buscarUsoCfdiPorTipoPersona(String tipoPersona) 
    {
        return transactManager.executeRead(em -> {
            String namedQuery;
            if ("F".equalsIgnoreCase(tipoPersona)) {
                namedQuery = "UsoCfdi.findByPersonaFisica";
            } else if ("M".equalsIgnoreCase(tipoPersona)) {
                namedQuery = "UsoCfdi.findByPersonaMoral";
            } else {
                throw new IllegalStateException("Tipo de persona no válido: " + tipoPersona);
            }

            return em.createNamedQuery(namedQuery, UsoCfdi.class).getResultList();
        });
    }

}
