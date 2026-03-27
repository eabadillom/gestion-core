package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.ConstanciaDeServicio;
import com.ferbo.gestion.core.model.ConstanciaFacturaDs;
import com.ferbo.gestion.core.model.ConstanciaServicioDetalle;
import com.ferbo.gestion.core.model.PartidaServicio;
import com.ferbo.gestion.core.model.PrecioServicio;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FacturacionServiciosDAO extends BaseDAO<ConstanciaFacturaDs, Integer> 
{
    private static Logger log = LogManager.getLogger(FacturacionServiciosDAO.class);

    public FacturacionServiciosDAO() {
        super(ConstanciaFacturaDs.class);
    }

    public List<ConstanciaFacturaDs> buscarNoFacturados(Integer idCliente) 
    {
        return JpaExecutor.executeRead(em -> {
            String sql = "SELECT "
                    + " cs.FOLIO, "
                    + "	cs.CTE_CVE, "
                    + "	cs.FECHA, "
                    + "	cs.NOMBRE_TRANSPORTISTA, "
                    + "	cs.PLACAS_TRANSPORTE, "
                    + "	cs.OBSERVACIONES, "
                    + "	cs.FOLIO_CLIENTE, "
                    + "	cs.VALOR_DECLARADO, "
                    + "	cs.STATUS "
                    + "FROM constancia_de_servicio cs "
                    + "INNER JOIN cliente cte ON cs.CTE_CVE = cte.CTE_CVE "
                    + "LEFT OUTER JOIN ( "
                    + "	SELECT cf.* FROM constancia_factura_ds cf "
                    + "	INNER JOIN factura f ON cf.factura = f.id "
                    + "	WHERE f.status NOT IN (0,2) "
                    + ") tCF ON cs.FOLIO = tCF.folio "
                    + "INNER JOIN ( "
                    + "	SELECT FOLIO, COUNT(FOLIO) AS CTA_SERVICIOS FROM constancia_servicio_detalle cdet "
                    + "	GROUP BY FOLIO "
                    + ") det ON cs.FOLIO = det.FOLIO "
                    + "WHERE cs.status not in (4) "
                    + "AND cs.CTE_CVE = :idCliente "
                    + "AND tCF.id IS NULL "
                    + "ORDER BY cs.FECHA, cs.FOLIO_CLIENTE ";

            Query query = em.createNativeQuery(sql, ConstanciaDeServicio.class)
                    .setParameter("idCliente", idCliente);

            List<ConstanciaDeServicio> listaConstancias = query.getResultList();
            List<ConstanciaFacturaDs> list = new ArrayList<>();

            for (ConstanciaDeServicio constancia : listaConstancias) {
                List<ConstanciaServicioDetalle> allConstanciaServicioDetalle = constancia.getConstanciaServicioDetalleList();//recuperando constancias de servicio detalle de servicio ds
                List<PartidaServicio> allPartidaServicio = constancia.getPartidaServicioList();
                log.debug("Lista PartidaServicio.size() = {}", allPartidaServicio.size());
                List<ConstanciaFacturaDs> listaTmpConstancias = constancia.getConstanciaFacturaDsList();
                List<ConstanciaFacturaDs> lConstanciaFactura = listaTmpConstancias.stream()
                        .filter(c
                                -> (c.getFactura().getStatus().getId() == 1 //Status por cobrar
                        || c.getFactura().getStatus().getId() == 3 //Status pagada
                        || c.getFactura().getStatus().getId() == 4) //status pago parcial
                        ).collect(Collectors.toList());

                if (lConstanciaFactura.size() > 0) {
                    continue;
                }

                ConstanciaFacturaDs cf = new ConstanciaFacturaDs();
                cf.setConstanciaDeServicio(constancia);
                cf.setFolioCliente(constancia.getFolioCliente());

                // FALTA RELACION DE CONSTANCIA FACTURA DS CON LA CONSTANCIA DE SERVICIO constancia.setConstanciaFacturaDsList(null);
                list.add(cf);
                constancia.setConstanciaFacturaDsList(new ArrayList<>());
                constancia.setConstanciaFacturaDsList(list);
                //modificacion
                for (ConstanciaServicioDetalle csd : allConstanciaServicioDetalle) {
                    List<PrecioServicio> allPrecioServicio = csd.getServicio().getPrecioServicioList();
                    log.debug("Lista PrecioServicio.size() = {}", allPrecioServicio.size());
                }

            }

            return list;
        });
    }

}
