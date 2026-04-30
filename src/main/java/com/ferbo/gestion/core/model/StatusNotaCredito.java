package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "status_nota_credito")
@NamedQuery(name = "StatusNotaCredito.findAll", query = "SELECT s FROM StatusNotaCredito s")
public class StatusNotaCredito implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    public static final Integer ERROR     = 0;
    public static final Integer NUEVA     = 1;
    public static final Integer CANCELADA = 2;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    @Size(max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public StatusNotaCredito() {
    }

    public StatusNotaCredito(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof StatusNotaCredito)) {
            return false;
        }
        StatusNotaCredito other = (StatusNotaCredito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.StatusNotaCredito[ id=" + id + " ]";
    }

}
