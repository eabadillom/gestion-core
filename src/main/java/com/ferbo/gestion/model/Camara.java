package com.ferbo.gestion.model;

public class Camara {
	private Integer idCamara = null;
	private Integer idPlanta = null;
	private String nombre = null;
	private String abreviatura = null;
	private Planta planta = null;
	
	public Integer getIdCamara() {
		return idCamara;
	}
	public void setIdCamara(Integer idCamara) {
		this.idCamara = idCamara;
	}
	public Integer getIdPlanta() {
		return idPlanta;
	}
	public void setIdPlanta(Integer idPlanta) {
		this.idPlanta = idPlanta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	public Planta getPlanta() {
		return planta;
	}
	public void setPlanta(Planta planta) {
		this.planta = planta;
	}
}
