package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.UdCobro;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class UdCobroDAO extends BaseDAO <UdCobro, Integer> 
{
    private static Logger log = LogManager.getLogger(UdCobroDAO.class);

    public UdCobroDAO (TransactionManager transactManager){
        super(UdCobro.class, transactManager);
    }

    public List<UdCobro> buscarTodos() {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("UdCobro.findAll", UdCobro.class).getResultList()
        );
    }
    
}
