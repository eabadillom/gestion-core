package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.CandadoSalida;
import com.ferbo.gestion.core.tools.JpaExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CandadoSalidaDAO extends BaseDAO<CandadoSalida, Integer> 
{
    private static Logger log = LogManager.getLogger(CandadoSalidaDAO.class);

    public CandadoSalidaDAO() {
        super(CandadoSalida.class);
    }
    
    public CandadoSalida buscarPorCliente(Integer idCliente) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("CandadoSalida.findByCliente", CandadoSalida.class)
                .setParameter("idCliente", idCliente)
                .getSingleResult()
        );
    }

}
