package com.ferbo.gestion.model;

import java.math.BigDecimal;
import java.util.Date;

public class DetallePartida {
	private Integer idDetallePartida = null;
	private Integer idPartida = null;
	private Integer idTipoMovimiento = null;
	private Integer IdEstadoMovimiento = null;
	private Integer idDetalleAnterior = null;
	private Integer idPartidaAnterior = null;
	private Integer idDetallePadre = null;
	private Integer idPartidaPadre = null;
	private Integer cantidad = null;
	private Integer idUnidadMedida = null;
	private BigDecimal peso = null;
	private String codigo = null;
	private String lote = null;
	private Date caducidad = null;
	private String po = null;
	private String mp = null;
	private String pedimento = null;
	private String sap = null;
	private String tarimas = null;
	
	public Integer getIdDetallePartida() {
		return idDetallePartida;
	}
	public void setIdDetallePartida(Integer idDetallePartida) {
		this.idDetallePartida = idDetallePartida;
	}
	public Integer getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(Integer idPartida) {
		this.idPartida = idPartida;
	}
	public Integer getIdTipoMovimiento() {
		return idTipoMovimiento;
	}
	public void setIdTipoMovimiento(Integer idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
	}
	public Integer getIdEstadoMovimiento() {
		return IdEstadoMovimiento;
	}
	public void setIdEstadoMovimiento(Integer idEstadoMovimiento) {
		IdEstadoMovimiento = idEstadoMovimiento;
	}
	public Integer getIdDetalleAnterior() {
		return idDetalleAnterior;
	}
	public void setIdDetalleAnterior(Integer idDetalleAnterior) {
		this.idDetalleAnterior = idDetalleAnterior;
	}
	public Integer getIdPartidaAnterior() {
		return idPartidaAnterior;
	}
	public void setIdPartidaAnterior(Integer idPartidaAnterior) {
		this.idPartidaAnterior = idPartidaAnterior;
	}
	public Integer getIdDetallePadre() {
		return idDetallePadre;
	}
	public void setIdDetallePadre(Integer idDetallePadre) {
		this.idDetallePadre = idDetallePadre;
	}
	public Integer getIdPartidaPadre() {
		return idPartidaPadre;
	}
	public void setIdPartidaPadre(Integer idPartidaPadre) {
		this.idPartidaPadre = idPartidaPadre;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getIdUnidadMedida() {
		return idUnidadMedida;
	}
	public void setIdUnidadMedida(Integer idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}
	public BigDecimal getPeso() {
		return peso;
	}
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public Date getCaducidad() {
		return caducidad;
	}
	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}
	public String getPo() {
		return po;
	}
	public void setPo(String po) {
		this.po = po;
	}
	public String getMp() {
		return mp;
	}
	public void setMp(String mp) {
		this.mp = mp;
	}
	public String getPedimento() {
		return pedimento;
	}
	public void setPedimento(String pedimento) {
		this.pedimento = pedimento;
	}
	public String getSap() {
		return sap;
	}
	public void setSap(String sap) {
		this.sap = sap;
	}
	public String getTarimas() {
		return tarimas;
	}
	public void setTarimas(String tarimas) {
		this.tarimas = tarimas;
	}
	
}
