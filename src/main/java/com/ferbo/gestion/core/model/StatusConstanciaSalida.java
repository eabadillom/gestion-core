package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "status_constancia_salida")
@NamedQuery(name = "StatusConstanciaSalida.findAll", query = "SELECT s FROM StatusConstanciaSalida s")
public class StatusConstanciaSalida implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    public static final Integer STATUS_NUEVA = 1;
    public static final Integer STATUS_CANCELADA = 2;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    
    @Size(max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Size(max = 75)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public StatusConstanciaSalida() {
    }

    public StatusConstanciaSalida(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        if(this.id == null)
        	return System.identityHashCode(this);
        return Objects.hashCode(this.id);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusConstanciaSalida)) {
            return false;
        }
        StatusConstanciaSalida other = (StatusConstanciaSalida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.StatusConstanciaSalida[ id=" + id + " ]";
    }

}
