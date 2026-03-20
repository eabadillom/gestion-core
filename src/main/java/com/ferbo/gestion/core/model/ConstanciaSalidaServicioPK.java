package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author alberto
 */
@Embeddable
public class ConstanciaSalidaServicioPK implements Serializable 
{
    private static final long serialVersionUID = -7593443111857351832L;

    @JoinColumn(name = "id_constancia", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ConstanciaSalida constanciaSalida;

    @JoinColumn(name = "id_servicio", referencedColumnName = "SERVICIO_CVE")
    @ManyToOne(optional = false)
    private Servicio servicio;

    @Override
    public int hashCode() {
        if (constanciaSalida == null || servicio == null) {
            return System.identityHashCode(this);
        }
        return Objects.hash(constanciaSalida, servicio);
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
        ConstanciaSalidaServicioPK other = (ConstanciaSalidaServicioPK) obj;
        return Objects.equals(constanciaSalida, other.constanciaSalida)
                && Objects.equals(servicio, other.servicio);
    }

    @Override
    public String toString() {
        return "ConstanciaSalidaServicioPK [constanciaSalida=" + constanciaSalida + ", servicio="
                + servicio + "]";
    }

    public ConstanciaSalidaServicioPK() {

    }

    public ConstanciaSalidaServicioPK(ConstanciaSalida constanciaSalida, Servicio servicio) {
        this.constanciaSalida = constanciaSalida;
        this.servicio = servicio;
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

    public void setServicioCve(Servicio servicio) {
        this.servicio = servicio;
    }
}
