package com.ferbo.gestion.core.dao.catalogo.almacen;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.catalogo.almacen.Planta;

public class PlantaDAO extends BaseDAO<Planta, Integer> 
{
    private static Logger log = LogManager.getLogger(PlantaDAO.class);

    public PlantaDAO(TransactionManager transactManager) {
        super(Planta.class, transactManager);
    }

}
