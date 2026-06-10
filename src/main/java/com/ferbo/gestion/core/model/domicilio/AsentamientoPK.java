package com.ferbo.gestion.core.model.domicilio;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class AsentamientoPK implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @ManyToOne()
    @NotNull
    @JoinColumns({
        @JoinColumn(name = "pais_cve", referencedColumnName = "pais_cve"),
        @JoinColumn(name = "estado_cve", referencedColumnName = "estado_cve"),
        @JoinColumn(name = "municipio_cve", referencedColumnName = "municipio_cve"),
        @JoinColumn(name = "ciudad_cve", referencedColumnName = "ciudad_cve")
    })
    private Ciudad ciudad;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "asentamiento_cve")
    private Integer id;
    
    public AsentamientoPK() {
    }

    public AsentamientoPK(Ciudad ciudad, Integer id) {
        this.ciudad = ciudad;
        this.id = id;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsentamientoPK)) {
            return false;
        }
        AsentamientoPK other = (AsentamientoPK) object;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.AsentamientoPK[ id=" + id + " ]";
    }
    
}
