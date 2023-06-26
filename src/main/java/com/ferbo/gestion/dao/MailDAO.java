package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ferbo.gestion.model.Mail;

public class MailDAO extends DAO implements IDAO<Mail> {
	
	private static final String SELECT = "SELECT id_mail, nb_mail, st_principal, tp_mail FROM mail ";

	@Override
	public Mail getBean(ResultSet rs) throws SQLException {
		Mail bean = new Mail();
		bean.setIdMail(getInteger(rs, "id_mail"));
		bean.setMail(getTrim(rs.getString("nb_mail")));
		bean.setPrincipal(rs.getBoolean("st_principal"));
		bean.setIdTipoMail(getInteger(rs, "tp_mail"));
		return bean;
	}

	@Override
	public List<Mail> get(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mail get(Connection conn, Object id) throws SQLException {
		Mail bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = SELECT + "WHERE id_mail = ?";
		int idx = 1;
		
		try {
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
	public int insert(Connection conn, Mail bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, Mail bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, Mail bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
