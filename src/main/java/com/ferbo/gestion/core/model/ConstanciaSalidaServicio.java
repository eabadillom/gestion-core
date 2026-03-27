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
@NamedQueries({
    @NamedQuery(name = "ConstanciaSalidaServicio.findAll", query = "SELECT c FROM ConstanciaSalidaServicio c"),
    @NamedQuery(name = "ConstanciaSalidaServicio.findByIdConstancia", query = "SELECT c FROM ConstanciaSalidaServicio c WHERE c.constanciaSalidaServicioPK.constanciaSalida = :constanciaSalida"),
    @NamedQuery(name = "ConstanciaSalidaServicio.findByIdServicio", query = "SELECT c FROM ConstanciaSalidaServicio c WHERE c.constanciaSalidaServicioPK.servicio = :servicio"),
    @NamedQuery(name = "ConstanciaSalidaServicio.findByCantidad", query = "SELECT c FROM ConstanciaSalidaServicio c WHERE c.numCantidad = :numCantidad"
)})
public class ConstanciaSalidaServicio implements Serializable 
{    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected ConstanciaSalidaServicioPK constanciaSalidaServicioPK;

    @JoinColumn(name = "id_constancia", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ConstanciaSalida constanciaSalida;

    @JoinColumn(name = "id_servicio", referencedColumnName = "SERVICIO_CVE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servicio servicio;//crear en model SERVICIO una variable constanciaSalida?

    @Column(name = "nu_cantidad")
    private BigDecimal numCantidad;

    public ConstanciaSalidaServicio() {
    }

    public ConstanciaSalidaServicio(ConstanciaSalidaServicioPK constanciaSalidaServicioPK) {
        this.constanciaSalidaServicioPK = constanciaSalidaServicioPK;
    }

    public ConstanciaSalidaServicio(ConstanciaSalida constanciaSalida, Servicio servicio) {
        this.constanciaSalidaServicioPK = new ConstanciaSalidaServicioPK(constanciaSalida, servicio);
    }

    public ConstanciaSalidaServicioPK getConstanciaSalidaServicioPK() {
        return constanciaSalidaServicioPK;
    }

    public void setConstanciaSalidaServicioPK(ConstanciaSalidaServicioPK constanciaSalidaServicioPK) {
        this.constanciaSalidaServicioPK = constanciaSalidaServicioPK;
    }

    public BigDecimal getNumCantidad() {
        return numCantidad;
    }

    public void setNumCantidad(BigDecimal numCantidad) {
        this.numCantidad = numCantidad;
    }

    public ConstanciaSalida getConstanciaSalida() {
        return constanciaSalida;
    }

    public void setConstanciaSalida(ConstanciaSalida constanciaSalida) {
        this.constanciaSalida = constanciaSalida;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    @Override
    public int hashCode() {
        return constanciaSalidaServicioPK.hashCode();
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
        return Objects.equals(constanciaSalidaServicioPK, other.constanciaSalidaServicioPK);
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.ConstanciaSalidaServicios [constanciaSalidaServicioPK=" + constanciaSalidaServicioPK
                + ", numCantidad=" + numCantidad + "]";
    }
    
}
