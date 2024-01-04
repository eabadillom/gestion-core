package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ferbo.gestion.model.UnidadManejo;

public class UnidadManejoDAO extends DAO implements IDAO<UnidadManejo> {
	
	private static final String SELECT = "select UNIDAD_DE_MANEJO_CVE, UNIDAD_DE_MANEJO_DS from unidad_de_manejo ";

	@Override
	public UnidadManejo getBean(ResultSet rs) throws SQLException {
		UnidadManejo bean = new UnidadManejo();
		bean.setIdUnidadManejo(getInteger(rs, "UNIDAD_DE_MANEJO_CVE"));
		bean.setNombre(getTrim(rs.getString("UNIDAD_DE_MANEJO_DS")));
		return bean;
	}

	@Override
	public List<UnidadManejo> get(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnidadManejo get(Connection conn, Object id) throws SQLException {
		UnidadManejo bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + "WHERE UNIDAD_DE_MANEJO_CVE = ?";
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
	public int insert(Connection conn, UnidadManejo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, UnidadManejo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, UnidadManejo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
