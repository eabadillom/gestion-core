package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.TipoMovimiento;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TipoMovimientoDAO extends BaseDAO<TipoMovimiento, Integer> 
{
    private static Logger log = LogManager.getLogger(TipoMovimientoDAO.class);

    public TipoMovimientoDAO() {
        super(TipoMovimiento.class);
    }
    
    public List<TipoMovimiento> buscarTodos() {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("TipoMovimiento.findAll", TipoMovimiento.class)
                .getResultList()
        );
    }
    
}
