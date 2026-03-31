package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.ConstanciaTraspaso;
import com.ferbo.gestion.core.model.Partida;
import com.ferbo.gestion.core.model.TraspasoPartida;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TraspasoPartidaDAO extends BaseDAO<TraspasoPartida, Integer>
{
    private static Logger log = LogManager.getLogger(TraspasoPartidaDAO.class);

    public TraspasoPartidaDAO(Class<TraspasoPartida> modelClass) {
        super(modelClass);
    }
    
    public List<TraspasoPartida> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("TraspasoPartida.findAll", TraspasoPartida.class)
                .getResultList()
        );
    }
    
    public List<TraspasoPartida> buscarPorPartida(Partida p) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("TraspasoPartida.findByPartida", TraspasoPartida.class)
                .setParameter("partidaCve", p.getId())
                .getResultList()
        );
    }
    
    public List<TraspasoPartida> buscarPorConstancia(ConstanciaTraspaso ct) {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("TraspasoPartida.findByTraspaso", TraspasoPartida.class).
                setParameter("traspaso", ct.getId()).
                getResultList()
        );
    }

}
