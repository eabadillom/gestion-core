package com.ferbo.gestion.core.model.facturacion.detalle;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ferbo.gestion.core.model.facturacion.Factura;
import com.ferbo.gestion.core.model.inventario.servicio.ConstanciaServicio;

@Embeddable
public class ControlFacturaConstanciaDsPK implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @JoinColumn(name = "CONSTANCIA")
    @ManyToOne(optional = false)
    private ConstanciaServicio constanciaServicio;

    @JoinColumn(name = "FACTURA")
    @ManyToOne(optional = false)
    private Factura factura;

    public ControlFacturaConstanciaDsPK() {
    }

    public ControlFacturaConstanciaDsPK(ConstanciaServicio constanciaServicio, Factura factura) {
        super();
        this.constanciaServicio = constanciaServicio;
        this.factura = factura;
    }

    public ConstanciaServicio getConstanciaServicio() {
        return constanciaServicio;
    }

    public void setConstanciaServicio(ConstanciaServicio constanciaServicio) {
        this.constanciaServicio = constanciaServicio;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((constanciaServicio.getFolio() == null) ? 0 : constanciaServicio.getFolio().hashCode());
        result = prime * result + ((factura.getId() == null) ? 0 : factura.getId().hashCode());
        return result;
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
        ControlFacturaConstanciaDsPK other = (ControlFacturaConstanciaDsPK) obj;
        if (constanciaServicio.getFolio() == null) {
            if (other.constanciaServicio.getFolio() != null) {
                return false;
            }
        } else if (!constanciaServicio.getFolio().equals(other.constanciaServicio.getFolio())) {
            return false;
        }
        if (factura.getId() == null) {
            if (other.factura.getId() != null) {
                return false;
            }
        } else if (!factura.getId().equals(other.factura.getId())) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.ControlFacturaConstanciaDsPK [constanciaServicio=" + constanciaServicio + ", factura=" + factura
                + "]";
    }
    
}
