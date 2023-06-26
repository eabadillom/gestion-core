package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ferbo.gestion.model.Contacto;

public class ContactoDAO extends DAO implements IDAO<Contacto> {
	private static final String SELECT = "SELECT id_contacto, nb_nombre, nb_apellido_1, nb_apellido_2 FROM contacto ";

	@Override
	public Contacto getBean(ResultSet rs) throws SQLException {
		Contacto bean = new Contacto();
		
		bean.setIdContacto(rs.getInt("id_contacto"));
		bean.setNombre(rs.getString("nb_nombre"));
		bean.setApellido1(rs.getString("nb_apellido_1"));
		bean.setApellido2(rs.getString("nb_apellido_2"));
		
		return bean;
	}

	@Override
	public List<Contacto> get(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contacto get(Connection conn, Object id) throws SQLException {
		Contacto bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + "WHERE id_contacto = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(idx++, (Integer)id);
			
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
	public int insert(Connection conn, Contacto bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, Contacto bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, Contacto bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
