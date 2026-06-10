package com.ferbo.gestion.core.dao.domicilio;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.domicilio.Paises;

public class PaisesDAO extends BaseDAO<Paises, Integer> 
{
    Logger log = LogManager.getLogger(PaisesDAO.class);
    
    public PaisesDAO(TransactionManager transactManager) {
        super(Paises.class, transactManager);
    }
    
    public Paises buscarUltimoPais()
    {
        return transactManager.executeRead(em -> {
            TypedQuery<Paises> query = em.createQuery(
                "SELECT p FROM Paises p ORDER BY p.id DESC", Paises.class
            );
            query.setMaxResults(1);
            return query.getSingleResult();
        });
    }
    
    public Paises buscarPorClave(String clave) 
    {
        return transactManager.executeRead(em ->
            em.createNamedQuery("Paises.findByPaisDsCorta", Paises.class)
                .setParameter("paisDsCorta", clave)
                .getSingleResult()
        );
    }
    
    public List<Paises> buscarTodos() 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("Paises.findAll", Paises.class)
                .getResultList()
        );
    }
    
}
