package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Posicion;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PosicionCamaraDAO extends BaseDAO<Posicion, Integer>
{
    private static Logger log = LogManager.getLogger(PosicionCamaraDAO.class);

    public PosicionCamaraDAO() {
        super(Posicion.class);
    }
    
    public List<Posicion> buscarTodos(){
        return JpaExecutor.executeRead(em ->
            em.createNamedQuery("Posicion.findAll", Posicion.class)
                .getResultList()
        );		
    }
    
}
