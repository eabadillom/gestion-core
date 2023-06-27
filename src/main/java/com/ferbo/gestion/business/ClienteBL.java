package com.ferbo.gestion.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ferbo.gestion.dao.ClienteDAO;
import com.ferbo.gestion.model.Cliente;

public class ClienteBL {
	private Connection conn = null;
	private ClienteDAO clienteDAO = null;
	
	public ClienteBL(Connection conn) {
		this.conn = conn;
		clienteDAO = new ClienteDAO();
	}

	public List<Cliente> get(boolean isHabilitado) throws SQLException {
		List<Cliente> clientes = null;
		clientes = clienteDAO.get(conn, isHabilitado);
		return clientes;
	}

	public Cliente get(String numeroCliente) throws SQLException {
		Cliente cliente = null;
		cliente = clienteDAO.getByNumero(conn, numeroCliente);
		return cliente;
	}
}
