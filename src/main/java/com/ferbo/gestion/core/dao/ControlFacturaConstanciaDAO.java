package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.ControlFacturaConstanciaDS;
import com.ferbo.gestion.core.model.ControlFacturaConstanciaDsPK;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ControlFacturaConstanciaDAO extends BaseDAO<ControlFacturaConstanciaDS, ControlFacturaConstanciaDsPK>
{
    private static Logger log = LogManager.getLogger(ControlFacturaConstanciaDAO.class);

    public ControlFacturaConstanciaDAO() {
        super(ControlFacturaConstanciaDS.class);
    }
    
    public List<ControlFacturaConstanciaDS> buscarPorConstancia(Integer folio) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("ControlFacturaConstanciaDS.findByConstancia", ControlFacturaConstanciaDS.class)
                .setParameter("constancia", folio)
                .getResultList()
        );
    }
    
}
