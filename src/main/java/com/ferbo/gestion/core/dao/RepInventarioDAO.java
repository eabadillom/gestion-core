package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.tools.JpaExecutor;
import com.ferbo.gestion.core.ui.RepInventario;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RepInventarioDAO extends BaseDAO<RepInventario, Integer>
{
    private static Logger log = LogManager.getLogger(RepInventarioDAO.class);

    public RepInventarioDAO() {
        super(RepInventario.class);
    }
    
    public List<RepInventario> buscar(LocalDate fecha, Integer idCliente, Integer idPlanta, Integer idCamara) 
    {
        return JpaExecutor.executeRead(em -> {
            String sql = "select * from ( "
                    + "	select "
                    + "	    cddEnt.folio            as folio, "
                    + "	    cli.cte_nombre          as cliente, "
                    + "	    cli.numero_cte          as numero_cte, "
                    + "	    cddEnt.folio_cliente    as folio_cliente, "
                    + "	    cddEnt.fecha_ingreso    as ingreso, "
                    + "	    parEnt.PARTIDA_CVE, "
                    + "	    (parEnt.cantidad_total - COALESCE(salidas.cantidad, 0)) as cantidad, "
                    + "	    udm.unidad_de_manejo_ds as unidad_cobro, "
                    + "	    CEILING((parEnt.cantidad_total - COALESCE(salidas.cantidad, 0)) * parEnt.no_tarimas / parEnt.CANTIDAD_TOTAL ) as tarima, "
                    + "	    (parEnt.peso_total - COALESCE(salidas.peso, 0)) as peso, "
                    + "	    prd.producto_cve        as producto_cve, "
                    + "	    prd.producto_ds         as producto,  "
                    + "	    detPart.dtp_caducidad   as caducidad, "
                    + "	    prd.numero_prod         as codigo, "
                    + "	    detPart.dtp_sap         as sap, "
                    + "	    detPart.dtp_po          as po, "
                    + "	    cam.camara_cve          as cam_cve, "
                    + "	    cam.camara_abrev        as camara, "
                    + "	    plt.planta_cve          as plt_cve, "
                    + "	    plt.planta_abrev        as planta, "
                    + "	    detPart.dtp_lote        as lote, "
                    + "		COALESCE(parEnt.valorMercancia,0) as valor, "
                    + "		(parEnt.valorMercancia / parEnt.CANTIDAD_TOTAL) as base_cargo, "
                    + "		( cantidad * parEnt.valorMercancia / parEnt.CANTIDAD_TOTAL)  as resultado, "
                    + "	    pos.cod_posicion "
                    + "	from partida parEnt "
                    + "	inner join ( "
                    + "		select * "
                    + "		from constancia_de_deposito cdd "
                    + "		WHERE (cdd.cte_cve = :idCliente OR :idCliente IS NULL) "
                    + "			AND cdd.fecha_ingreso <= :fecha "
                    + "	) cddEnt on parEnt.folio = cddEnt.folio "
                    + "	inner join unidad_de_producto udp on udp.unidad_de_producto_cve = parEnt.unidad_de_producto_cve "
                    + "	inner join producto prd on prd.producto_cve = udp.producto_cve "
                    + "	inner join unidad_de_manejo udm on udm.unidad_de_manejo_cve = udp.unidad_de_manejo_cve "
                    + "	inner join camara cam on cam.camara_cve = parEnt.camara_cve "
                    + "	inner join planta plt on plt.planta_cve = cam.planta_cve "
                    + "	inner join cliente cli on cli.cte_cve = cddEnt.cte_cve "
                    + "	inner join "
                    + "	( "
                    + "	    select tdp.* from detalle_partida tdp "
                    + "	    inner join ( "
                    + "			select "
                    + "				dp.partida_cve, "
                    + "	            max(dp.det_part_cve) as det_part_cve "
                    + "			from detalle_partida dp "
                    + "			"
                    + "			group by dp.partida_cve "
                    + "	    ) tmdp on tdp.partida_cve = tmdp.partida_cve and tdp.det_part_cve = tmdp.det_part_cve "
                    + "	) detPart on detPart.partida_cve = parEnt.partida_cve "
                    + "	left outer join posicion_partida pp on parEnt.partida_cve = pp.ID_PARTIDA "
                    + "	left outer join posicion pos on pp.ID_POSICION = pos.id_posicion "
                    + "	left outer join ( "
                    + "		select "
                    + "	    	dcs.partida_cve, "
                    + "	    	sum(COALESCE(dcs.peso,0)) as peso, "
                    + "	    	sum(COALESCE(dcs.cantidad,0)) as cantidad "
                    + "	    from constancia_salida cSal "
                    + "	    inner join detalle_constancia_salida dcs on dcs.constancia_cve = cSal.id "
                    + "	    WHERE cSal.status = 1  "
                    + "	    	AND cSal.fecha <= :fecha "
                    + "	    group by "
                    + "			dcs.PARTIDA_CVE "
                    + "	) salidas ON parEnt.partida_cve = salidas.partida_cve "
                    + "	where "
                    + "		cddEnt.status <> 4 "
                    + "		AND (cam.camara_cve = :idCamara OR :idCamara IS NULL ) "
                    + "		AND (plt.planta_cve  = :idPlanta OR :idPlanta IS NULL ) "
                    + ") I "
                    + "WHERE I.cantidad > 0 "
                    + "ORDER BY cliente,numero_cte, producto ";

            List<Object[]> results = em.createNativeQuery(sql)
                    .setParameter("fecha", fecha)
                    .setParameter("idCliente", idCliente)
                    .setParameter("idPlanta", idPlanta)
                    .setParameter("idCamara", idCamara)
                    .getResultList();

            List<RepInventario> resultList = new ArrayList<RepInventario>();
            for (Object[] o : results) {
                RepInventario r = new RepInventario();
                int idx = 0;

                r.setFolio((Integer) o[idx++]);
                r.setNombreCliente((String) o[idx++]);
                r.setNumeroCliente((String) o[idx++]);
                r.setFolioCliente((String) o[idx++]);
                r.setIngreso((LocalDate) o[idx++]);
                r.setIdPartida((Integer) o[idx++]);
                r.setCantidad((BigDecimal) o[idx++]);
                r.setUnidadCobro((String) o[idx++]);
                r.setTarima((BigDecimal) o[idx++]);
                r.setPeso((BigDecimal) o[idx++]);
                r.setIdProducto((Integer) o[idx++]);
                r.setProductoDescripcion((String) o[idx++]);
                r.setCaducidad((LocalDate) o[idx++]);
                r.setCodigo((String) o[idx++]);
                r.setSap((String) o[idx++]);
                r.setPo((String) o[idx++]);
                r.setIdCamara((Integer) o[idx++]);
                r.setCamaraDescripcion((String) o[idx++]);
                r.setIdPlanta((Integer) o[idx++]);
                r.setPlantaDescripcion((String) o[idx++]);
                r.setLote((String) o[idx++]);
                r.setValor((BigDecimal) o[idx++]);
                r.setBaseCargo((BigDecimal) o[idx++]);
                r.setResultado((BigDecimal) o[idx++]);
                r.setPosicionCodigo((String) o[idx++]);

                resultList.add(r);
            }

            return resultList;
        });
    }
    
}
