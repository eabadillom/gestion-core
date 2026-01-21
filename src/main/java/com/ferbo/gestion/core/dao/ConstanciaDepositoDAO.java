package com.ferbo.gestion.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferbo.gestion.core.model.ConstanciaDeposito;
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
		throw new UnsupportedOperationException("Búsqueda no implementada.");
	}

	@Override
	public int insert(Connection conn, ConstanciaDeposito bean) throws SQLException {
		throw new UnsupportedOperationException("Operación no implementada.");
	}

	@Override
	public int update(Connection conn, ConstanciaDeposito bean) throws SQLException {
		throw new UnsupportedOperationException("Operación no implementada.");
	}

	@Override
	public int delete(Connection conn, ConstanciaDeposito bean) throws SQLException {
		throw new UnsupportedOperationException("Operación no implementada.");
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
		PreparedStatement             ps      = null;
		ResultSet                     rs      = null;
		String                        sql     = null;
		int idx = 1;
		
		Integer ctaRows = null;
		
		try {
			sql = "select count(*) as cta_inventario\n"
					+ "from (\n"
					+ "	select\n"
					+ "		p.PARTIDA_CVE,\n"
					+ "		(p.CANTIDAD_TOTAL - COALESCE(s.cantidad, 0)) as cantidad,\n"
					+ "		(p.PESO_TOTAL - COALESCE(s.peso, 0)) as peso\n"
					+ "	from constancia_de_deposito cdd\n"
					+ "	inner join partida p on cdd.FOLIO = p.FOLIO\n"
					+ "	left outer join (\n"
					+ "		select\n"
					+ "			dcs.PARTIDA_CVE,\n"
					+ "			sum(dcs.CANTIDAD) as cantidad,\n"
					+ "			sum(dcs.peso) as peso\n"
					+ "		from constancia_salida cs \n"
					+ "		inner join detalle_constancia_salida dcs on cs.ID = dcs.CONSTANCIA_CVE\n"
					+ "		where cs.STATUS = 1 and cs.fecha <= ?\n"
					+ "		group by dcs.PARTIDA_CVE\n"
					+ "	) s on p.PARTIDA_CVE = s.partida_cve\n"
					+ "	where cdd.status = 1 and cdd.CTE_CVE = ? and cdd.fecha_ingreso <= ?\n"
					+ ") i where i.cantidad > 0"
					;
			
			ps = conn.prepareStatement(sql);
			setSqlDate(ps, idx++, fechaCorte);
			setInteger(ps, idx++, idCliente);
			setSqlDate(ps, idx++, fechaCorte);
			
			rs = ps.executeQuery();
			
			if(rs.next())
				ctaRows = getInteger(rs, "cta_inventario");
			
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
			close(rs);
			close(ps);
		}
		
		return tieneInventario;
	}

	
}
