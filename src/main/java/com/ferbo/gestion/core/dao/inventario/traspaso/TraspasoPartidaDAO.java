package com.ferbo.gestion.core.dao.inventario.traspaso;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.inventario.entrada.Partida;
import com.ferbo.gestion.core.model.inventario.traspaso.ConstanciaTraspaso;
import com.ferbo.gestion.core.model.inventario.traspaso.TraspasoPartida;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class TraspasoPartidaDAO extends BaseDAO<TraspasoPartida, Integer>
{
    private static Logger log = LogManager.getLogger(TraspasoPartidaDAO.class);

    public TraspasoPartidaDAO(TransactionManager transactManager) {
        super(TraspasoPartida.class, transactManager);
    }
    
    public List<TraspasoPartida> buscarTodos() 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("TraspasoPartida.findAll", TraspasoPartida.class)
                .getResultList()
        );
    }
    
    public List<TraspasoPartida> buscarPorPartida(Partida p) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("TraspasoPartida.findByPartida", TraspasoPartida.class)
                .setParameter("partidaCve", p.getId())
                .getResultList()
        );
    }
    
    public List<TraspasoPartida> buscarPorConstancia(ConstanciaTraspaso ct) {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("TraspasoPartida.findByTraspaso", TraspasoPartida.class).
                setParameter("traspaso", ct.getId()).
                getResultList()
        );
    }

}
