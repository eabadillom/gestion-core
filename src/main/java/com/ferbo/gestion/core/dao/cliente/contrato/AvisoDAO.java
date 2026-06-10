package com.ferbo.gestion.core.dao.cliente.contrato;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.cliente.contrato.Aviso;

public class AvisoDAO extends BaseDAO<Aviso, Integer> 
{
    private static Logger log = LogManager.getLogger(AvisoDAO.class);

    public AvisoDAO(TransactionManager transactManager) {
        super(Aviso.class, transactManager);
    }

    public List<Aviso> buscarPorCliente(Integer idCliente) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("Aviso.findByCliente", Aviso.class)
                .setParameter("idCliente", idCliente)
                .getResultList()
        );
    }

}
