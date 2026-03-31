package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.StatusConstanciaSalida;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StatusConstanciaSalidaDAO extends BaseDAO<StatusConstanciaSalida, Integer> 
{	
    private static Logger log = LogManager.getLogger(StatusConstanciaSalidaDAO.class);

    public StatusConstanciaSalidaDAO() {
        super(StatusConstanciaSalida.class);
    }
    
    public List<StatusConstanciaSalida> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("StatusConstanciaSalida.findAll", StatusConstanciaSalida.class)
                .getResultList()
        );
    }
    
}
