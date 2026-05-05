package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "constancia_salida_srv")
@NamedQuery(name = "ConstanciaSalidaServicio.findByIdConstancia", query = "SELECT c FROM ConstanciaSalidaServicio c WHERE c.key.constanciaSalida = :constanciaSalida")
@NamedQuery(name = "ConstanciaSalidaServicio.findByIdServicio", query = "SELECT c FROM ConstanciaSalidaServicio c WHERE c.constanciaSalidaServicioPK.servicio = :servicio")
public class ConstanciaSalidaServicio implements Serializable 
{    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected ConstanciaSalidaServicioPK key;

    @JoinColumn(name = "id_constancia", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ConstanciaSalida constancia;

    @JoinColumn(name = "id_servicio", referencedColumnName = "SERVICIO_CVE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servicio servicio;//crear en model SERVICIO una variable constanciaSalida?

    @Column(name = "nu_cantidad")
    private BigDecimal cantidad;

    public ConstanciaSalidaServicio() {
    }

    public ConstanciaSalidaServicio(ConstanciaSalidaServicioPK primaryKey) {
        this.key = primaryKey;
    }

    public ConstanciaSalidaServicio(ConstanciaSalida constanciaSalida, Servicio servicio) {
        this.key = new ConstanciaSalidaServicioPK(constanciaSalida, servicio);
    }

    public ConstanciaSalidaServicioPK getKey() {
        return key;
    }

    public void setKey(ConstanciaSalidaServicioPK primaryKey) {
        this.key = primaryKey;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public ConstanciaSalida getConstancia() {
        return constancia;
    }

    public void setConstancia(ConstanciaSalida constancia) {
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
        return key.hashCode();
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
        ConstanciaSalidaServicio other = (ConstanciaSalidaServicio) obj;
        return Objects.equals(key, other.key);
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.ConstanciaSalidaServicios [constanciaSalidaServicioPK=" + key
                + ", numCantidad=" + cantidad + "]";
    }
    
}
