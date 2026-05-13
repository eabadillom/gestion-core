package com.ferbo.gestion.core.dao.facturacion.detalle;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.facturacion.detalle.ControlFacturaConstanciaDS;
import com.ferbo.gestion.core.model.facturacion.detalle.ControlFacturaConstanciaDsPK;

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
