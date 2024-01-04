package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ferbo.gestion.model.UnidadProducto;

public class UnidadProductoDAO extends DAO implements IDAO<UnidadProducto> {
	
	private static final String SELECT = "select "
			+ "	UNIDAD_DE_PRODUCTO_CVE, "
			+ "	PRODUCTO_CVE, "
			+ "	UNIDAD_DE_MANEJO_CVE "
			+ "from "
			+ "	unidad_de_producto ";

	@Override
	public UnidadProducto getBean(ResultSet rs) throws SQLException {
		UnidadProducto bean = new UnidadProducto();
		bean.setIdUnidadProducto(getInteger(rs, "UNIDAD_DE_PRODUCTO_CVE"));
		bean.setIdProducto(getInteger(rs, "PRODUCTO_CVE"));
		bean.setIdUnidadManejo(getInteger(rs, "UNIDAD_DE_MANEJO_CVE"));
		return bean;
	}

	@Override
	public List<UnidadProducto> get(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnidadProducto get(Connection conn, Object id) throws SQLException {
		UnidadProducto bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + "WHERE UNIDAD_DE_PRODUCTO_CVE = ?";
			ps = conn.prepareStatement(sql);
			setInteger(ps, idx++, (Integer) id);
			
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
	public int insert(Connection conn, UnidadProducto bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, UnidadProducto bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, UnidadProducto bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
