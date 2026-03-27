package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Categoria;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CategoriaDAO extends BaseDAO<Categoria, Integer> 
{
    private static Logger log = LogManager.getLogger(CategoriaDAO.class);

    public CategoriaDAO() {
        super(Categoria.class);
    }

    public List<Categoria> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("Categoria.findAll", Categoria.class)
                .getResultList()
        );
    }
    
}
