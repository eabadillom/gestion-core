package com.ferbo.gestion.core.dao.cliente.contrato;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.cliente.contrato.Categoria;

public class CategoriaDAO extends BaseDAO<Categoria, Integer> 
{
    private static Logger log = LogManager.getLogger(CategoriaDAO.class);

    public CategoriaDAO(TransactionManager transactManager) {
        super(Categoria.class, transactManager);
    }

    public List<Categoria> buscarTodos() 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("Categoria.findAll", Categoria.class)
                .getResultList()
        );
    }
    
}
