package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ferbo.gestion.model.EnvioInventario;

public class EnvioInventarioDAO extends DAO implements IDAO<EnvioInventario> {
	
	private static final String SELECT = "SELECT id_envio, id_cliente, fh_envio, st_enviado FROM envio_inventario ";
	private static final String INSERT = "INSERT INTO envio_inventario (id_cliente, fh_envio, st_enviado) VALUES( ?, ?, ?) ";
	private static final String UPDATE = "UPDATE envio_inventario SET id_cliente = ?, fh_envio = ?, st_enviado = ? WHERE id_envio = ? ";
	private static final String DELETE = "DELETE FROM envio_inventario WHERE id_envio = ? ";

	@Override
	public EnvioInventario getBean(ResultSet rs) throws SQLException {
		EnvioInventario bean = EnvioInventario.builder()
				.Id(getInteger(rs, "id_envio"))
				.IdCliente(getInteger(rs, "id_cliente"))
				.FechaEnvio(getLocalDate(rs, "fh_envio"))
				.Enviado(rs.getBoolean("st_enviado"))
				.build()
				;
		
		return bean;
	}

	@Override
	public List<EnvioInventario> get(Connection conn) throws SQLException {
		throw new UnsupportedOperationException("Esta función no está definida.");
	}

	@Override
	public EnvioInventario get(Connection conn, Object id) throws SQLException {
		EnvioInventario bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + "WHERE id_envio = ? ";
			ps = conn.prepareStatement(sql);
			setInteger(ps,  idx++, (Integer) id);
			
			rs = ps.executeQuery();
			
			if(rs.next())
				bean = this.getBean(rs);
			
		} finally {
			close(rs);
			close(ps);
		}
		
		return bean;
	}

	@Override
	public int insert(Connection conn, EnvioInventario bean) throws SQLException {
		int rows = -1;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int idx = 1;
		
		try {
			ps = conn.prepareStatement(INSERT);
			setInteger(ps, idx++, bean.getIdCliente());
			ps.setObject(idx++, bean.getFechaEnvio());
			ps.setBoolean(idx++, bean.getEnviado());
			
			rows = ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				bean = EnvioInventario.builder()
				.Id(rs.getInt(1))
				.IdCliente(bean.getIdCliente())
				.FechaEnvio(bean.getFechaEnvio())
				.Enviado(bean.getEnviado())
				.build()
				;
			}
			
		} finally {
			close(rs);
			close(ps);
		}
		return rows;
	}

	@Override
	public int update(Connection conn, EnvioInventario bean) throws SQLException {
		int rows = -1;
		PreparedStatement ps = null;
		int idx = 1;
		
		try {
			ps = conn.prepareStatement(UPDATE);
			setInteger(ps, idx++, bean.getIdCliente());
			setLocalDate(ps, idx++, bean.getFechaEnvio());
			setBoolean(ps, idx++, bean.getEnviado());
			setInteger(ps, idx++, bean.getId());
			
			rows = ps.executeUpdate();
		} finally {
			close(ps);
		}
		
		return rows;
	}

	@Override
	public int delete(Connection conn, EnvioInventario bean) throws SQLException {
		int rows = -1;
		PreparedStatement ps = null;
		int idx = 1;
		
		try {
			ps = conn.prepareStatement(DELETE);
			setInteger(ps, idx++, bean.getId());
			
			rows = ps.executeUpdate();
		} finally {
			close(ps);
		}
		
		return rows;
	}
}
