package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.StatusSalida;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StatusSalidaDAO extends BaseDAO<StatusSalida, Integer> 
{
    private static Logger log = LogManager.getLogger(StatusSalidaDAO.class);

    public StatusSalidaDAO() {
        super(StatusSalida.class);
    }
    
    public List<StatusSalida> buscarTodos() {
        return JpaExecutor.executeRead(em ->
            em.createNamedQuery("StatusSalida.findAll", StatusSalida.class)
                .getResultList()
        );
    }
    
    public StatusSalida buscarPorClave(String clave) 
    {
        return JpaExecutor.executeRead(em ->    
            em.createNamedQuery("StatusSalida.findByClave", StatusSalida.class)
                .setParameter("clave", clave)
                .getSingleResult()
        );
        
    }
    
}
