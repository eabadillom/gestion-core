package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tipos_domicilio")
@NamedQueries({
    @NamedQuery(name = "TipoDomicilio.findAll", query = "SELECT t FROM TipoDomicilio t"),
    @NamedQuery(name = "TipoDomicilio.findById", query = "SELECT t FROM TipoDomicilio t WHERE t.id = :idDomicilioTipo"),
    @NamedQuery(name = "TipoDomicilio.findByDescripcion", query = "SELECT t FROM TipoDomicilio t WHERE t.descripcion = :descripcion")
})
public class TipoDomicilio implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "domicilio_tipo_cve")
    private Short id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "domicilio_tipo_desc")
    private String descripcion;
    
    public TipoDomicilio() {
    }

    public TipoDomicilio(Short id) {
        this.id = id;
    }

    public TipoDomicilio(Short id, String descripcion) {
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
        if (this.id == null) {
            return System.identityHashCode(this);
        }
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        TipoDomicilio other = (TipoDomicilio) object;
        if(this.id == null || other.id == null)
            return Objects.equals(System.identityHashCode(this), System.identityHashCode(other));
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.TiposDomicilio[ id=" + id + " ]";
    }
    
}
