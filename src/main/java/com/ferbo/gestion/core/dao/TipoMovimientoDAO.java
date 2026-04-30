package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.TipoMovimiento;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class TipoMovimientoDAO extends BaseDAO<TipoMovimiento, Integer> 
{
    private static Logger log = LogManager.getLogger(TipoMovimientoDAO.class);

    public TipoMovimientoDAO(TransactionManager transactManager) {
        super(TipoMovimiento.class, transactManager);
    }
    
    public List<TipoMovimiento> buscarTodos() {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("TipoMovimiento.findAll", TipoMovimiento.class)
                .getResultList()
        );
    }
    
}
