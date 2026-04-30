package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.StatusConstanciaSalida;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class StatusConstanciaSalidaDAO extends BaseDAO<StatusConstanciaSalida, Integer> 
{	
    private static Logger log = LogManager.getLogger(StatusConstanciaSalidaDAO.class);

    public StatusConstanciaSalidaDAO(TransactionManager transactManager) {
        super(StatusConstanciaSalida.class, transactManager);
    }
    
    public List<StatusConstanciaSalida> buscarTodos() 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("StatusConstanciaSalida.findAll", StatusConstanciaSalida.class)
                .getResultList()
        );
    }
    
}
