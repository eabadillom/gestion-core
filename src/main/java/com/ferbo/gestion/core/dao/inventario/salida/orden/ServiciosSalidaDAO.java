package com.ferbo.gestion.core.dao.inventario.salida.orden;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.inventario.salida.orden.ServiciosSalida;

public class ServiciosSalidaDAO extends BaseDAO<ServiciosSalida, Integer>
{
    private static Logger log = LogManager.getLogger(ServiciosSalidaDAO.class);
    
    public ServiciosSalidaDAO(TransactionManager transactManager){
        super(ServiciosSalida.class, transactManager);
    }
    
    public List<ServiciosSalida> buscarPorFolioSalida(String folioSalida) {
        return transactManager.executeRead(em ->    
            em.createNamedQuery("ServiciosSalida.findByFolioSalida", ServiciosSalida.class)
                .setParameter("folioSalida", folioSalida)
                .getResultList()
        );
    }
    
}
