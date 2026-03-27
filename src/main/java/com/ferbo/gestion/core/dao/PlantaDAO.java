package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Planta;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlantaDAO extends BaseDAO<Planta, Integer> 
{
    private static Logger log = LogManager.getLogger(PlantaDAO.class);

    public PlantaDAO() {
        super(Planta.class);
    }

    public List<Planta> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("Planta.findAll", Planta.class)
                .getResultList()
        );
    }

}
