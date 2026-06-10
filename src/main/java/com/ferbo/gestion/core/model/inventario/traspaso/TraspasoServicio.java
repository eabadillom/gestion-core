package com.ferbo.gestion.core.model.inventario.traspaso;

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
@Table(name = "traspaso_servicio")
public class TraspasoServicio implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "servicio")
    private String servicio;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigDecimal precio;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtotal")
    private BigDecimal subtotal;
    
    @JoinColumn(name = "traspaso", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ConstanciaTraspaso traspaso;

    public TraspasoServicio() {
    }

    public TraspasoServicio(Integer id) {
        this.id = id;
    }

    public TraspasoServicio(Integer id, String servicio, BigDecimal cantidad, BigDecimal precio, BigDecimal subtotal) {
        this.id = id;
        this.servicio = servicio;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public ConstanciaTraspaso getTraspaso() {
        return traspaso;
    }

    public void setTraspaso(ConstanciaTraspaso traspaso) {
        this.traspaso = traspaso;
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
        if (!(object instanceof TraspasoServicio)) {
            return false;
        }
        TraspasoServicio other = (TraspasoServicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.TraspasoServicio[ id=" + id + " ]";
    }

}
