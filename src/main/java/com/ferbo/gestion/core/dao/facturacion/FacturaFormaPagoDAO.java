package com.ferbo.gestion.core.dao.facturacion;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.facturacion.FacturaFormaPago;

public class FacturaFormaPagoDAO extends BaseDAO<FacturaFormaPago, Integer > 
{
    private static Logger log = LogManager.getLogger(FacturaFormaPagoDAO.class);

    public FacturaFormaPagoDAO(TransactionManager transactManager) {
        super(FacturaFormaPago.class, transactManager);
    }
    
    public FacturaFormaPago buscarPorFactura(Integer facturaId)  
    {
        return transactManager.executeRead(em -> 
            (FacturaFormaPago) em.createNativeQuery("SELECT fmp.factura_id, fmp.fmp_id, fmp.mp_id, fmp.mp_descripcion, fmp.fmp_porcentaje, fmp.fmp_referencia, fmp.fmp_forma_pago "
                + "FROM factura_medio_pago fmp "
                + "WHERE fmp.factura_id = :facturaId ", FacturaFormaPago.class)
                .setParameter("facturaId", facturaId)
                .getSingleResult()
        );
    }
    
}
