package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ferbo.gestion.model.Cliente;

public class ClienteDAO extends DAO implements IDAO<Cliente> {
	
	private static final String SELECT = "SELECT "
			+ "	CTE_CVE, CTE_NOMBRE, CTE_RFC, numero_cte, cte_mail, habilitado, COD_UNICO, tp_persona, cd_regimen, cd_uso_cfdi, cd_metodo_pago, cd_forma_pago, nb_regimen_capital, uuid "
			+ "FROM CLIENTE ";	

	@Override
	public Cliente getBean(ResultSet rs) throws SQLException {
		Cliente bean = new Cliente();
		bean.setIdCliente(getInteger(rs, "CTE_CVE"));
		bean.setNombre(getTrim(rs.getString("CTE_NOMBRE")));
		bean.setRfc(getTrim(rs.getString("CTE_RFC")));
		bean.setNumero(getTrim(rs.getString("numero_cte")));
		bean.setMail(getTrim(rs.getString("cte_mail")));
		bean.setHabilitado(rs.getBoolean("habilitado"));
		bean.setCodigoUnico(getTrim(rs.getString("COD_UNICO")));
		bean.setTipoPersona(getTrim(rs.getString("tp_persona")));
		bean.setIdRegimenFiscal(getTrim(rs.getString("cd_regimen")));
		bean.setIdUsoCFDI(getTrim(rs.getString("cd_uso_cfdi")));
		bean.setIdMetodoPago(getTrim(rs.getString("cd_metodo_pago")));
		bean.setIdFormaPago(getTrim(rs.getString("cd_forma_pago")));
		bean.setRegimenCapital(getTrim(rs.getString("nb_regimen_capital")));
		bean.setUuid(getTrim(rs.getString("uuid")));
		return bean;
	}

	@Override
	public List<Cliente> get(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Cliente> get(Connection conn, boolean isHabilitado) throws SQLException {
		List<Cliente> beans = null;
		Cliente bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + " WHERE habilitado = ? ";
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

	@Override
	public int insert(Connection conn, Cliente bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, Cliente bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, Cliente bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
