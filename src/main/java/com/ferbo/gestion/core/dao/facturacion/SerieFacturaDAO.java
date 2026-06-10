package com.ferbo.gestion.core.dao.facturacion;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.facturacion.Emisor;
import com.ferbo.gestion.core.model.facturacion.SerieFactura;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class SerieFacturaDAO extends BaseDAO<SerieFactura, Integer>
{
    private static Logger log = LogManager.getLogger(SerieFacturaDAO.class);

    public SerieFacturaDAO(TransactionManager transactManager) {
        super(SerieFactura.class, transactManager);
    }
    
    public List<SerieFactura> buscarTodos() 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("SerieFactura.findAll", SerieFactura.class)
                .getResultList()
        );
    }
    
    public List<SerieFactura> buscarPorEmisor(Emisor emisor) 
    {
        return transactManager.executeRead(em ->
            em.createNamedQuery("SerieFactura.findByEmisor", SerieFactura.class)
                .setParameter("idEmisor", emisor.getId())
                .getResultList()
        );
    }
    
}
