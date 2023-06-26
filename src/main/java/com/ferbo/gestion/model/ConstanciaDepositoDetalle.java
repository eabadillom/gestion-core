package com.ferbo.gestion.model;

import java.math.BigDecimal;

public class ConstanciaDepositoDetalle {
	
	private Integer idConstanciaDepositoDetalle = null;
	private Integer idServicio = null;
	private Servicio servicio = null;
	private Integer folio = null;
	private BigDecimal cantidad = null;
	
	public Integer getIdConstanciaDepositoDetalle() {
		return idConstanciaDepositoDetalle;
	}
	public void setIdConstanciaDepositoDetalle(Integer idConstanciaDepositoDetalle) {
		this.idConstanciaDepositoDetalle = idConstanciaDepositoDetalle;
	}
	public Integer getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	public Integer getFolio() {
		return folio;
	}
	public void setFolio(Integer folio) {
		this.folio = folio;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "{\"idConstanciaDepositoDetalle\":\"" + idConstanciaDepositoDetalle + "\", \"idServicio\":\""
				+ idServicio + "\", \"servicio\":\"" + servicio + "\", \"folio\":\"" + folio + "\", \"cantidad\":\""
				+ cantidad + "\"}";
	}
}
