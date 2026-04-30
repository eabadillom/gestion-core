package com.ferbo.gestion.core.model;

<<<<<<< Updated upstream
public class TipoTelefono {
	private Integer tipoTelefono = null;
	private String nombreTelefono = null;
	
	public Integer getTipoTelefono() {
		return tipoTelefono;
	}
	public void setTipoTelefono(Integer tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}
	public String getNombreTelefono() {
		return nombreTelefono;
	}
	public void setNombreTelefono(String nombreTelefono) {
		this.nombreTelefono = nombreTelefono;
	}
=======
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
@Table(name = "tipo_telefono")
@NamedQuery(name = "TipoTelefono.findAll", query = "SELECT t FROM TipoTelefono t")
public class TipoTelefono implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tp_telefono")
    private Short id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nb_telefono")
    private String descripcion;

    public TipoTelefono() {
    }

    public TipoTelefono(Short id) {
        this.id = id;
    }

    public TipoTelefono(Short id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
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
        if (!(object instanceof TipoTelefono)) {
            return false;
        }
        TipoTelefono other = (TipoTelefono) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.TipoTelefono[ id=" + id + " ]";
    }
    
>>>>>>> Stashed changes
}
