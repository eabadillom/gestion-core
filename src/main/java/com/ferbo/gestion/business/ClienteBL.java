package com.ferbo.gestion.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ferbo.gestion.dao.ClienteDAO;
import com.ferbo.gestion.model.Cliente;

public class ClienteBL {
	private Connection conn = null;
	
	public ClienteBL(Connection conn) {
		this.conn = conn;
	}

	public List<Cliente> get(boolean isHabilitado) throws SQLException {
		List<Cliente> clientes = null;
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.get(conn, isHabilitado);
		return clientes;
	}

	public Cliente get(String numeroCliente) {
		Cliente cliente = null;
		
		return cliente;
	}
}
