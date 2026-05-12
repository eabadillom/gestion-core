package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "constancia_servicio_detalle")
@NamedQuery(name = "ConstanciaServicioDetalle.findAll", query = "SELECT c FROM ConstanciaServicioDetalle c")
@NamedQuery(name = "ConstanciaServicioDetalle.findByConstanciaServicioDetalleCve", query = "SELECT c FROM ConstanciaServicioDetalle c WHERE c.id = :idConstanciaSrvDet")
@NamedQuery(name = "ConstanciaServicioDetalle.findByFolio", query = "SELECT c FROM ConstanciaServicioDetalle c WHERE c.constancia.folio = :folio")
public class ConstanciaServicioDetalle implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONSTANCIA_SERVICIO_DETALLE_CVE")
    private Integer id;
    
    @Column(name = "SERVICIO_CANTIDAD")
    private BigDecimal cantidad;
    
    @JoinColumn(name = "FOLIO", referencedColumnName = "FOLIO")
    @ManyToOne
    private ConstanciaServicio constancia;
    
    @JoinColumn(name = "SERVICIO_CVE", referencedColumnName = "SERVICIO_CVE")
    @ManyToOne(optional = false)
    private Servicio servicio;
    
    public ConstanciaServicioDetalle() {
    }

    public ConstanciaServicioDetalle(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public ConstanciaServicio getConstanciaServicio() {
        return constancia;
    }

    public void setConstanciaServicio(ConstanciaServicio constanciaServicio) {
        this.constancia = constanciaServicio;
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
        if (!(object instanceof ConstanciaServicioDetalle)) {
            return false;
        }
        ConstanciaServicioDetalle other = (ConstanciaServicioDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.ConstanciaServicioDetalle[ id=" + id + " ]";
    }
    
}
