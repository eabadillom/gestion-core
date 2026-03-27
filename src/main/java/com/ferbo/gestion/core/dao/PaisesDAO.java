package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Paises;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaisesDAO extends BaseDAO<Paises, Integer> 
{
    Logger log = LogManager.getLogger(PaisesDAO.class);
    
    public PaisesDAO(Class<Paises> modelClass) {
        super(modelClass);
    }

    public PaisesDAO() {
        super(Paises.class);
    }
    
    public Paises buscarUltimoPais()
    {
        return JpaExecutor.executeRead(em -> {
            TypedQuery<Paises> query = em.createQuery(
                "SELECT p FROM Paises p ORDER BY p.id DESC", Paises.class
            );
            query.setMaxResults(1);
            return query.getSingleResult();
        });
    }
    
    public Paises buscarPorClave(String clave) 
    {
        return JpaExecutor.executeRead(em ->
            em.createNamedQuery("Paises.findByPaisDsCorta", this.modelClass)
                .setParameter("paisDsCorta", clave)
                .getSingleResult()
        );
    }
    
    public List<Paises> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("Paises.findAll", Paises.class)
                .getResultList()
        );
    }
    
}
