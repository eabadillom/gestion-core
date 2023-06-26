package com.ferbo.gestion.model;

public class UnidadProducto {
	private Integer idUnidadProducto = null;
	private Integer idProducto = null;
	private Integer idUnidadManejo;
	private Producto producto = null;
	private UnidadManejo unidadManejo = null;
	
	public Integer getIdUnidadProducto() {
		return idUnidadProducto;
	}
	public void setIdUnidadProducto(Integer idUnidadProducto) {
		this.idUnidadProducto = idUnidadProducto;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public Integer getIdUnidadManejo() {
		return idUnidadManejo;
	}
	public void setIdUnidadManejo(Integer idUnidadManejo) {
		this.idUnidadManejo = idUnidadManejo;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public UnidadManejo getUnidadManejo() {
		return unidadManejo;
	}
	public void setUnidadManejo(UnidadManejo unidadManejo) {
		this.unidadManejo = unidadManejo;
	}
	

}
