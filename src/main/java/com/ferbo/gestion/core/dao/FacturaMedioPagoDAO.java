package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.FacturaMedioPago;
import com.ferbo.gestion.core.tools.JpaExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FacturaMedioPagoDAO extends BaseDAO<FacturaMedioPago, Integer > 
{
    private static Logger log = LogManager.getLogger(FacturaMedioPagoDAO.class);

    public FacturaMedioPagoDAO() {
        super(FacturaMedioPago.class);
    }
    
    public FacturaMedioPago buscarPorFactura(Integer facturaId)  
    {
        return JpaExecutor.executeRead(em -> 
            (FacturaMedioPago) em.createNativeQuery("SELECT fmp.factura_id, fmp.fmp_id, fmp.mp_id, fmp.mp_descripcion, fmp.fmp_porcentaje, fmp.fmp_referencia, fmp.fmp_forma_pago "
                + "FROM factura_medio_pago fmp "
                + "WHERE fmp.factura_id = :facturaId ", FacturaMedioPago.class)
                .setParameter("facturaId", facturaId)
                .getSingleResult()
        );
    }
    
}
