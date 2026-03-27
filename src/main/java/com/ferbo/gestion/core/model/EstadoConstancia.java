package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "estado_constancia")
@NamedQueries({
    @NamedQuery(name = "EstadoConstancia.findAll", query = "SELECT e FROM EstadoConstancia e"),
    @NamedQuery(name = "EstadoConstancia.findById", query = "SELECT e FROM EstadoConstancia e WHERE e.id = :idEdoConstancia"),
    @NamedQuery(name = "EstadoConstancia.findByDescripcion", query = "SELECT e FROM EstadoConstancia e WHERE e.descripcion = :descripcion")
})
public class EstadoConstancia implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "edo_cve")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    
    public EstadoConstancia() {
    }

    public EstadoConstancia(Integer id) {
        this.id = id;
    }

    public EstadoConstancia(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
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
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoConstancia)) {
            return false;
        }
        EstadoConstancia other = (EstadoConstancia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.EstadoConstancia[ id=" + id + " ]";
    }
    
}
