package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.CandadoSalida;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class CandadoSalidaDAO extends BaseDAO<CandadoSalida, Integer> 
{
    private static Logger log = LogManager.getLogger(CandadoSalidaDAO.class);

    public CandadoSalidaDAO(TransactionManager transactManager) {
        super(CandadoSalida.class, transactManager);
    }
    
    public CandadoSalida buscarPorCliente(Integer idCliente) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("CandadoSalida.findByCliente", CandadoSalida.class)
                .setParameter("idCliente", idCliente)
                .getSingleResult()
        );
    }

}
