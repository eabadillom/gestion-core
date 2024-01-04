package com.ferbo.gestion.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferbo.gestion.dao.ConstanciaDepositoDAO;
import com.ferbo.gestion.model.ConstanciaDeposito;
import com.ferbo.gestion.tools.GestionException;

public class InventarioBO {
	private static Logger log = LogManager.getLogger(InventarioBO.class);
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
	
	public boolean tieneInventario(Integer idCliente, Date fechaCorte) throws SQLException, GestionException {
		boolean tieneInventario = false;
		
		tieneInventario = constanciaDepositoDAO.tieneInventario(conn, idCliente, fechaCorte);
		log.info("El cliente {} tiene inventario: {}", idCliente, tieneInventario);
		
		return tieneInventario;
	}
}
