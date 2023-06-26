package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ferbo.gestion.model.TipoCobro;

public class TipoCobroDAO extends DAO implements IDAO<TipoCobro> {
	
	private static final String SELECT = "SELECT  id, nombre, descripcion FROM tipo_cobro tc ";

	@Override
	public TipoCobro getBean(ResultSet rs) throws SQLException {
		TipoCobro bean = new TipoCobro();
		bean.setIdTipoCobro(getInteger(rs, "id"));
		bean.setNombre(getTrim(rs.getString("nombre")));
		bean.setDescripcion(getTrim(rs.getString("descripcion")));
		return bean;
	}

	@Override
	public List<TipoCobro> get(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoCobro get(Connection conn, Object id) throws SQLException {
		TipoCobro bean = new TipoCobro();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + "WHERE id = ? ";
			ps = conn.prepareStatement(sql);
			setInteger(ps, idx++, (Integer)id);
			rs = ps.executeQuery();
			if(rs.next()) {
				bean = getBean(rs);
			}
		} finally {
			close(rs);
			close(ps);
		}
		
		return bean;
	}

	@Override
	public int insert(Connection conn, TipoCobro bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, TipoCobro bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, TipoCobro bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
