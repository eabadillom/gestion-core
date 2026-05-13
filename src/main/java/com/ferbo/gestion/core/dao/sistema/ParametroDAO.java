package com.ferbo.gestion.core.dao.sistema;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.sistema.Parametro;

public class ParametroDAO extends BaseDAO<Parametro,Integer>
{
    private static Logger log = LogManager.getLogger(ParametroDAO.class);

    public ParametroDAO(TransactionManager transactManager) {
        super(Parametro.class, transactManager);
    }
    
    public Parametro buscarPorNombre(String nombre) 
    {
        return transactManager.executeRead(em ->
            em.createNamedQuery("Parametro.findByNombre", Parametro.class)
                .setParameter("nombre", nombre).getSingleResult()
        );
    }
    
    public List<Parametro> buscarTodos() {
        return transactManager.executeRead(em ->
            em.createNamedQuery("Parametro.findAll", Parametro.class).getResultList()
        );
    }
    
}
