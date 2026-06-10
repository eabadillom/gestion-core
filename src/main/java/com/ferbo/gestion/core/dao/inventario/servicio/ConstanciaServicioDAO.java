package com.ferbo.gestion.core.dao.inventario.servicio;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.inventario.servicio.ConstanciaServicio;

public class ConstanciaServicioDAO extends BaseDAO<ConstanciaServicio, Integer>
{
    private static Logger log = LogManager.getLogger(ConstanciaServicioDAO.class);

    public ConstanciaServicioDAO(TransactionManager transactManager) {
        super(ConstanciaServicio.class, transactManager);
    }

    public List<ConstanciaServicio> buscarPorFolioCliente(String folioCliente) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("ConstanciaServicio.findByFolioCliente", ConstanciaServicio.class)
                .setParameter("folioCliente", folioCliente)
                .getResultList()
        );
    }
    
}
