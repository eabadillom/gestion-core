package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.StatusSalida;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class StatusSalidaDAO extends BaseDAO<StatusSalida, Integer> 
{
    private static Logger log = LogManager.getLogger(StatusSalidaDAO.class);

    public StatusSalidaDAO(TransactionManager transactManager) {
        super(StatusSalida.class, transactManager);
    }
    
    public List<StatusSalida> buscarTodos() {
        return transactManager.executeRead(em ->
            em.createNamedQuery("StatusSalida.findAll", StatusSalida.class)
                .getResultList()
        );
    }
    
    public StatusSalida buscarPorClave(String clave) 
    {
        return transactManager.executeRead(em ->    
            em.createNamedQuery("StatusSalida.findByClave", StatusSalida.class)
                .setParameter("clave", clave)
                .getSingleResult()
        );
        
    }
    
}
