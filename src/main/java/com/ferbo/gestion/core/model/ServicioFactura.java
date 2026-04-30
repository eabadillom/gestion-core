package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

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
@Table(name = "servicio_factura")
public class ServicioFactura implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    
    @Column(name = "tarifa")
    private BigDecimal precioUnitario;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private BigDecimal subtotal;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "unidad")
    private String unidad;
    
    @Size(max = 10)
    @Column(name = "ud_cobro")
    private String udCobro;
    
    @Size(max = 20)
    @ManyToOne(optional = false)
    @JoinColumn(name = "codigo", referencedColumnName = "cd_concepto")
    private Concepto codigo;
    
    @JoinColumn(name = "factura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Factura factura;
    
    @JoinColumn(name = "tipo_cobro", referencedColumnName = "id")
    @ManyToOne
    private TipoCobro tipoCobro;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "cd_unidad", referencedColumnName = "cd_unidad")
    private ClaveUnidad cdUnidad;

    public ServicioFactura() {
    }

    public ServicioFactura(Integer id) {
        this.id = id;
    }

    public ServicioFactura(Integer id, String descripcion, BigDecimal cantidad, String unidad, BigDecimal costo) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.subtotal = costo;
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

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }
    
    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    
    public BigDecimal getPrecioUnitario() {
    	return precioUnitario;
    }
    
    public void setPrecioUnitario(BigDecimal precioUnitario) {
    	this.precioUnitario = precioUnitario;
    }

    public BigDecimal getSubtotal() {
    	return subtotal;
    }
    
    public void setSubtotal(BigDecimal subtotal) {
    	this.subtotal = subtotal;
    }

    public TipoCobro getTipoCobro() {
    	return tipoCobro;
    }
    
    public void setTipoCobro(TipoCobro tipoCobro) {
    	this.tipoCobro = tipoCobro;
    }

    public String getUdCobro() {
        return udCobro;
    }

    public void setUdCobro(String udCobro) {
        this.udCobro = udCobro;
    }

    public Concepto getCodigo() {
        return codigo;
    }

    public void setCodigo(Concepto codigo) {
        this.codigo = codigo;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public ClaveUnidad getCdUnidad() {
        return cdUnidad;
    }

    public void setCdUnidad(ClaveUnidad cdUnidad) {
        this.cdUnidad = cdUnidad;
    }

    @Override
    public int hashCode() {
        if(this.id == null)
        	return System.identityHashCode(this);
        return Objects.hashCode(this.id);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioFactura)) {
            return false;
        }
        ServicioFactura other = (ServicioFactura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.ServicioFactura[ id=" + id + " ]";
    }
    
}
