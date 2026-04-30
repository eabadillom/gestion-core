package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.ConstanciaDeposito;
import com.ferbo.gestion.core.model.ConstanciaDepositoDetalle;
import com.ferbo.gestion.core.model.ConstanciaFactura;
import com.ferbo.gestion.core.model.Partida;
import com.ferbo.gestion.core.tools.DateUtils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class FacturacionDepositosDAO extends BaseDAO<ConstanciaDeposito, Integer> 
{
    private static Logger log = LogManager.getLogger(FacturacionDepositosDAO.class);

    public FacturacionDepositosDAO(TransactionManager transactManager) {
        super(ConstanciaDeposito.class, transactManager);
    }

    public List<ConstanciaFactura> buscarNoFacturados(Integer idCliente, Integer idPlanta) 
    {
        return transactManager.executeRead(em -> {
            List<ConstanciaFactura> listaConstanciaFactura = new ArrayList<>();
            
            //La siguiente consulta recibe dos parámetros: cteCve y plantaCve
            String sql = "select "
                    + "	cdd.FOLIO, "
                    + "	cdd.CTE_CVE, "
                    + "	cdd.FECHA_INGRESO, "
                    + "	cdd.NOMBRE_TRANSPORTISTA, "
                    + "	cdd.PLACAS_TRANSPORTE, "
                    + "	cdd.OBSERVACIONES, "
                    + "	cdd.folio_cliente, "
                    + "	cdd.valor_declarado, "
                    + "	cdd.status, "
                    + "	cdd.aviso_cve, "
                    + "	cdd.temperatura "
                    + "from constancia_de_deposito cdd "
                    + "INNER JOIN cliente cte ON cdd.CTE_CVE = cte.CTE_CVE "
                    + "LEFT OUTER JOIN ( "
                    + "	SELECT cf.* FROM constancia_factura cf "
                    + "	INNER JOIN factura f ON cf.factura = f.id "
                    + "	WHERE f.status NOT IN (0,2) "
                    + ") tCF ON cdd.FOLIO = tCF.folio AND cdd.FECHA_INGRESO = tCF.vigencia_inicio "
                    + "INNER JOIN ( "
                    + "	select DISTINCT p.FOLIO, plt.PLANTA_CVE, plt.PLANTA_DS from partida p "
                    + "	INNER JOIN camara cam ON p.CAMARA_CVE = cam.CAMARA_CVE  "
                    + "	INNER JOIN planta plt ON cam.PLANTA_CVE = plt.PLANTA_CVE "
                    + ") tPlt ON cdd.FOLIO = tPlt.FOLIO "
                    + "INNER JOIN ( "
                    + "	SELECT FOLIO, COUNT(FOLIO) AS CTA_SERVICIOS from constancia_deposito_detalle cdet "
                    + "	GROUP BY FOLIO "
                    + ") det ON cdd.FOLIO = det.FOLIO "
                    + "WHERE cdd.status not in (2,4) "
                    + "AND cdd.CTE_CVE = :idCliente "
                    + "AND tCF.id IS NULL "
                    + "AND tPlt.planta_cve = :idPlanta "
                    + "order by cdd.folio_cliente ";

            Query query = em.createNativeQuery(sql, ConstanciaDeposito.class)
                    .setParameter("idCliente", idCliente)
                    .setParameter("idPlanta", idPlanta);

            List<ConstanciaDeposito> listaConstancias = query.getResultList();
            List<Partida> allPartida = null;

            for (ConstanciaDeposito cdd : listaConstancias) {
                List<ConstanciaDepositoDetalle> allConstanciaDepositoDetalle = cdd.getConstanciaDepositoDetalleList();
                log.debug("Lista ConstanciaDepositoDetalle.size() = {}", allConstanciaDepositoDetalle.size());
                int vigencia = cdd.getAviso().getVigencia();
                LocalDate vigenciaInicio = cdd.getFechaIngreso();
                LocalDate vigenciaFin = DateUtils.fechaVencimiento(vigenciaInicio, vigencia, false);

                ConstanciaFactura cf = new ConstanciaFactura();

                cf.setConstanciaDeposito(cdd);
                cf.setFolioCliente(cdd.getFolioCliente());
                cf.setVigenciaInicio(cdd.getFechaIngreso());
                cf.setVigenciaFin(vigenciaFin);

                //FALTA RELACION DE POR CADA CONSTANCIA DE DEPOSITO AGREGAR LAS CONSTANCIAS FACTURAS CDD.SETLISTAFACTURAS
                listaConstanciaFactura.add(cf);
                cdd.setConstanciaFacturaList(new ArrayList<>());
                cdd.setConstanciaFacturaList(listaConstanciaFactura);

                log.debug("Constancia factura: {}, {}, {}", cf.getFolioCliente(), cf.getVigenciaInicio(), cf.getVigenciaFin());

                allPartida = cdd.getPartidaList();
                log.debug("AllPartida.size: {}", allPartida.size());
            }

            return listaConstanciaFactura;
        });
    }

}
