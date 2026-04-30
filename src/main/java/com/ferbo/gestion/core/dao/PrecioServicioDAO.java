package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.PrecioServicio;
import java.util.List;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class PrecioServicioDAO extends BaseDAO<PrecioServicio, Integer> 
{
    private static Logger log = LogManager.getLogger(PrecioServicioDAO.class);

    public PrecioServicioDAO(TransactionManager transactManager) {
        super(PrecioServicio.class, transactManager);
    }

    public List<PrecioServicio> buscarPorClienteSinAviso(Integer idCliente) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("PrecioServicio.findByClienteSinAviso", PrecioServicio.class)
                .setParameter("idCliente", idCliente)
                .getResultList()
        );
    }

    public List<PrecioServicio> buscarPorClienteConAviso(Integer idCliente, Integer idAviso) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("PrecioServicio.findByClienteAviso", PrecioServicio.class)
                .setParameter("idCliente", idCliente)
                .setParameter("idAviso", idAviso)
                .getResultList()
        );
    }
    
    public List<PrecioServicio> buscarPorCliente(Integer idCliente) 
    {
        return transactManager.executeRead(em -> {
            TypedQuery<PrecioServicio> query = em.createQuery(
                "SELECT p FROM PrecioServicio p "
                    + "INNER JOIN p.cliente cl "
                    + "INNER JOIN p.servicio srv "
                    + "INNER JOIN p.unidad u "
                    + "WHERE p.cliente.id = :idCliente "
                    + "ORDER BY p.servicio.descripcion, p.aviso.id", PrecioServicio.class
            );

            query.setParameter("idCliente", idCliente);
            return query.getResultList();
        });
    }
    
}
