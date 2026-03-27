package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.TipoAsentamiento;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TipoAsentamientoDAO extends BaseDAO<TipoAsentamiento, Integer> 
{
    private static Logger log = LogManager.getLogger(TipoAsentamientoDAO.class);

    public TipoAsentamientoDAO() {
        super(TipoAsentamiento.class);
    }
    
    public List<TipoAsentamiento> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("TipoAsentamiento.findAll", TipoAsentamiento.class)
                .getResultList()
        );
    }
    
    public TipoAsentamiento buscarUltimoTipoAsentamiento()
    {
        return JpaExecutor.executeRead(em -> {
            TypedQuery<TipoAsentamiento> query = em.createQuery(
                "SELECT ta FROM TipoAsentamiento ta ORDER BY ta.id DESC", TipoAsentamiento.class
            );
            
            query.setMaxResults(1);
            return query.getSingleResult();
        });
    }
    
}
