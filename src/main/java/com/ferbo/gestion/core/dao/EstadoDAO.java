package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Estado;
import com.ferbo.gestion.core.model.EstadoPK;
import com.ferbo.gestion.core.model.Paises;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EstadoDAO extends BaseDAO<Estado, Integer> 
{ 
    private static Logger log = LogManager.getLogger(EstadoDAO.class);

    public EstadoDAO() {
        super(Estado.class);
    }
    
    public Estado buscarPorId(Paises idPais, Integer idEstado) 
    {
        return JpaExecutor.executeRead(em -> 
            em.find(Estado.class, new EstadoPK(idPais, idEstado))
        );
    }
    
    public Estado buscarUltimoEstado(Paises pais)
    {    
        return JpaExecutor.executeRead(em -> {
            TypedQuery<Estado> query = em.createQuery(
                "SELECT e FROM Estado e WHERE e.estadoPK.pais.id = :idPais ORDER BY e.estadoPK.id DESC", Estado.class
            );

            query.setParameter("idPais", pais.getId());
            query.setMaxResults(1);
            return query.getSingleResult();
        });
    }
    
    public List<Estado> buscarPorPais(Paises pais) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("Estado.findByPais", Estado.class)
                .setParameter("idPais", pais.getId())
                .getResultList()
        );
    }
    
}
