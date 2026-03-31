package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.ServiciosSalida;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServiciosSalidaDAO extends BaseDAO<ServiciosSalida, Integer>
{
    private static Logger log = LogManager.getLogger(ServiciosSalidaDAO.class);
    
    public ServiciosSalidaDAO(){
        super(ServiciosSalida.class);
    }
    
    public List<ServiciosSalida> buscarPorFolioSalida(String folioSalida) {
        return JpaExecutor.executeRead(em ->    
            em.createNamedQuery("ServiciosSalida.findByFolioSalida", ServiciosSalida.class)
                .setParameter("folioSalida", folioSalida)
                .getResultList()
        );
    }
    
}
