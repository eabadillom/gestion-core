package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferbo.gestion.model.ConstanciaDeposito;
import com.ferbo.gestion.tools.GestionException;

public class ConstanciaDepositoDAO extends DAO implements IDAO<ConstanciaDeposito>{
	private static Logger log = LogManager.getLogger(ConstanciaDepositoDAO.class);
	private static final String SELECT = "SELECT FOLIO, CTE_CVE, FECHA_INGRESO, NOMBRE_TRANSPORTISTA, PLACAS_TRANSPORTE, OBSERVACIONES, folio_cliente, valor_declarado, status, aviso_cve, temperatura "
			+ "FROM constancia_de_deposito "
			;

	@Override
	public ConstanciaDeposito getBean(ResultSet rs)
	throws SQLException {
		ConstanciaDeposito bean = new ConstanciaDeposito();
		bean.setFolio(getInteger(rs, "FOLIO"));
		bean.setIdCliente(getInteger(rs, "CTE_CVE"));
		bean.setFechaIngreso(rs.getDate("FECHA_INGRESO"));
		bean.setNombreTransportista(getTrim(rs.getString("NOMBRE_TRANSPORTISTA")));
		bean.setPlacasTransporte(getTrim(rs.getString("PLACAS_TRANSPORTE")));
		bean.setObservaciones(getTrim(rs.getString("OBSERVACIONES")));
		bean.setFolioCliente(getTrim(rs.getString("folio_cliente")));
		bean.setValorDeclarado(rs.getBigDecimal("valor_declarado"));
		bean.setStatus(getInteger(rs, "status"));
		bean.setIdAviso(getInteger(rs, "aviso_cve"));
		bean.setTemperatura(getTrim(rs.getString("temperatura")));
		
		return bean;
	}
	
