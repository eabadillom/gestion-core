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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "producto_constancia_ds")
public class ProductoConstanciaDs implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CATIDAD_COBRO")
    private BigDecimal peso;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "UNIDAD_COBRO")
    private String unidadPeso;
    
    @Column(name = "CANTIDAD_MANEJO")
    private BigDecimal cantidad;
    
    @Size(max = 255)
    @Column(name = "UNIDAD_MANEJO")
    private String unidadManejo;
    
    @JoinColumn(name = "CONSTANCIA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ConstanciaFacturaDs constancia;

    public ProductoConstanciaDs() {
    }

    public ProductoConstanciaDs(Integer id) {
        this.id = id;
    }

    public ProductoConstanciaDs(Integer id, String descripcion, BigDecimal catidadCobro, String unidadCobro) {
        this.id = id;
        this.descripcion = descripcion;
        this.peso = catidadCobro;
        this.unidadPeso = unidadCobro;
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

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getUnidadPeso() {
        return unidadPeso;
    }

    public void setUnidadPeso(String unidadPeso) {
        this.unidadPeso = unidadPeso;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadManejo() {
        return unidadManejo;
    }

    public void setUnidadManejo(String unidadManejo) {
        this.unidadManejo = unidadManejo;
    }

    public ConstanciaFacturaDs getConstancia() {
        return constancia;
    }

    public void setConstancia(ConstanciaFacturaDs constancia) {
        this.constancia = constancia;
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
        if (!(object instanceof ProductoConstanciaDs)) {
            return false;
        }
        ProductoConstanciaDs other = (ProductoConstanciaDs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.ProductoConstanciaDs[ id=" + id + " ]";
    }
    
}
