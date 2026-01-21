package com.ferbo.gestion.core.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ferbo.gestion.core.dao.ConstanciaDepositoDetalleDAO;
import com.ferbo.gestion.core.dao.ServicioDAO;
import com.ferbo.gestion.core.dao.TipoCobroDAO;
import com.ferbo.gestion.core.model.ConstanciaDepositoDetalle;
import com.ferbo.gestion.core.model.Servicio;
import com.ferbo.gestion.core.model.TipoCobro;

public class ConstanciaDepositoDetalleBL {
	
	private ConstanciaDepositoDetalleDAO cddDAO = null;
	private ServicioDAO servicioDAO = null;
	private TipoCobroDAO tipoCobroDAO = null;
	
	public ConstanciaDepositoDetalleBL() {
		this.cddDAO = new ConstanciaDepositoDetalleDAO();
		this.servicioDAO = new ServicioDAO();
		this.tipoCobroDAO = new TipoCobroDAO();
	}

	public List<ConstanciaDepositoDetalle> getByFolio(Connection conn, Integer folio) throws SQLException {
		List<ConstanciaDepositoDetalle> detalles = null;
		
		detalles = cddDAO.getByFolio(conn, folio);
		
		for(ConstanciaDepositoDetalle detalle : detalles) {
			Servicio servicio = servicioDAO.get(conn, detalle.getIdServicio());
			TipoCobro tipoCobro = tipoCobroDAO.get(conn, servicio.getIdTipoCobro());
			servicio.setTipoCobro(tipoCobro);
			detalle.setServicio(servicio);
		}
		
		return detalles;
	}
}
