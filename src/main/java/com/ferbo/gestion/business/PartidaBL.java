package com.ferbo.gestion.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ferbo.gestion.dao.PartidaDAO;
import com.ferbo.gestion.dao.ProductoDAO;
import com.ferbo.gestion.dao.UnidadManejoDAO;
import com.ferbo.gestion.dao.UnidadProductoDAO;
import com.ferbo.gestion.model.Partida;
import com.ferbo.gestion.model.Producto;
import com.ferbo.gestion.model.UnidadManejo;
import com.ferbo.gestion.model.UnidadProducto;

public class PartidaBL {
	PartidaDAO partidaDAO = null;
	UnidadProductoDAO unidadProductoDAO = null;
	UnidadManejoDAO unidadManejoDAO = null;
	ProductoDAO productoDAO = null;
	
	public PartidaBL() {
		this.partidaDAO = new PartidaDAO();
		this.unidadProductoDAO = new UnidadProductoDAO();
		this.unidadManejoDAO = new UnidadManejoDAO();
		this.productoDAO = new ProductoDAO();
	}
	
	public List<Partida> get(Connection conn, Integer folio)
	throws SQLException{
		List<Partida> partidas = null;
		
		partidas = partidaDAO.getByFolio(conn, folio);
		
		for(Partida partida : partidas) {
			UnidadProducto udp = unidadProductoDAO.get(conn, partida.getIdUnidadProducto());
			UnidadManejo udm = this.unidadManejoDAO.get(conn, udp.getIdUnidadManejo());
			Producto producto = this.productoDAO.get(conn, udp.getIdProducto());
			udp.setUnidadManejo(udm);
			udp.setProducto(producto);
			partida.setUnidadProducto(udp);
		}
		
		return partidas;
	}

}
