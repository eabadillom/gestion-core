package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "estado_inventario")
@NamedQueries({
    @NamedQuery(name = "EstadoInventario.findAll", query = "SELECT e FROM EstadoInventario e"),
    @NamedQuery(name = "EstadoInventario.findById", query = "SELECT e FROM EstadoInventario e WHERE e.id = :idEstadoInventario"),
    @NamedQuery(name = "EstadoInventario.findByDescripcion", query = "SELECT e FROM EstadoInventario e WHERE e.descripcion = :descripcion")
})
public class EstadoInventario implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "edo_inv_cve")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "edo_descripcion")
    private String descripcion;
    
    @OneToMany(mappedBy = "edoInventario")
    private List<DetallePartida> detallePartidaList;

    public EstadoInventario() {
    }

    public EstadoInventario(Integer id) {
        this.id = id;
    }

    public EstadoInventario(Integer id, String descripcion) {
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

    public List<DetallePartida> getDetallePartidaList() {
        return detallePartidaList;
    }

    public void setDetallePartidaList(List<DetallePartida> detallePartidaList) {
        this.detallePartidaList = detallePartidaList;
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
        if (!(object instanceof EstadoInventario)) {
            return false;
        }
        EstadoInventario other = (EstadoInventario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.EstadoInventario[ id=" + id + " ]";
    }
    
}
