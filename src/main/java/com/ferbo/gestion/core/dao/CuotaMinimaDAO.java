package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.CuotaMinima;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CuotaMinimaDAO extends BaseDAO<CuotaMinima, Integer> 
{
    private static Logger log = LogManager.getLogger(CuotaMinimaDAO.class);

    public CuotaMinimaDAO() {
        super(CuotaMinima.class);
    }
    
    public List<CuotaMinima> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("CuotaMinima.findAll", CuotaMinima.class)
                .getResultList()
        );
    }
    
}
