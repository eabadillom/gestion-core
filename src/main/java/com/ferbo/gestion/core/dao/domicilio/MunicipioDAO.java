package com.ferbo.gestion.core.dao.domicilio;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.domicilio.Estado;
import com.ferbo.gestion.core.model.domicilio.Municipio;
import com.ferbo.gestion.core.model.domicilio.MunicipioPK;

public class MunicipioDAO extends BaseDAO<Municipio, Integer> 
{
    private static  Logger log = LogManager.getLogger(MunicipioDAO.class);
    
    public MunicipioDAO(TransactionManager transactManager) {
        super(Municipio.class, transactManager);
    }
    
    public Municipio buscarPorPK(MunicipioPK municipioPK) {
        return transactManager.executeRead(em -> 
            em.find(Municipio.class, municipioPK)
        );
    }
    
    public Municipio buscarUltimoMunicipio(Estado estado)
    {
        return transactManager.executeRead(em -> {
            TypedQuery<Municipio> query = em.createQuery(
                "SELECT m FROM Municipio m "
                + "WHERE m.municipioPK.estado.estadoPK.pais.id = :idPais "
                + "AND m.municipioPK.estado.estadoPK.id = :idEstado "
                + "AND m.municipioPK.id < 998 "
                + "ORDER BY m.municipioPK.id DESC", Municipio.class
            );

            query.setParameter("idPais", estado.getEstadoPK().getPais().getId());
            query.setParameter("idEstado", estado.getEstadoPK().getId());
            query.setMaxResults(1);

            return query.getSingleResult();
        });
    }
    
    public List<Municipio> buscarPorPaisEstado(Estado estado) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("Municipio.findByPaisEstado", Municipio.class)
                .setParameter("idPais", estado.getEstadoPK().getPais().getId())
                .setParameter("idEstado", estado.getEstadoPK().getId())
                .getResultList()
        );
    }
    
}
