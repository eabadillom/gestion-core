package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Ciudad;
import com.ferbo.gestion.core.model.CiudadPK;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CiudadDAO extends BaseDAO<Ciudad, Integer> 
{
    private static Logger log = LogManager.getLogger(CiudadDAO.class);
    
    public CiudadDAO(Class<Ciudad> modelClass) {
        super(modelClass);
    }

    public CiudadDAO() {
        super(Ciudad.class);
    }
    
    public Ciudad buscarPorId(CiudadPK ciudadPK) 
    {
        return JpaExecutor.executeRead(em -> {
            return em.createNamedQuery("Ciudad.findById", Ciudad.class)
                .setParameter("idCiudad", ciudadPK.getId())
                .getSingleResult();
        });
    }
    
    public List<Ciudad> buscarPorParametros(Integer idCiudad, Integer idMunicipio, Integer idEstado, Integer idPais) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("Ciudad.findByParametros", Ciudad.class)
                .setParameter("idCiudad", idCiudad)
                .setParameter("idMunicipio", idMunicipio)
                .setParameter("idEstado", idEstado)
                .setParameter("idPais", idPais)
                .getResultList()
        );
    }
    
}
