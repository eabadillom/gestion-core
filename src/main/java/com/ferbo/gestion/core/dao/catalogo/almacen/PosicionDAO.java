package com.ferbo.gestion.core.dao.catalogo.almacen;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.catalogo.almacen.Posicion;

public class PosicionDAO extends BaseDAO<Posicion, Integer>
{
    private static Logger log = LogManager.getLogger(PosicionDAO.class);

    public PosicionDAO(TransactionManager transactManager) {
        super(Posicion.class, transactManager);
    }
    
    public List<Posicion> buscarTodos(){
        return transactManager.executeRead(em ->
            em.createNamedQuery("Posicion.findAll", Posicion.class)
                .getResultList()
        );		
    }
    
}
