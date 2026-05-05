package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Ciudad;
import com.ferbo.gestion.core.model.CiudadPK;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class CiudadDAO extends BaseDAO<Ciudad, Integer> 
{
    private static Logger log = LogManager.getLogger(CiudadDAO.class);
    
    public CiudadDAO(TransactionManager transactManager) {
        super(Ciudad.class, transactManager);
    }
    
    public Ciudad buscarPorId(CiudadPK ciudadPK) 
    {
        return transactManager.executeRead(em -> {
            return em.createNamedQuery("Ciudad.findById", Ciudad.class)
                .setParameter("idCiudad", ciudadPK.getId())
                .getSingleResult();
        });
    }
    
    public List<Ciudad> buscarPorParametros(Integer idCiudad, Integer idMunicipio, Integer idEstado, Integer idPais) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("Ciudad.findByParametros", Ciudad.class)
                .setParameter("idCiudad", idCiudad)
                .setParameter("idMunicipio", idMunicipio)
                .setParameter("idEstado", idEstado)
                .setParameter("idPais", idPais)
                .getResultList()
        );
    }
    
}
