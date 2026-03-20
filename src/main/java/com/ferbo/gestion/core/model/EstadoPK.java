package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class EstadoPK implements Serializable 
{
    private static final long serialVersionUID = -4501534761783764337L;
    
    @ManyToOne
    @NotNull
    @JoinColumn(name = "pais_cve")
    private Paises pais;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_cve")
    private Integer id;

    public EstadoPK() {
    }

    public EstadoPK(Paises pais, Integer id) {
        this.pais = pais;
        this.id = id;
    }

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EstadoPK other = (EstadoPK) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.EstadoPK[ idPais=" + pais.getId() + ", idEstado=" + id + " ]";
    }
    
}
