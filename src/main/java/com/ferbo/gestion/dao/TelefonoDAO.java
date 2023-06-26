package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ferbo.gestion.model.Telefono;

public class TelefonoDAO extends DAO implements IDAO<Telefono> {
	
	private static final String SELECT = "SELECT id_telefono, nb_telefono, st_principal, tp_telefono FROM telefono ";

	@Override
	public Telefono getBean(ResultSet rs) throws SQLException {
		Telefono bean = new Telefono();
		
		bean.setIdTelefono(getInteger(rs, "id_telefono"));
		bean.setTelefono(getTrim(rs.getString("nb_telefono")));
		bean.setPrincipal(rs.getBoolean("st_principal"));
		bean.setTipoTelefono(getInteger(rs, "tp_telefono"));
		
		return bean;
	}

	@Override
	public List<Telefono> get(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Telefono get(Connection conn, Object id) throws SQLException {
		Telefono bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + "WHERE id_telefono = ? ";
			ps = conn.prepareStatement(sql);
			setInteger(ps, idx++, (Integer) id);
			
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
	public int insert(Connection conn, Telefono bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, Telefono bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, Telefono bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
