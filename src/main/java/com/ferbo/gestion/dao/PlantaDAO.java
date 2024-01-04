package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ferbo.gestion.model.Planta;

public class PlantaDAO extends DAO implements IDAO<Planta> {
	
	private static final String SELECT = "select PLANTA_CVE, PLANTA_DS, planta_abrev, planta_sufijo, PLANTA_COD, id_usuario, uuid, nb_cp, id_pais, id_estado, id_municipio, id_ciudad, id_asentamiento, tp_asentamiento, nb_calle, nu_exterior, nu_interior, cd_emisor, nb_ubicacion from planta ";

	@Override
	public Planta getBean(ResultSet rs) throws SQLException {
		Planta bean = new Planta();
		bean.setIdPlanta(getInteger(rs, "PLANTA_CVE"));
		bean.setNombre(getTrim(rs.getString("PLANTA_DS")));
		bean.setAbreviatura(getTrim(rs.getString("planta_abrev")));
		bean.setSufijo(getTrim(rs.getString("planta_sufijo")));
		bean.setCodigo(getTrim(rs.getString("PLANTA_COD")));
		bean.setIdUsuario(getInteger(rs, "id_usuario"));
		bean.setUuid(getTrim(rs.getString("uuid")));
		bean.setCodigoPostal(getTrim(rs.getString("nb_cp")));
		bean.setIdPais(getInteger(rs, "id_pais"));
		bean.setIdEstado(getInteger(rs, "id_estado"));
		bean.setIdMunicipio(getInteger(rs, "id_municipio"));
		bean.setIdCiudad(getInteger(rs, "id_ciudad"));
		bean.setIdAsentamiento(getInteger(rs, "id_asentamiento"));
		bean.setTipoAsentamiento(getInteger(rs, "tp_asentamiento"));
		bean.setCalle(getTrim(rs.getString("nb_calle")));
		bean.setNumeroExterior(getTrim(rs.getString("nu_exterior")));
		bean.setNumeroInterior(getTrim(rs.getString("nu_interior")));
		bean.setIdEmisor(getInteger(rs, "cd_emisor"));
		bean.setUbicacion(getTrim("nb_ubicacion"));
		return bean;
	}

	@Override
	public List<Planta> get(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Planta get(Connection conn, Object id) throws SQLException {
		Planta bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + "WHERE PLANTA_CVE = ?";
			ps = conn.prepareStatement(sql);
			setInteger(ps, idx++, (Integer)id);
			
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
	public int insert(Connection conn, Planta bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, Planta bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, Planta bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
