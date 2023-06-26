package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ferbo.gestion.model.Producto;

public class ProductoDAO extends DAO implements IDAO<Producto> {
	
	private static final String SELECT = "select PRODUCTO_CVE, PRODUCTO_DS, NUMERO_PROD, categoria from PRODUCTO ";

	@Override
	public Producto getBean(ResultSet rs) throws SQLException {
		Producto bean = new Producto();
		bean.setIdProducto(getInteger(rs, "PRODUCTO_CVE"));
		bean.setNombre(getTrim(rs.getString("PRODUCTO_DS")));
		bean.setNumero(getTrim(rs.getString("NUMERO_PROD")));
		bean.setIdCategoria(getInteger(rs, "categoria"));
		return bean;
	}

	@Override
	public List<Producto> get(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto get(Connection conn, Object id) throws SQLException {
		Producto bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + "WHERE PRODUCTO_CVE = ?";
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
	public int insert(Connection conn, Producto bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, Producto bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, Producto bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
