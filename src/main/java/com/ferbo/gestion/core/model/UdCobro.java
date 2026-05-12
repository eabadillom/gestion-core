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
@Table(name = "ud_cobro")
@NamedQueries({
    @NamedQuery(name = "UdCobro.findAll", query = "SELECT u FROM UdCobro u"),
    @NamedQuery(name = "UdCobro.findById", query = "SELECT u FROM UdCobro u WHERE u.id = :idUdCobro"),
    @NamedQuery(name = "UdCobro.findByDescripcion", query = "SELECT u FROM UdCobro u WHERE u.descripcion = :nbUnidad"),
    @NamedQuery(name = "UdCobro.findByClave", query = "SELECT u FROM UdCobro u WHERE u.clave = :cdUnidad")
})
public class UdCobro implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_unidad")
    private String id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nb_unidad")
    private String descripcion;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cd_unidad")
    private String clave;

    public UdCobro() {
    }

    public UdCobro(String id) {
        this.id = id;
    }

    public UdCobro(String id, String descripcion, String clave) {
        this.id = id;
        this.descripcion = descripcion;
        this.clave = clave;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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
        if (!(object instanceof UdCobro)) {
            return false;
        }
        UdCobro other = (UdCobro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.UdCobro[ id=" + id + " ]";
    }
    
}
