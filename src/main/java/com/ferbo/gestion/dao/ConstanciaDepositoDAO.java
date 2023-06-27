package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ferbo.gestion.model.ConstanciaDeposito;

public class ConstanciaDepositoDAO extends DAO implements IDAO<ConstanciaDeposito>{
	private static final String SELECT = "SELECT FOLIO, CTE_CVE, FECHA_INGRESO, NOMBRE_TRANSPORTISTA, PLACAS_TRANSPORTE, OBSERVACIONES, folio_cliente, valor_declarado, status, aviso_cve, temperatura "
			+ "FROM CONSTANCIA_DE_DEPOSITO "
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
			sqlSelect = "SELECT\n"
					+ "	folio,\n"
					+ "	folio_cliente,\n"
					+ "	cte_cve,\n"
					+ "	fecha_ingreso,\n"
					+ "	nombre_transportista,\n"
					+ "	placas_transporte, \n"
					+ "	observaciones,\n"
					+ "	valor_declarado,\n"
					+ "	status,\n"
					+ "	aviso_cve,\n"
					+ "	temperatura\n"
					+ "FROM (\n"
					+ "	SELECT\n"
					+ "		cdd.folio,\n"
					+ "		cdd.folio_cliente, \n"
					+ "		cdd.cte_cve,\n"
					+ "		cdd.fecha_ingreso,\n"
					+ "		cdd.nombre_transportista,\n"
					+ "		cdd.placas_transporte,\n"
					+ "		cdd.observaciones, \n"
					+ "		cdd.valor_declarado,\n"
					+ "		cdd.status,\n"
					+ "		cdd.aviso_cve,\n"
					+ "		cdd.temperatura,\n"
					+ "		(p.peso_total - COALESCE(s.peso, 0) )as peso, \n"
					+ "		'Kilogramo' as unidad_peso,\n"
					+ "		(p.cantidad_total - COALESCE (s.cantidad, 0) ) as cantidad, \n"
					+ "		udm.unidad_de_manejo_ds as unidad_manejo,\n"
					+ "		prd.producto_ds\n"
					+ "	FROM CONSTANCIA_DE_DEPOSITO cdd\n"
					+ "	INNER JOIN PARTIDA p ON p.folio = cdd.folio\n"
					+ "	INNER JOIN DETALLE_PARTIDA dp ON p.partida_cve = dp.partida_cve AND det_part_cve = 1\n"
					+ "	INNER JOIN UNIDAD_DE_PRODUCTO udp ON p.unidad_de_producto_cve = udp.unidad_de_producto_cve\n"
					+ "	INNER JOIN PRODUCTO prd ON udp.producto_cve = prd.producto_cve\n"
					+ "	INNER JOIN UNIDAD_DE_MANEJO udm ON udp.unidad_de_manejo_cve = udm.unidad_de_manejo_cve\n"
					+ "	INNER JOIN aviso a ON cdd.aviso_cve = a.aviso_cve\n"
					+ "	LEFT OUTER JOIN (\n"
					+ "		SELECT\n"
					+ "			dcs.partida_cve,\n"
					+ "			MAX(cs.fecha) as fecha_ult_sal,\n"
					+ "			SUM(dcs.peso) as peso, \n"
					+ "			'Kilogramo' as unidad_peso,\n"
					+ "			SUM(dcs.cantidad) AS cantidad,\n"
					+ "			dcs.unidad as unidad_manejo\n"
					+ "		FROM CONSTANCIA_SALIDA cs\n"
					+ "		INNER JOIN DETALLE_CONSTANCIA_SALIDA dcs ON cs.id = dcs.constancia_cve\n"
					+ "		WHERE cs.status = 1\n"
					+ "			AND cs.cliente_cve = ?\n"
					+ "			AND cs.fecha <= ?\n"
					+ "		GROUP BY\n"
					+ "			dcs.partida_cve,\n"
					+ "			dcs.unidad \n"
					+ "				) s ON\n"
					+ "		p.partida_cve = s.partida_cve\n"
					+ "	WHERE\n"
					+ "		cdd.aviso_cve IS NOT NULL\n"
					+ "		AND peso > 0.0\n"
					+ "		AND cantidad > 0\n"
					+ "		AND cdd.cte_cve = ?\n"
					+ "		AND cdd.fecha_ingreso <= ? ) T\n"
					+ "GROUP BY\n"
					+ "	folio,\n"
					+ "	folio_cliente,\n"
					+ "	cte_cve, \n"
					+ "	fecha_ingreso,\n"
					+ "	nombre_transportista,\n"
					+ "	placas_transporte,\n"
					+ "	observaciones,\n"
					+ "	valor_declarado, \n"
					+ "	status,\n"
					+ "	aviso_cve,\n"
					+ "	temperatura\n"
					+ "ORDER BY\n"
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


	

	
}