	@Override
	public ConstanciaDeposito get(Connection conn, Object id) throws SQLException {
		ConstanciaDeposito bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + "WHERE folio_cliente = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(idx++, (String) id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				bean = this.getBean(rs);
			}
			
		} finally {
			close(rs);
			close(ps);
		}
		
		return bean;
	}

	@Override
	public List<ConstanciaDeposito> get(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Connection conn, ConstanciaDeposito bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, ConstanciaDeposito bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, ConstanciaDeposito bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<ConstanciaDeposito> getConstanciasConSaldo(Connection conn, Integer idCliente, Date fechaCorte)
	throws SQLException {
		List<ConstanciaDeposito>      constancias = null;
		ConstanciaDeposito            cdd           = null;
		PreparedStatement             psSelect      = null;
		ResultSet                     rsSelect      = null;
		String                        sqlSelect     = null;
		int idx = 1;
		
		try{
			sqlSelect = "SELECT "
					+ "	folio, "
					+ "	folio_cliente, "
					+ "	cte_cve, "
					+ "	fecha_ingreso, "
					+ "	nombre_transportista, "
					+ "	placas_transporte, "
					+ "	observaciones, "
					+ "	valor_declarado, "
					+ "	status, "
					+ "	aviso_cve, "
					+ "	temperatura "
					+ "FROM ( "
					+ "	SELECT "
					+ "		cdd.folio, "
					+ "		cdd.folio_cliente, "
					+ "		cdd.cte_cve, "
					+ "		cdd.fecha_ingreso, "
					+ "		cdd.nombre_transportista, "
					+ "		cdd.placas_transporte, "
					+ "		cdd.observaciones,  "
					+ "		cdd.valor_declarado, "
					+ "		cdd.status, "
					+ "		cdd.aviso_cve, "
					+ "		cdd.temperatura, "
					+ "		(p.peso_total - COALESCE(s.peso, 0) )as peso, "
					+ "		'Kilogramo' as unidad_peso, "
					+ "		(p.cantidad_total - COALESCE (s.cantidad, 0) ) as cantidad, "
					+ "		udm.unidad_de_manejo_ds as unidad_manejo, "
					+ "		prd.producto_ds "
					+ "	FROM constancia_de_deposito cdd "
					+ "	INNER JOIN partida p ON p.folio = cdd.folio "
					+ "	INNER JOIN detalle_partida dp ON p.partida_cve = dp.partida_cve AND det_part_cve = 1 "
					+ "	INNER JOIN unidad_de_producto udp ON p.unidad_de_producto_cve = udp.unidad_de_producto_cve "
					+ "	INNER JOIN producto prd ON udp.producto_cve = prd.producto_cve "
					+ "	INNER JOIN unidad_de_manejo udm ON udp.unidad_de_manejo_cve = udm.unidad_de_manejo_cve "
					+ "	INNER JOIN aviso a ON cdd.aviso_cve = a.aviso_cve "
					+ "	LEFT OUTER JOIN ( "
					+ "		SELECT "
					+ "			dcs.partida_cve, "
					+ "			MAX(cs.fecha) as fecha_ult_sal, "
					+ "			SUM(dcs.peso) as peso,  "
					+ "			'Kilogramo' as unidad_peso, "
					+ "			SUM(dcs.cantidad) AS cantidad, "
					+ "			dcs.unidad as unidad_manejo "
					+ "		FROM constancia_salida cs "
					+ "		INNER JOIN detalle_constancia_salida dcs ON cs.id = dcs.constancia_cve "
					+ "		WHERE cs.status = 1 "
					+ "			AND cs.cliente_cve = ? "
					+ "			AND cs.fecha <= ? "
					+ "		GROUP BY "
					+ "			dcs.partida_cve, "
					+ "			dcs.unidad "
					+ "				) s ON "
					+ "		p.partida_cve = s.partida_cve "
					+ "	WHERE "
					+ "		cdd.aviso_cve IS NOT NULL "
					+ "		AND peso > 0.0 "
					+ "		AND cantidad > 0 "
					+ "		AND cdd.cte_cve = ? "
					+ "		AND cdd.fecha_ingreso <= ? ) T "
					+ "GROUP BY "
					+ "	folio, "
					+ "	folio_cliente, "
					+ "	cte_cve, "
					+ "	fecha_ingreso, "
					+ "	nombre_transportista, "
					+ "	placas_transporte, "
					+ "	observaciones, "
					+ "	valor_declarado, "
					+ "	status, "
					+ "	aviso_cve, "
					+ "	temperatura "
					+ "ORDER BY "
					+ "	fecha_ingreso ASC"
				;
			
			psSelect = conn.prepareStatement(sqlSelect);
			psSelect.setInt(idx++, idCliente);
			psSelect.setDate(idx++, getSqlDate(fechaCorte));
			psSelect.setInt(idx++, idCliente);
			psSelect.setDate(idx++, getSqlDate(fechaCorte));
			rsSelect = psSelect.executeQuery();
			
			constancias = new ArrayList<ConstanciaDeposito>();
			
			while(rsSelect.next()) {
				cdd = getBean(rsSelect);
				constancias.add(cdd);
			}
			
		} finally {
			close(psSelect);
			close(rsSelect);
		}
		
		return constancias;
	}


	public boolean tieneInventario(Connection conn, Integer idCliente, Date fechaCorte)
	throws SQLException, GestionException {
		boolean tieneInventario = false;
		PreparedStatement             psSelect      = null;
		ResultSet                     rsSelect      = null;
		String                        sqlSelect     = null;
		int idx = 1;
		
		Integer ctaRows = null;
		
		try {
			sqlSelect = "select count(*) as cta_inventario\n"
					+ "from (\n"
					+ "	select * from (\n"
					+ "		select\n"
					+ "		    cddEnt.folio            as folio,\n"
					+ "		    cli.cte_nombre          as cliente,\n"
					+ "		    cli.numero_cte          as numero_cte,\n"
					+ "		    cddEnt.folio_cliente    as folio_cliente,\n"
					+ "		    cddEnt.fecha_ingreso    as ingreso,\n"
					+ "		    parEnt.PARTIDA_CVE,\n"
					+ "		    (parEnt.cantidad_total - COALESCE(salidas.cantidad, 0)) as cantidad,\n"
					+ "		    udm.unidad_de_manejo_ds as unidad_cobro,\n"
					+ "		    CEILING((parEnt.cantidad_total - COALESCE(salidas.cantidad, 0)) * parEnt.no_tarimas / parEnt.CANTIDAD_TOTAL ) as tarima,\n"
					+ "		    (parEnt.peso_total - COALESCE(salidas.peso, 0)) as peso,\n"
					+ "		    prd.producto_cve        as producto_cve,\n"
					+ "		    prd.producto_ds         as producto, \n"
					+ "		    detPart.dtp_caducidad   as caducidad,\n"
					+ "		    prd.numero_prod         as codigo,\n"
					+ "		    detPart.dtp_sap         as sap,\n"
					+ "		    detPart.dtp_po          as po,\n"
					+ "		    cam.camara_cve          as cam_cve,\n"
					+ "		    cam.camara_abrev        as camara,\n"
					+ "		    plt.planta_cve          as plt_cve,\n"
					+ "		    plt.planta_abrev        as planta,\n"
					+ "		    detPart.dtp_lote        as lote,\n"
					+ "			COALESCE(parEnt.valorMercancia,0) as valor,\n"
					+ "			(parEnt.valorMercancia / parEnt.CANTIDAD_TOTAL) as base_cargo,\n"
					+ "			( cantidad * parEnt.valorMercancia / parEnt.CANTIDAD_TOTAL)  as resultado,\n"
					+ "		    pos.cod_posicion\n"
					+ "		from partida parEnt\n"
					+ "		inner join (\n"
					+ "			select *\n"
					+ "			from constancia_de_deposito cdd\n"
					+ "			WHERE (cdd.cte_cve = ? )\n"
					+ "				AND cdd.fecha_ingreso <= ?\n"
					+ "		) cddEnt on parEnt.folio = cddEnt.folio\n"
					+ "		inner join unidad_de_producto udp on udp.unidad_de_producto_cve = parEnt.unidad_de_producto_cve\n"
					+ "		inner join producto prd on prd.producto_cve = udp.producto_cve\n"
					+ "		inner join unidad_de_manejo udm on udm.unidad_de_manejo_cve = udp.unidad_de_manejo_cve\n"
					+ "		inner join camara cam on cam.camara_cve = parEnt.camara_cve\n"
					+ "		inner join planta plt on plt.planta_cve = cam.planta_cve\n"
					+ "		inner join cliente cli on cli.cte_cve = cddEnt.cte_cve\n"
					+ "		inner join \n"
					+ "		(\n"
					+ "		    select tdp.* from detalle_partida tdp\n"
					+ "		    inner join (\n"
					+ "				select\n"
					+ "					dp.partida_cve,\n"
					+ "		            max(dp.det_part_cve) as det_part_cve\n"
					+ "				from detalle_partida dp\n"
					+ "				\n"
					+ "				group by dp.partida_cve\n"
					+ "		    ) tmdp on tdp.partida_cve = tmdp.partida_cve and tdp.det_part_cve = tmdp.det_part_cve\n"
					+ "		) detPart on detPart.partida_cve = parEnt.partida_cve\n"
					+ "		left outer join posicion_partida pp on parEnt.partida_cve = pp.ID_PARTIDA\n"
					+ "		left outer join posicion pos on pp.ID_POSICION = pos.id_posicion\n"
					+ "		left outer join (\n"
					+ "			select \n"
					+ "		    	dcs.partida_cve,\n"
					+ "		    	sum(COALESCE(dcs.peso,0)) as peso,\n"
					+ "		    	sum(COALESCE(dcs.cantidad,0)) as cantidad\n"
					+ "		    from constancia_salida cSal\n"
					+ "		    inner join detalle_constancia_salida dcs on dcs.constancia_cve = cSal.id\n"
					+ "		    WHERE cSal.status = 1 \n"
					+ "		    	AND cSal.fecha <= ?\n"
					+ "		    group by\n"
					+ "				dcs.PARTIDA_CVE\n"
					+ "		) salidas ON parEnt.partida_cve = salidas.partida_cve\n"
					+ "		where\n"
					+ "			cddEnt.status <> 4\n"
					+ "	) I\n"
					+ "	WHERE I.cantidad > 0\n"
					+ "	ORDER BY cliente,numero_cte, producto\n"
					+ ") a";
			
			psSelect = conn.prepareStatement(sqlSelect);
			psSelect.setInt(idx++, idCliente);
			psSelect.setDate(idx++, getSqlDate(fechaCorte));
//			psSelect.setInt(idx++, idCliente);
			psSelect.setDate(idx++, getSqlDate(fechaCorte));
			rsSelect = psSelect.executeQuery();
			
			
			if(rsSelect.next())
				ctaRows = getInteger(rsSelect, "cta_inventario");
			
			if(ctaRows == null) {
				tieneInventario = false;
			} else if(ctaRows.compareTo(0) <= 0) {
				tieneInventario = false;
			} else if(ctaRows.compareTo(0) > 0) {
				tieneInventario = true;
			} else {
				throw new GestionException("La información de inventario es inconsistente.");
			}
			
			log.info("Registros en el inventario: idCliente = {}, fecha = {}, rows = {}", idCliente, fechaCorte, ctaRows);
		} finally {
			close(rsSelect);
			close(psSelect);
		}
		
		return tieneInventario;
	}

	
}
