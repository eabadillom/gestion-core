package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Asentamiento;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AsentamientoDAO extends BaseDAO<Asentamiento, Integer>
{
    private static Logger log = LogManager.getLogger(AsentamientoDAO.class);

    public AsentamientoDAO(Class<Asentamiento> modelClass) {
        super(modelClass);
    }
    
    public AsentamientoDAO() {
        super(Asentamiento.class);
    }

    @SuppressWarnings("unchecked")
    public List<Asentamiento> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("Asentamiento.findAll", Asentamiento.class)
                .getResultList()
        );
        
    }
    
    public Asentamiento buscarPorAsentamiento(Integer idPais, Integer idEstado, Integer idMunicipio, Integer idCiudad, Integer idAsentamiento) 
    {
        return JpaExecutor.executeRead(em -> {
            return em.createQuery("SELECT a "
                    + "FROM Asentamiento a "
                    + "WHERE a.asentamientoPK.ciudad.ciudadPK.municipio.municipioPK.estado.estadoPK.pais.id = :idPais "
                    + "AND a.asentamientoPK.ciudad.ciudadPK.municipio.municipioPK.estado.estadoPK.id = :idEstado "
                    + "AND a.asentamientoPK.ciudad.ciudadPK.municipio.municipioPK.id = :idMunicipio "
                    + "AND a.asentamientoPK.ciudad.ciudadPK.id = :idCiudad "
                    + "AND a.asentamientoPK.id =:idAsentamiento", Asentamiento.class)
                .setParameter("idPais", idPais)
                .setParameter("idEstado", idEstado)
                .setParameter("idMunicipio", idMunicipio)
                .setParameter("idCiudad", idCiudad)
                .setParameter("idAsentamiento", idAsentamiento)
                .getSingleResult();
        });
    }
    
    public Asentamiento buscaPorParametros(Integer idPais, Integer idEstado, Integer idMunicipio, Integer idCiudad, Integer idAsentamiento, Integer idTipoAsntmnto, Integer idEntidadPostal)
    {
        return JpaExecutor.executeRead(em -> {
            return em.createQuery("SELECT a "
                    + "FROM Asentamiento a "
                    + "WHERE a.asentamientoPK.ciudad.ciudadPK.municipio.municipioPK.estado.estadoPK.pais.id = :idPais "
                    + "AND a.asentamientoPK.ciudad.ciudadPK.municipio.municipioPK.estado.estadoPK.id = :idEstado "
                    + "AND a.asentamientoPK.ciudad.ciudadPK.municipio.municipioPK.id = :idMunicipio "
                    + "AND a.asentamientoPK.ciudad.ciudadPK.id = :idCiudad "
                    + "AND a.asentamientoPK.id =:idAsentamiento "
                    + "AND a.tipoAsentamiento.id = :idTipoAsntmnto "
                    + "AND a.entidadPostal.id = :idEntidadPostal", Asentamiento.class)
                .setParameter("idPais", idPais)
                .setParameter("idEstado", idEstado)
                .setParameter("idMunicipio", idMunicipio)
                .setParameter("idCiudad", idCiudad)
                .setParameter("idAsentamiento", idAsentamiento)
                .setParameter("idTipoAsntmnto", idTipoAsntmnto)
                .setParameter("idEntidadPostal", idEntidadPostal)
                .getSingleResult();
        });
    }

    
    public List<Asentamiento> buscaPorCP(String codigo) 
    {
        return JpaExecutor.executeRead(em -> {
            List<Asentamiento> listado = em.createNamedQuery("Asentamiento.findByCp", Asentamiento.class)
                .setParameter("cp", codigo).getResultList();

            for (Asentamiento aux : listado) {
                log.debug("Asentamiento: {}", aux.getDescripcion());
                log.debug("Ciudad: {}", aux.getAsentamientoPK().getCiudad().getDescripcion());
                log.debug("Municipio: {}", aux.getAsentamientoPK().getCiudad().getCiudadPK().getMunicipio().getDescripcion());
                log.debug("Estado: {}", aux.getAsentamientoPK().getCiudad().getCiudadPK().getMunicipio().getMunicipioPK().getEstado().getDesccripcion());
                log.debug("Pais: {}", aux.getAsentamientoPK().getCiudad().getCiudadPK().getMunicipio().getMunicipioPK().getEstado().getEstadoPK().getPais().getDescripcion());
            }

            return listado;
        });
    }
    
}
