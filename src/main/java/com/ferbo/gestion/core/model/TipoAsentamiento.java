package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tipo_asentamiento")
@NamedQueries({
    @NamedQuery(name = "TipoAsentamiento.findAll", query = "SELECT t FROM TipoAsentamiento t"),
    @NamedQuery(name = "TipoAsentamiento.findByTipoasntmntoCve", query = "SELECT t FROM TipoAsentamiento t WHERE t.id = :idTipoAsentamiento"),
    @NamedQuery(name = "TipoAsentamiento.findByTipoasntmntoDs", query = "SELECT t FROM TipoAsentamiento t WHERE t.tipoasntmntoDs = :tipoasntmntoDs"),
    @NamedQuery(name = "TipoAsentamiento.findByTipoasntmntoDsCorta", query = "SELECT t FROM TipoAsentamiento t WHERE t.tipoasntmntoDsCorta = :tipoasntmntoDsCorta")
})
public class TipoAsentamiento implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipoasntmnto_cve")
    private Short id;
    
    @Size(max = 100)
    @Column(name = "tipoasntmnto_ds")
    private String tipoasntmntoDs;
    
    @Size(max = 4)
    @Column(name = "tipoasntmnto_ds_corta")
    private String tipoasntmntoDsCorta;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAsentamiento")
    private List<Asentamiento> asentamientoList;

    public TipoAsentamiento() {
    }

    public TipoAsentamiento(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getTipoasntmntoDs() {
        return tipoasntmntoDs;
    }

    public void setTipoasntmntoDs(String tipoasntmntoDs) {
        this.tipoasntmntoDs = tipoasntmntoDs;
    }

    public String getTipoasntmntoDsCorta() {
        return tipoasntmntoDsCorta;
    }

    public void setTipoasntmntoDsCorta(String tipoasntmntoDsCorta) {
        this.tipoasntmntoDsCorta = tipoasntmntoDsCorta;
    }

    public List<Asentamiento> getAsentamientoList() {
        return asentamientoList;
    }

    public void setAsentamientoList(List<Asentamiento> asentamientoList) {
        this.asentamientoList = asentamientoList;
    }

    @Override
    public int hashCode() {
        if(this.id == null) {
            return System.identityHashCode(this);
        }
        return Objects.hash(this.id);
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
        final TipoAsentamiento other = (TipoAsentamiento) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.TipoAsentamiento[ id=" + id + " ]";
    }
    
}
