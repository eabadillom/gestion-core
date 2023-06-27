package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ferbo.gestion.model.ConstanciaDepositoDetalle;

public class ConstanciaDepositoDetalleDAO extends DAO implements IDAO<ConstanciaDepositoDetalle> {
	
	private static final String SELECT = "select "
			+ "	CONSTANCIA_DEPOSITO_DETALLE_CVE, SERVICIO_CVE, FOLIO, servicio_cantidad "
			+ "from CONSTANCIA_DEPOSITO_DETALLE "
			;

	@Override
	public ConstanciaDepositoDetalle getBean(ResultSet rs) throws SQLException {
		ConstanciaDepositoDetalle bean = new ConstanciaDepositoDetalle();
		bean.setIdConstanciaDepositoDetalle(getInteger(rs, "CONSTANCIA_DEPOSITO_DETALLE_CVE"));
		bean.setIdServicio(getInteger(rs, "SERVICIO_CVE"));
		bean.setFolio(getInteger(rs, "FOLIO"));
		bean.setCantidad(rs.getBigDecimal("servicio_cantidad"));
		return bean;
	}

	@Override
	public List<ConstanciaDepositoDetalle> get(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<ConstanciaDepositoDetalle> getByFolio(Connection conn, Integer folio) throws SQLException {
		List<ConstanciaDepositoDetalle> beans = null;
		ConstanciaDepositoDetalle bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + "WHERE folio = ? ";
			ps = conn.prepareStatement(sql);
			setInteger(ps, idx++, folio);
			rs = ps.executeQuery();
			beans = new ArrayList<ConstanciaDepositoDetalle>();
			while(rs.next()) {
				bean = getBean(rs);
				beans.add(bean);
			}
		} finally {
			close(rs);
			close(ps);
		}
		
		return beans;
	}

	@Override
	public ConstanciaDepositoDetalle get(Connection conn, Object id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Connection conn, ConstanciaDepositoDetalle bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, ConstanciaDepositoDetalle bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, ConstanciaDepositoDetalle bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
