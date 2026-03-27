package com.ferbo.gestion.core.model;

import java.io.Serializable;
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
@Table(name = "tipo_mail")
@NamedQueries({
    @NamedQuery(name = "TipoMail.findAll", query = "SELECT t FROM TipoMail t"),
    @NamedQuery(name = "TipoMail.findById", query = "SELECT t FROM TipoMail t WHERE t.id = :idMail"),
    @NamedQuery(name = "TipoMail.findByDescripcion", query = "SELECT t FROM TipoMail t WHERE t.descripcion = :descripcion")
})
public class TipoMail implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tp_mail")
    private Short id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nb_tipo")
    private String descripcion;

    public TipoMail() {
    }

    public TipoMail(Short id) {
        this.id = id;
    }

    public TipoMail(Short id, String descripcion) {
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMail)) {
            return false;
        }
        TipoMail other = (TipoMail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.TipoMail[ id=" + id + " ]";
    }
    
}
