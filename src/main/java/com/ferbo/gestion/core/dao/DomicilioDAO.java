package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Domicilio;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DomicilioDAO extends BaseDAO<Domicilio, Integer> 
{
    private static Logger log = LogManager.getLogger(DomicilioDAO.class);

    public DomicilioDAO(Class<Domicilio> modelClass) {
        super(modelClass);
    }

    public DomicilioDAO() {
        super(Domicilio.class);
    }

    public List<Domicilio> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("Domicilio.findAll", Domicilio.class)
                .getResultList()
        );
    }

    public Domicilio buscarPorAsentamiento(Integer idPais, Integer idEstado, Integer idMunicipio, Integer idCiudad, Integer idAsentamiento) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createQuery("SELECT d "
                    + "FROM Domicilio d "
                    + "WHERE d.asentamiento.asentamientoPK.ciudad.ciudadPK.municipio.municipioPK.estado.estadoPK.pais.id = :idPais "
                    + "AND d.asentamiento.asentamientoPK.ciudad.ciudadPK.municipio.municipioPK.estado.estadoPK.id = :idEstado "
                    + "AND d.asentamiento.asentamientoPK.ciudad.ciudadPK.municipio.municipioPK.id = :idMunicipio "
                    + "AND d.asentamiento.asentamientoPK.ciudad.ciudadPK.id = :idCiudad "
                    + "AND d.asentamiento.asentamientoPK.id = :idAsentamiento", Domicilio.class)
                .setParameter("idPais", idPais)
                .setParameter("idEstado", idEstado)
                .setParameter("idMunicipio", idMunicipio)
                .setParameter("idCiudad", idCiudad)
                .setParameter("idAsentamiento", idAsentamiento)
                .getSingleResult()
        );
    }
    
}
