package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ferbo.gestion.model.Servicio;

public class ServicioDAO extends DAO implements IDAO<Servicio> {
	
	private static final String SELECT = "SELECT "
			+ "	SERVICIO_CVE, SERVICIO_DS, COBRO, SERVICIO_COD, cd_unidad, SERVICIO_NOM, uuid, ST_DEFAULT "
			+ "FROM SERVICIO ";

	@Override
	public Servicio getBean(ResultSet rs) throws SQLException {
		Servicio bean = new Servicio();
		bean.setIdServicio(getInteger(rs, "SERVICIO_CVE"));
		bean.setDescripcion(getTrim(rs.getString("SERVICIO_DS")));
		bean.setIdTipoCobro(getInteger(rs, "COBRO"));
		bean.setCodigo(getTrim(rs.getString("SERVICIO_COD")));
		bean.setCdUnidad(getTrim(rs.getString("cd_unidad")));
		bean.setNombre(getTrim(rs.getString("SERVICIO_NOM")));
		bean.setUuid(getTrim(rs.getString("uuid")));
		bean.setStatusDefault(rs.getBoolean("ST_DEFAULT"));
		return bean;
	}

	@Override
	public List<Servicio> get(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Servicio get(Connection conn, Object id) throws SQLException {
		Servicio bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + "WHERE SERVICIO_CVE = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(idx++, (Integer) id);
			
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
	public int insert(Connection conn, Servicio bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, Servicio bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, Servicio bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
