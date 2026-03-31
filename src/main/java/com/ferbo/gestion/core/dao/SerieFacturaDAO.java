package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Emisor;
import com.ferbo.gestion.core.model.SerieFactura;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SerieFacturaDAO extends BaseDAO<SerieFactura, Integer>
{
    private static Logger log = LogManager.getLogger(SerieFacturaDAO.class);

    public SerieFacturaDAO() {
        super(SerieFactura.class);
    }
    
    public List<SerieFactura> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("SerieFactura.findAll", SerieFactura.class)
                .getResultList()
        );
    }
    
    public List<SerieFactura> buscarPorEmisor(Emisor emisor) 
    {
        return JpaExecutor.executeRead(em ->
            em.createNamedQuery("SerieFactura.findByEmisor", SerieFactura.class)
                .setParameter("idEmisor", emisor.getId())
                .getResultList()
        );
    }
    
}
