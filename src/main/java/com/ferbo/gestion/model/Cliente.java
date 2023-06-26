package com.ferbo.gestion.model;

public class Cliente {
	private Integer idCliente = null;
	private String nombre = null;
	private String rfc = null;
	private String numero = null;
	private String mail = null;
	private boolean habilitado = false;
	private String codigoUnico = null;
	private String tipoPersona = null;
	private String idRegimenFiscal = null;
	private String idUsoCFDI = null;
	private String idMetodoPago = null;
	private String idFormaPago = null;
	private String regimenCapital = null;
	private String uuid = null;
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	public String getCodigoUnico() {
		return codigoUnico;
	}
	public void setCodigoUnico(String codigoUnico) {
		this.codigoUnico = codigoUnico;
	}
	public String getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	public String getIdRegimenFiscal() {
		return idRegimenFiscal;
	}
	public void setIdRegimenFiscal(String idRegimenFiscal) {
		this.idRegimenFiscal = idRegimenFiscal;
	}
	public String getIdUsoCFDI() {
		return idUsoCFDI;
	}
	public void setIdUsoCFDI(String idUsoCFDI) {
		this.idUsoCFDI = idUsoCFDI;
	}
	public String getIdMetodoPago() {
		return idMetodoPago;
	}
	public void setIdMetodoPago(String idMetodoPago) {
		this.idMetodoPago = idMetodoPago;
	}
	public String getIdFormaPago() {
		return idFormaPago;
	}
	public void setIdFormaPago(String idFormaPago) {
		this.idFormaPago = idFormaPago;
	}
	public String getRegimenCapital() {
		return regimenCapital;
	}
	public void setRegimenCapital(String regimenCapital) {
		this.regimenCapital = regimenCapital;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
