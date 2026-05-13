package com.ferbo.gestion.core.dao.inventario.salida;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.inventario.salida.StatusConstanciaSalida;

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
