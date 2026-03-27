package com.ferbo.gestion.core.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "detalle_constancia_servicios")
@NamedQueries({
    @NamedQuery(name = "DetalleConstanciaServicio.findAll", query = "SELECT d FROM DetalleConstanciaServicio d"),
    @NamedQuery(name = "DetalleConstanciaServicio.findById", query = "SELECT d FROM DetalleConstanciaServicio d WHERE d.id = :id"),
    @NamedQuery(name = "DetalleConstanciaServicio.findByDescripcion", query = "SELECT d FROM DetalleConstanciaServicio d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "DetalleConstanciaServicio.findByCantidad", query = "SELECT d FROM DetalleConstanciaServicio d WHERE d.cantidad = :cantidad")
})
public class DetalleConstanciaServicio implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Size(max = 200)
    @Column(name = "SERVICIO_DES")
    private String descripcion;
    
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    
    @JoinColumn(name = "CONSTANCIA_CVE", referencedColumnName = "ID")
    @ManyToOne
    private ConstanciaServicios constancia;
    
    @JoinColumn(name = "SERVICIO_CVE", referencedColumnName = "SERVICIO_CVE")
    @ManyToOne
    private Servicio servicio;

    public DetalleConstanciaServicio() {
    }

    public DetalleConstanciaServicio(Integer id) {
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ConstanciaServicios getConstancia() {
        return constancia;
    }

    public void setConstancia(ConstanciaServicios constancia) {
        this.constancia = constancia;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
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
        if (!(object instanceof DetalleConstanciaServicio)) {
            return false;
        }
        DetalleConstanciaServicio other = (DetalleConstanciaServicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.DetalleConstanciaServicio[ id=" + id + " ]";
    }
    
}
