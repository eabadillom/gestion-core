package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.UsoCfdi;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsoCfdiDAO extends BaseDAO<UsoCfdi, Integer> 
{
    private static Logger log = LogManager.getLogger(UsoCfdiDAO.class);

    public UsoCfdiDAO() {
        super(UsoCfdi.class);
    }

    public List<UsoCfdi> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("UsoCfdi.findAll", UsoCfdi.class)
                .getResultList()
        );
    }

    public List<UsoCfdi> buscarUsoCfdiPorTipoPersona(String tipoPersona) 
    {
        return JpaExecutor.executeRead(em -> {
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
