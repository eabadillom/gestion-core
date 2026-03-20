package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "partida_servicio")
@NamedQueries({
    @NamedQuery(name = "PartidaServicio.findAll", query = "SELECT p FROM PartidaServicio p"),
    @NamedQuery(name = "PartidaServicio.findByPartidaCve", query = "SELECT p FROM PartidaServicio p WHERE p.id = :idPartida"),
    @NamedQuery(name = "PartidaServicio.findByCantidadDeCobro", query = "SELECT p FROM PartidaServicio p WHERE p.cantidadDeCobro = :cantidadDeCobro"),
    @NamedQuery(name = "PartidaServicio.findByCantidadTotal", query = "SELECT p FROM PartidaServicio p WHERE p.cantidadTotal = :cantidadTotal"),
    @NamedQuery(name = "PartidaServicio.findByFolio", query = "SELECT p FROM PartidaServicio p WHERE p.folio = :folio")
})
public class PartidaServicio implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PARTIDA_CVE")
    private Integer id;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CANTIDAD_DE_COBRO")
    private BigDecimal cantidadDeCobro;
    
    @Column(name = "CANTIDAD_TOTAL")
    private Integer cantidadTotal;
    
    @JoinColumn(name = "FOLIO", referencedColumnName = "FOLIO")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConstanciaDeServicio folio;
    
    @JoinColumn(name = "PRODUCTO_CVE", referencedColumnName = "PRODUCTO_CVE")
    @ManyToOne
    private Producto producto;
    
    @JoinColumn(name = "UNIDAD_DE_MANEJO_CVE", referencedColumnName = "UNIDAD_DE_MANEJO_CVE")
    @ManyToOne
    private UnidadManejo unidadManejo;
    
    @JoinColumn(name = "UNIDAD_DE_COBRO", referencedColumnName = "UNIDAD_DE_MANEJO_CVE")
    @ManyToOne
    private UnidadManejo unidadCobro;

    public PartidaServicio() {
    }

    public PartidaServicio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCantidadDeCobro() {
        return cantidadDeCobro;
    }

    public void setCantidadDeCobro(BigDecimal cantidadDeCobro) {
        this.cantidadDeCobro = cantidadDeCobro;
    }

    public Integer getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Integer cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public ConstanciaDeServicio getFolio() {
        return folio;
    }

    public void setFolio(ConstanciaDeServicio folio) {
        this.folio = folio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public UnidadManejo getUnidadManejo() {
        return unidadManejo;
    }

    public void setUnidadDeManejoCve(UnidadManejo unidadManejo) {
        this.unidadManejo = unidadManejo;
    }

    public UnidadManejo getUnidadCobro() {
        return unidadCobro;
    }

    public void setUnidadDeCobro(UnidadManejo unidadCobro) {
        this.unidadCobro = unidadCobro;
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
        if (!(object instanceof PartidaServicio)) {
            return false;
        }
        PartidaServicio other = (PartidaServicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.PartidaServicio[ id=" + id + " ]";
    }
    
}
