package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.TipoCobro;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TipoCobroDAO extends BaseDAO<TipoCobro, Integer> 
{
    private static Logger log = LogManager.getLogger(TipoCobroDAO.class);

    public TipoCobroDAO() {
        super(TipoCobro.class);
    }
    
    public List<TipoCobro> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("TipoCobro.findAll", TipoCobro.class)
                .getResultList()
        );
    }
    
}
