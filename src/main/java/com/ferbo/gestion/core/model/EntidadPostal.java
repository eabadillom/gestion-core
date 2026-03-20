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
@Table(name = "entidad_postal")
@NamedQueries({
    @NamedQuery(name = "EntidadPostal.findAll", query = "SELECT e FROM EntidadPostal e"),
    @NamedQuery(name = "EntidadPostal.findById", query = "SELECT e FROM EntidadPostal e WHERE e.id = :idEntidadPostal"),
    @NamedQuery(name = "EntidadPostal.findByDescripcion", query = "SELECT e FROM EntidadPostal e WHERE e.descripcion = :descripcion")
})
public class EntidadPostal implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "entidadpostal_cve")
    private Integer id;
    
    @Size(max = 100)
    @Column(name = "entidadpostal_ds")
    private String descripcion;
    
    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "entidadPostal")
    private List<Asentamiento> asentamientoList;

    public EntidadPostal() {
    }

    public EntidadPostal(Integer id) {
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

    public List<Asentamiento> getAsentamientoList() {
        return asentamientoList;
    }

    public void setAsentamientoList(List<Asentamiento> asentamientoList) {
        this.asentamientoList = asentamientoList;
    }

    @Override
    public int hashCode() {
        if(this.id == null){
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
        final EntidadPostal other = (EntidadPostal) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.EntidadPostal[ id=" + id + " ]";
    }
    
}
