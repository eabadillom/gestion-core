package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.SerieConstancia;
import com.ferbo.gestion.core.model.SerieConstanciaPK;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class SerieConstanciaDAO extends BaseDAO<SerieConstancia, SerieConstanciaPK> 
{	
    private static Logger log = LogManager.getLogger(SerieConstanciaDAO.class);

    public SerieConstanciaDAO(TransactionManager transactManager) {
        super(SerieConstancia.class, transactManager);
    }
    
    public Optional<SerieConstancia> buscarPorClienteTipoSeriePlanta(Integer idCliente, String tipoSerie, Integer idPlanta) 
    {
        return transactManager.executeRead(em -> {
            Optional<SerieConstancia> optional = null;
            SerieConstancia model = em.createNamedQuery("SerieConstancia.findByClienteTpSeriePlanta", SerieConstancia.class)
                .setParameter("idCliente", idCliente)
                .setParameter("tpSerie", tipoSerie)
                .setParameter("idPlanta", idPlanta)
                .getSingleResult();

            optional = Optional.of(model);

            return optional;
        });
    }
    
    public List<SerieConstancia> buscarPorClienteAndPlanta(Integer idCliente, Integer idPlanta) 
    {
        return transactManager.executeRead(em ->
            em.createNamedQuery("SerieConstancia.findByClienteAndPlanta", SerieConstancia.class)
                .setParameter("idCliente", idCliente)
                .setParameter("idPlanta", idPlanta)
                .getResultList()
        );
    }
    
    public List<SerieConstancia> buscarPorCliente(Integer idCliente) 
    {
        return transactManager.executeRead(em ->
            em.createNamedQuery("SerieConstancia.findByIdCliente", SerieConstancia.class)
                .setParameter("idCliente", idCliente)
                .getResultList()
        );
    }
    
}
