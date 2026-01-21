package com.ferbo.gestion.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ferbo.gestion.core.model.Cliente;

public class ClienteDAO extends DAO implements IDAO<Cliente> {
	
	private static final String SELECT = "SELECT "
			+ "	CTE_CVE, CTE_NOMBRE, CTE_RFC, numero_cte, cte_mail, habilitado, COD_UNICO, tp_persona, cd_regimen, cd_uso_cfdi, cd_metodo_pago, cd_forma_pago, nb_regimen_capital, uuid "
			+ "FROM cliente ";	
	private static final String INSERT = "INSERT INTO cliente (CTE_NOMBRE, nb_alias, CTE_RFC, numero_cte, cte_mail, habilitado, COD_UNICO, tp_persona, cd_regimen, cd_uso_cfdi, cd_metodo_pago, cd_forma_pago, nb_regimen_capital, uuid) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
	private static final String UPDATE = "UPDATE cliente SET CTE_NOMBRE = ?, nb_alias = ?, CTE_RFC = ?, numero_cte = ?, cte_mail = ?, habilitado = ?, COD_UNICO = ?, tp_persona = ?, cd_regimen = ?, cd_uso_cfdi = ?, cd_metodo_pago = ?, cd_forma_pago = ?, nb_regimen_capital = ?, uuid = ? WHERE CTE_CVE = ?";
	private static final String DELETE = "DELETE FROM cliente WHERE CTE_CVE = ? ";
	
	@Override
	public Cliente getBean(ResultSet rs) throws SQLException {
		Cliente bean = Cliente
				.builder()
				.IdCliente(getInteger(rs, "CTE_CVE"))
				.Nombre(getString(rs, "CTE_NOMBRE"))
				.Rfc(getString(rs, "CTE_RFC"))
				.Numero(getString(rs, "numero_cte"))
				.Mail(getString(rs, "cte_mail"))
				.Habilitado(getBoolean(rs, "habilitado"))
				.CodigoUnico(getString(rs, "COD_UNICO"))
				.TipoPersona(getString(rs, "tp_persona"))
				.IdRegimenFiscal(getString(rs, "cd_regimen"))
				.IdUsoCFDI(getString(rs, "cd_uso_cfdi"))
				.IdMetodoPago(getString(rs, "cd_metodo_pago"))
				.IdFormaPago(getString(rs, "cd_forma_pago"))
				.RegimenCapital(getString(rs, "nb_regimen_capital"))
				.build();
		
		return bean;
	}

	@Override
	public List<Cliente> get(Connection conn) throws SQLException {
		throw new UnsupportedOperationException("Búsqueda no implementada.");
	}
	
	public List<Cliente> get(Connection conn, boolean isHabilitado) throws SQLException {
		List<Cliente> beans = null;
		Cliente bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + " WHERE habilitado = ? ORDER BY CTE_CVE DESC ";
			ps = conn.prepareStatement(sql);
			ps.setBoolean(idx++, isHabilitado);
			
			rs = ps.executeQuery();
			beans = new ArrayList<Cliente>();
			
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

	@Override
	public Cliente get(Connection conn, Object id) throws SQLException {
		Cliente bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + "WHERE CTE_CVE = ?";
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
	
	public Cliente getByNumero(Connection conn, String numeroCliente) throws SQLException {
		Cliente bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + "WHERE numero_cte = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(idx++, getTrim(numeroCliente));
			
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
	public int insert(Connection conn, Cliente bean) throws SQLException {
		int rows = -1;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int idx = 1;
		
		try {
			ps = conn.prepareStatement(INSERT);
			setString(ps, idx++, bean.getNombre());
			setString(ps, idx++, bean.getAlias());
			setString(ps, idx++, bean.getRfc());
			setString(ps, idx++, bean.getNumero());
			setString(ps, idx++, bean.getMail());
			setBoolean(ps, idx++, bean.isHabilitado());
			setString(ps, idx++, bean.getCodigoUnico());
			setString(ps, idx++, bean.getTipoPersona());
			setString(ps, idx++, bean.getIdRegimenFiscal());
			setString(ps, idx++, bean.getIdUsoCFDI());
			setString(ps, idx++, bean.getIdMetodoPago());
			setString(ps, idx++, bean.getIdFormaPago());
			setString(ps, idx++, bean.getRegimenCapital());
			
			rows = ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				bean = getBean(rs);
				bean.setIdCliente(getInteger(rs, "CTE_CVE"));
			}
			
		} finally {
			close(rs);
			close(rs);
		}
		
		return rows;
	}

	@Override
	public int update(Connection conn, Cliente bean) throws SQLException {
		int rows = -1;
		PreparedStatement ps = null;
		int idx = 1;
		
		try {
			ps = conn.prepareStatement(UPDATE);
			
			setString(ps, idx++, bean.getNombre());
			setString(ps, idx++, bean.getAlias());
			setString(ps, idx++, bean.getRfc());
			setString(ps, idx++, bean.getNumero());
			setString(ps, idx++, bean.getMail());
			setBoolean(ps, idx++, bean.isHabilitado());
			setString(ps, idx++, bean.getCodigoUnico());
			setString(ps, idx++, bean.getTipoPersona());
			setString(ps, idx++, bean.getIdRegimenFiscal());
			setString(ps, idx++, bean.getIdUsoCFDI());
			setString(ps, idx++, bean.getIdMetodoPago());
			setString(ps, idx++, bean.getIdFormaPago());
			setString(ps, idx++, bean.getRegimenCapital());
			setInteger(ps, idx++, bean.getIdCliente());
			
			rows = ps.executeUpdate();
			
		} finally {
			close(ps);
		}
		
		return rows;
	}

	@Override
	public int delete(Connection conn, Cliente bean) throws SQLException {
		int rows = -1;
		PreparedStatement ps = null;
		int idx = 1;
		
		try {
			ps = conn.prepareStatement(DELETE);
			setInteger(ps, idx++, bean.getIdCliente());
			
			rows = ps.executeUpdate();
		} finally {
			close(ps);
		}
		
		return rows;
	}
}
