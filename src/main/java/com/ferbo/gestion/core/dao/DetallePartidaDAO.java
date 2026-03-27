package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.DetallePartida;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DetallePartidaDAO extends BaseDAO<DetallePartida, Integer> 
{
    private static Logger log = LogManager.getLogger(DetallePartidaDAO.class);

    public DetallePartidaDAO() {
        super(DetallePartida.class);
    }

    public List<DetallePartida> buscarPorPartida(Integer partidaCve) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("DetallePartida.findByIdPartida", DetallePartida.class)
                .setParameter("idPartida", partidaCve)
                .getResultList()
        );
    }
    
}
