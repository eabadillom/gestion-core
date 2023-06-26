package com.ferbo.gestion.model;

import java.math.BigDecimal;
import java.util.List;

public class Partida {
	private Integer idPartida = null;
	private Integer idCamara = null;
	private Integer folio = null;
	private BigDecimal pesoTotal = null;
	private Integer cantidadTotal = null;
	private Integer idUnidadProducto = null;
	private BigDecimal cantidadCobro = null;
	private Integer idUnidadCobro = null;
	private Integer partidaSeq = null;
	private BigDecimal valorMercancia = null;
	private BigDecimal rendimiento = null;
	private BigDecimal numeroTarimas = null;
	
	private UnidadProducto unidadProducto = null;
	private List<DetallePartida> detallePartidaList;
	private Camara camara = null;
	
	public Integer getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(Integer idPartida) {
		this.idPartida = idPartida;
	}
	public Integer getIdCamara() {
		return idCamara;
	}
	public void setIdCamara(Integer idCamara) {
		this.idCamara = idCamara;
	}
	public Integer getFolio() {
		return folio;
	}
	public void setFolio(Integer folio) {
		this.folio = folio;
	}
	public BigDecimal getPesoTotal() {
		return pesoTotal;
	}
	public void setPesoTotal(BigDecimal pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	public Integer getCantidadTotal() {
		return cantidadTotal;
	}
	public void setCantidadTotal(Integer cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}
	public Integer getIdUnidadProducto() {
		return idUnidadProducto;
	}
	public void setIdUnidadProducto(Integer idUnidadProducto) {
		this.idUnidadProducto = idUnidadProducto;
	}
	public BigDecimal getCantidadCobro() {
		return cantidadCobro;
	}
	public void setCantidadCobro(BigDecimal cantidadCobro) {
		this.cantidadCobro = cantidadCobro;
	}
	public Integer getIdUnidadCobro() {
		return idUnidadCobro;
	}
	public void setIdUnidadCobro(Integer idUnidadCobro) {
		this.idUnidadCobro = idUnidadCobro;
	}
	public Integer getPartidaSeq() {
		return partidaSeq;
	}
	public void setPartidaSeq(Integer partidaSeq) {
		this.partidaSeq = partidaSeq;
	}
	public BigDecimal getValorMercancia() {
		return valorMercancia;
	}
	public void setValorMercancia(BigDecimal valorMercancia) {
		this.valorMercancia = valorMercancia;
	}
	public BigDecimal getRendimiento() {
		return rendimiento;
	}
	public void setRendimiento(BigDecimal rendimiento) {
		this.rendimiento = rendimiento;
	}
	public BigDecimal getNumeroTarimas() {
		return numeroTarimas;
	}
	public void setNumeroTarimas(BigDecimal numeroTarimas) {
		this.numeroTarimas = numeroTarimas;
	}
	public UnidadProducto getUnidadProducto() {
		return unidadProducto;
	}
	public void setUnidadProducto(UnidadProducto unidadProducto) {
		this.unidadProducto = unidadProducto;
	}
	public List<DetallePartida> getDetallePartidaList() {
		return detallePartidaList;
	}
	public void setDetallePartidaList(List<DetallePartida> detallePartidaList) {
		this.detallePartidaList = detallePartidaList;
	}
	public Camara getCamara() {
		return camara;
	}
	public void setCamara(Camara camara) {
		this.camara = camara;
	}
	
}
