package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ferbo.gestion.model.TipoMail;

public class TipoMailDAO extends DAO implements IDAO<TipoMail> {
	
	private static final String SELECT = "SELECT tp_mail, nb_tipo FROM tipo_mail ";

	@Override
	public TipoMail getBean(ResultSet rs) throws SQLException {
		TipoMail bean = new TipoMail();
		bean.setTipoMail(getInteger(rs, "tp_mail"));
		bean.setNombreMail(getTrim(rs.getString("nb_tipo")));
		return bean;
	}

	@Override
	public List<TipoMail> get(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoMail get(Connection conn, Object id) throws SQLException {
		TipoMail bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + "WHERE tp_mail = ? ";
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
	public int insert(Connection conn, TipoMail bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, TipoMail bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, TipoMail bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
