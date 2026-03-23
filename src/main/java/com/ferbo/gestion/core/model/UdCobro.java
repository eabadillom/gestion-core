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
    @NamedQuery(name = "UdCobro.findByIdUnidad", query = "SELECT u FROM UdCobro u WHERE u.id = :idUdCobro"),
    @NamedQuery(name = "UdCobro.findByNbUnidad", query = "SELECT u FROM UdCobro u WHERE u.nbUnidad = :nbUnidad"),
    @NamedQuery(name = "UdCobro.findByCdUnidad", query = "SELECT u FROM UdCobro u WHERE u.cdUnidad = :cdUnidad")
})
public class UdCobro implements Serializable {

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
    private String nbUnidad;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cd_unidad")
    private String cdUnidad;

    public UdCobro() {
    }

    public UdCobro(String id) {
        this.id = id;
    }

    public UdCobro(String id, String nbUnidad, String cdUnidad) {
        this.id = id;
        this.nbUnidad = nbUnidad;
        this.cdUnidad = cdUnidad;
    }

    public String getIdUnidad() {
        return id;
    }

    public void setIdUnidad(String id) {
        this.id = id;
    }

    public String getNbUnidad() {
        return nbUnidad;
    }

    public void setNbUnidad(String nbUnidad) {
        this.nbUnidad = nbUnidad;
    }

    public String getCdUnidad() {
        return cdUnidad;
    }

    public void setCdUnidad(String cdUnidad) {
        this.cdUnidad = cdUnidad;
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
        return "mx.com.ferbo.model.UdCobro[ id=" + id + " ]";
    }
    
}
