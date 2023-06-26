package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ferbo.gestion.model.ClienteContacto;

public class ClienteContactoDAO extends DAO implements IDAO<ClienteContacto> {
	
	private static final String SELECT = "SELECT id_cliente, id_contacto, st_habilitado, nb_usuario, nb_password, st_usuario, fh_alta, fh_cad_passwd, fh_ult_acceso, st_facturacion, st_inventario FROM cliente_contacto ";

	@Override
	public ClienteContacto getBean(ResultSet rs) throws SQLException {
		ClienteContacto bean = new ClienteContacto();
		
		bean.setIdCliente(rs.getInt("id_cliente"));
		bean.setIdContacto(rs.getInt("id_contacto"));
		bean.setHabilitado(rs.getBoolean("st_habilitado"));
		bean.setUsuario(getTrim(rs.getString("nb_usuario")));
		bean.setPassword(getTrim(rs.getString("nb_password")));
		bean.setStatusUsuario(getTrim(rs.getString("st_usuario")));
		bean.setFechaAlta(rs.getDate("fh_alta"));
		bean.setFechaCaducidad(rs.getDate("fh_cad_passwd"));
		bean.setFechaUltimoAcceso(rs.getDate("fh_ult_acceso"));
		bean.setFacturacion(rs.getBoolean("st_facturacion"));
		bean.setInventario(rs.getBoolean("st_inventario"));
		
		return bean;
	}

	@Override
	public List<ClienteContacto> get(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<ClienteContacto> get(Connection conn, Integer idCliente) throws SQLException{
		List<ClienteContacto> beans = null;
		ClienteContacto bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + " WHERE id_cliente = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(idx++, idCliente);
			
			rs = ps.executeQuery();
			beans = new ArrayList<ClienteContacto>();
			while(rs.next()) {
				bean = getBean(rs);
				beans.add(bean);
			}
			
		} finally {
			close(rs);
			close(ps);
		}
		
		return beans;
	}
	
	public ClienteContacto get(Connection conn, Integer idCliente, Integer idContacto) throws SQLException{
		ClienteContacto bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + " WHERE id_cliente = ? AND id_contacto = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(idx++, idCliente);
			ps.setInt(idx++, idContacto);
			
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
	public ClienteContacto get(Connection conn, Object id) throws SQLException {
		
		return null;
	}

	@Override
	public int insert(Connection conn, ClienteContacto bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, ClienteContacto bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, ClienteContacto bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
