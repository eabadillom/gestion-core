package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ferbo.gestion.model.Partida;

public class PartidaDAO extends DAO implements IDAO<Partida> {
	
	private static final String SELECT = "select "
			+ "PARTIDA_CVE, CAMARA_CVE, FOLIO, PESO_TOTAL, CANTIDAD_TOTAL, UNIDAD_DE_PRODUCTO_CVE, cantidad_de_cobro, unidad_de_cobro, partida_seq, valorMercancia, rendimiento, no_tarimas "
			+ "from PARTIDA ";

	@Override
	public Partida getBean(ResultSet rs) throws SQLException {
		Partida bean = new Partida();
		bean.setIdPartida(getInteger(rs, "PARTIDA_CVE"));
		bean.setIdCamara(getInteger(rs, "CAMARA_CVE"));
		bean.setFolio(getInteger(rs, "FOLIO"));
		bean.setPesoTotal(rs.getBigDecimal("PESO_TOTAL"));
		bean.setCantidadTotal(getInteger(rs, "CANTIDAD_TOTAL"));
		bean.setIdUnidadProducto(getInteger(rs, "UNIDAD_DE_PRODUCTO_CVE"));
		bean.setCantidadCobro(rs.getBigDecimal("cantidad_de_cobro"));
		bean.setIdUnidadCobro(getInteger(rs, "unidad_de_cobro"));
		bean.setPartidaSeq(getInteger(rs, "partida_seq"));
		bean.setValorMercancia(rs.getBigDecimal("valorMercancia"));
		bean.setRendimiento(rs.getBigDecimal("rendimiento"));
		bean.setNumeroTarimas(rs.getBigDecimal("no_tarimas"));
		return bean;
	}

	@Override
	public List<Partida> get(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Partida get(Connection conn, Object id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Partida> getByFolio(Connection conn, Integer folio)
	throws SQLException {
		List<Partida> list = null;
		Partida bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + "WHERE folio = ? ";
			ps = conn.prepareStatement(sql);
			setInteger(ps, idx++, folio);
			
			rs = ps.executeQuery();
			list = new ArrayList<Partida>();
			while(rs.next()) {
				bean = getBean(rs);
				list.add(bean);
			}
			
		} finally {
			close(rs);
			close(ps);
		}
		
		return list;
	}

	@Override
	public int insert(Connection conn, Partida bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, Partida bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, Partida bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
