package com.ferbo.gestion.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.ferbo.gestion.dao.ConstanciaDepositoDAO;
import com.ferbo.gestion.model.ConstanciaDeposito;

public class InventarioBO {
	
	private Connection conn = null;
	private ConstanciaDepositoDAO constanciaDepositoDAO = null;
	
	public InventarioBO(Connection conn) {
		this.conn = conn;
		constanciaDepositoDAO = new ConstanciaDepositoDAO();
	}
	
	public List<ConstanciaDeposito> getDepositosAlCorte(Integer idCliente, Date fechaCorte) throws SQLException {
		List<ConstanciaDeposito> constancias = null;
		
		PartidaBL partidas = null;
		ConstanciaDepositoDetalleBL detalles = null;
		
		constancias = constanciaDepositoDAO.getConstanciasConSaldo(conn, idCliente, fechaCorte);
		partidas = new PartidaBL();
		detalles = new ConstanciaDepositoDetalleBL();
		
		for(ConstanciaDeposito constancia : constancias) {
			constancia.setPartidaList(partidas.get(conn, constancia.getFolio()));
			constancia.setConstanciaDepositoDetalleList(detalles.getByFolio(conn, constancia.getFolio()));
		}
		
		return constancias;
	}
}
