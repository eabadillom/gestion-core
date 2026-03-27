package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.UdCobro;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UdCobroDAO extends BaseDAO <UdCobro, Integer> 
{
    private static Logger log = LogManager.getLogger(UdCobroDAO.class);

    public UdCobroDAO (){
        super(UdCobro.class);
    }

    public List<UdCobro> buscarTodos() {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("UdCobro.findAll", UdCobro.class).getResultList()
        );
    }
    
}
