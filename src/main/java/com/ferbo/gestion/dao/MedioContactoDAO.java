package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ferbo.gestion.model.MedioContacto;

public class MedioContactoDAO extends DAO implements IDAO<MedioContacto> {
	
	private static final String SELECT = "SELECT mc.id_medio, mc.tp_medio, mc.st_medio, mc.id_contacto, mc.id_mail, mc.id_telefono FROM medio_cnt mc ";

	@Override
	public MedioContacto getBean(ResultSet rs) throws SQLException {
		MedioContacto bean = new MedioContacto();
		
		bean.setIdMedio(getInteger(rs, "id_medio"));
		bean.setTipoMedio(getTrim(rs.getString("tp_medio")));
		bean.setHabilitado(rs.getBoolean("st_medio"));
		bean.setIdContacto(getInteger(rs, "id_contacto"));
		bean.setIdMail(getInteger(rs, "id_mail"));
		bean.setIdTelefono(getInteger(rs, "id_telefono"));
		
		return bean;
	}

	@Override
	public List<MedioContacto> get(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<MedioContacto> get(Connection conn, Integer idContacto) throws SQLException{
		List<MedioContacto> beans = null;
		MedioContacto       bean = null;
		PreparedStatement   ps = null;
		ResultSet           rs = null;
		String              sql = null;
		int                 idx = 1;
		
		try {
			sql = SELECT + "WHERE id_contacto = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(idx++, idContacto);
			
			
			rs = ps.executeQuery();
			beans = new ArrayList<MedioContacto>();
			while(rs.next()) {
				bean = this.getBean(rs);
				beans.add(bean);
			}
		} finally {
			close(rs);
			close(ps);
		}		
		return beans;
	}

	@Override
	public MedioContacto get(Connection conn, Object id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Connection conn, MedioContacto bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, MedioContacto bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, MedioContacto bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
