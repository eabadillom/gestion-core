package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.ControlFacturaConstanciaDS;
import com.ferbo.gestion.core.model.ControlFacturaConstanciaDsPK;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class ControlFacturaConstanciaDAO extends BaseDAO<ControlFacturaConstanciaDS, ControlFacturaConstanciaDsPK>
{
    private static Logger log = LogManager.getLogger(ControlFacturaConstanciaDAO.class);

    public ControlFacturaConstanciaDAO(TransactionManager transactManager) {
        super(ControlFacturaConstanciaDS.class, transactManager);
    }
    
    public List<ControlFacturaConstanciaDS> buscarPorConstancia(Integer folio) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("ControlFacturaConstanciaDS.findByConstancia", ControlFacturaConstanciaDS.class)
                .setParameter("constancia", folio)
                .getResultList()
        );
    }
    
}
