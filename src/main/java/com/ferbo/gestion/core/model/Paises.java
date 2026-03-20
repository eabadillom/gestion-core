package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
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
@Table(name = "paises")
@NamedQueries({
    @NamedQuery(name = "Paises.findAll", query = "SELECT p FROM Paises p"),
    @NamedQuery(name = "Paises.findById", query = "SELECT p FROM Paises p WHERE p.id = :idPais"),
    @NamedQuery(name = "Paises.findByDescripcion", query = "SELECT p FROM Paises p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Paises.findByClave", query = "SELECT p FROM Paises p WHERE p.clave = :clave")
})
public class Paises implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pais_cve")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "pais_desc")
    private String descripcion;
    
    @Size(max = 4)
    @Column(name = "pais_ds_corta")
    private String clave;
    
    @OneToMany(mappedBy = "estadoPK.pais")
    private List<Estado> estadosList;

    public Paises() {
    }

    public Paises(Integer id) {
        this.id = id;
    }

    public Paises(Integer id, String descripcion) {
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<Estado> getEstadoList() {
        return estadosList;
    }

    public void setEstadoList(List<Estado> estadosList) {
        this.estadosList = estadosList;
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
        final Paises other = (Paises) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.Paises[ idPais=" + id + ", descripcion=" + descripcion + " ]";
    }
    
}
