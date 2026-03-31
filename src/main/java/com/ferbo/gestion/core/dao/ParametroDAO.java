package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Parametro;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParametroDAO extends BaseDAO<Parametro,Integer>
{
    private static Logger log = LogManager.getLogger(ParametroDAO.class);

    public ParametroDAO() {
        super(Parametro.class);
    }
    
    public Parametro buscarPorNombre(String nombre) 
    {
        return JpaExecutor.executeRead(em ->
            em.createNamedQuery("Parametro.findByNombre", Parametro.class)
                .setParameter("nombre", nombre).getSingleResult()
        );
    }
    
    public List<Parametro> buscarTodos() {
        return JpaExecutor.executeRead(em ->
            em.createNamedQuery("Parametro.findAll", Parametro.class).getResultList()
        );
    }
    
}
