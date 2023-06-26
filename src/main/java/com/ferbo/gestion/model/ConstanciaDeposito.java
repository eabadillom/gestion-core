package com.ferbo.gestion.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ConstanciaDeposito {
	private Integer folio = null;
	private Integer idCliente = null;
	private Date fechaIngreso = null;
	private String nombreTransportista = null;
	private String placasTransporte = null;
	private String observaciones = null;
	private String folioCliente = null;
	private BigDecimal valorDeclarado = null;
	private Integer status = null;
	private Integer idAviso = null;
	private String temperatura;
	private List<Partida> partidaList;
	private List<ConstanciaDepositoDetalle> constanciaDepositoDetalleList;
	private Cliente cliente;
	
	public Integer getFolio() {
		return folio;
	}
	public void setFolio(Integer folio) {
		this.folio = folio;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getNombreTransportista() {
		return nombreTransportista;
	}
	public void setNombreTransportista(String nombreTransportista) {
		this.nombreTransportista = nombreTransportista;
	}
	public String getPlacasTransporte() {
		return placasTransporte;
	}
	public void setPlacasTransporte(String placasTransporte) {
		this.placasTransporte = placasTransporte;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getFolioCliente() {
		return folioCliente;
	}
	public void setFolioCliente(String folioCliente) {
		this.folioCliente = folioCliente;
	}
	public BigDecimal getValorDeclarado() {
		return valorDeclarado;
	}
	public void setValorDeclarado(BigDecimal valorDeclarado) {
		this.valorDeclarado = valorDeclarado;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getIdAviso() {
		return idAviso;
	}
	public void setIdAviso(Integer idAviso) {
		this.idAviso = idAviso;
	}
	public String getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}
	public List<Partida> getPartidaList() {
		return partidaList;
	}
	public void setPartidaList(List<Partida> partidaList) {
		this.partidaList = partidaList;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ConstanciaDepositoDetalle> getConstanciaDepositoDetalleList() {
		return constanciaDepositoDetalleList;
	}
	public void setConstanciaDepositoDetalleList(List<ConstanciaDepositoDetalle> constanciaDepositoDetalleList) {
		this.constanciaDepositoDetalleList = constanciaDepositoDetalleList;
	}
	
}
