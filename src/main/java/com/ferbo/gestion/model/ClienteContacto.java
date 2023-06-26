package com.ferbo.gestion.model;

import java.util.Date;

public class ClienteContacto {
	
	private Integer idCliente = null;
	private Integer idContacto = null;
	private boolean habilitado = false;
	private String usuario = null;
	private String password = null;
	private String statusUsuario = null;
	private Date fechaAlta = null;
	private Date fechaCaducidad = null;
	private Date fechaUltimoAcceso = null;
	private boolean facturacion = false;
	private boolean inventario = false;
	
	private Contacto contacto = null;
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Integer getIdContacto() {
		return idContacto;
	}
	public void setIdContacto(Integer idContacto) {
		this.idContacto = idContacto;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	public Contacto getContacto() {
		return contacto;
	}
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatusUsuario() {
		return statusUsuario;
	}
	public void setStatusUsuario(String stUsuario) {
		this.statusUsuario = stUsuario;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public Date getFechaUltimoAcceso() {
		return fechaUltimoAcceso;
	}
	public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
		this.fechaUltimoAcceso = fechaUltimoAcceso;
	}
    public boolean isFacturacion() {
        return facturacion;
    }
    public void setFacturacion(boolean facturacion) {
        this.facturacion = facturacion;
    }
    public boolean isInventario() {
        return inventario;
    }
    public void setInventario(boolean inventario) {
        this.inventario = inventario;
    }
    @Override
    public String toString() {
        return "{\"idCliente\":\"" + idCliente + "\", \"idContacto\":\"" + idContacto + "\", \"habilitado\":\""
                + habilitado + "\", \"usuario\":\"" + usuario + "\", \"statusUsuario\":\"" + statusUsuario
                + "\", \"fechaAlta\":\"" + fechaAlta + "\", \"fechaCaducidad\":\"" + fechaCaducidad
                + "\", \"fechaUltimoAcceso\":\"" + fechaUltimoAcceso + "\", \"facturacion\":\"" + facturacion
                + "\", \"inventario\":\"" + inventario + "\", \"contacto\":\"" + contacto + "\", \"getIdCliente()\":\""
                + getIdCliente() + "\", \"getIdContacto()\":\"" + getIdContacto() + "\", \"isHabilitado()\":\""
                + isHabilitado() + "\", \"getContacto()\":\"" + getContacto() + "\", \"getUsuario()\":\"" + getUsuario()
                + "\", \"getPassword()\":\"" + getPassword() + "\", \"getStatusUsuario()\":\"" + getStatusUsuario()
                + "\", \"getFechaAlta()\":\"" + getFechaAlta() + "\", \"getFechaCaducidad()\":\"" + getFechaCaducidad()
                + "\", \"getFechaUltimoAcceso()\":\"" + getFechaUltimoAcceso() + "\", \"isFacturacion()\":\""
                + isFacturacion() + "\", \"isInventario()\":\"" + isInventario() + "\", \"getClass()\":\"" + getClass()
                + "\", \"hashCode()\":\"" + hashCode() + "\", \"toString()\":\"" + super.toString() + "\"}";
    }

}
