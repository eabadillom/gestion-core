package com.ferbo.gestion.model;

public class Servicio {
	
	private Integer idServicio = null;
	private String descripcion = null;
	private Integer idTipoCobro = null;
	private TipoCobro tipoCobro = null;
	private String codigo = null;
	private String cdUnidad = null;
	private String nombre = null;
	private String uuid = null;
	private Boolean statusDefault = null;
	
	public Integer getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getIdTipoCobro() {
		return idTipoCobro;
	}
	public void setIdTipoCobro(Integer idTipoCobro) {
		this.idTipoCobro = idTipoCobro;
	}
	public TipoCobro getTipoCobro() {
		return tipoCobro;
	}
	public void setTipoCobro(TipoCobro tipoCobro) {
		this.tipoCobro = tipoCobro;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCdUnidad() {
		return cdUnidad;
	}
	public void setCdUnidad(String cdUnidad) {
		this.cdUnidad = cdUnidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Boolean getStatusDefault() {
		return statusDefault;
	}
	public void setStatusDefault(Boolean statusDefault) {
		this.statusDefault = statusDefault;
	}
	@Override
	public String toString() {
		return "{\"idServicio\":\"" + idServicio + "\", \"descripcion\":\"" + descripcion + "\", \"idTipoCobro\":\""
				+ idTipoCobro + "\", \"tipoCobro\":\"" + tipoCobro + "\", \"codigo\":\"" + codigo
				+ "\", \"cdUnidad\":\"" + cdUnidad + "\", \"nombre\":\"" + nombre + "\", \"uuid\":\"" + uuid
				+ "\", \"statusDefault\":\"" + statusDefault + "\"}";
	}
}
