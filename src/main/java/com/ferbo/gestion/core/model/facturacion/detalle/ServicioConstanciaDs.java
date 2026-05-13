package com.ferbo.gestion.core.model.facturacion.detalle;

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
@Table(name = "servicio_constancia_ds")
public class ServicioConstanciaDs implements Serializable 
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
    @Column(name = "cantidad")
    private BigDecimal cantidad;

    @Basic(optional = false)
    @NotNull
    @Column(name = "TARIFA")
    private BigDecimal precioUnitario;

    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTO")
    private BigDecimal subtotal;
    
    @Size(max = 20)
    @Column(name = "codigo")
    private String codigo;
    
    @Size(max = 10)
    @Column(name = "UD_COBRO")
    private String udCobro;
    
    @Size(max = 5)
    @Column(name = "cd_unidad")
    private String cdUnidad;

    @JoinColumn(name = "CONSTANCIA", referencedColumnName = "ID")
    @ManyToOne//modifica 1 junio
    private ConstanciaFacturaDs constancia;

    public ServicioConstanciaDs() {
    }

    public ServicioConstanciaDs(Integer id) {
        this.id = id;
    }

    public ServicioConstanciaDs(Integer id, String descripcion, BigDecimal costo, BigDecimal precioUnitario) {
        this.id = id;
        this.descripcion = descripcion;
        this.subtotal = costo;
        this.precioUnitario = precioUnitario;
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

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUdCobro() {
        return udCobro;
    }

    public void setUdCobro(String udCobro) {
        this.udCobro = udCobro;
    }

    public ConstanciaFacturaDs getConstancia() {
        return constancia;
    }

    public void setConstancia(ConstanciaFacturaDs constancia) {
        this.constancia = constancia;
    }

    public String getCdUnidad() {
        return cdUnidad;
    }

    public void setCdUnidad(String cdUnidad) {
        this.cdUnidad = cdUnidad;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
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
        if (!(object instanceof ServicioConstanciaDs)) {
            return false;
        }
        ServicioConstanciaDs other = (ServicioConstanciaDs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.ServicioConstanciaDs[ id=" + id + " ]";
    }

}
