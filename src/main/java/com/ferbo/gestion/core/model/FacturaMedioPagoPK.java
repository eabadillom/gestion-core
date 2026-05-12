package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class FacturaMedioPagoPK implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fmp_id")
    private int id;

    public FacturaMedioPagoPK() {
    }

    public FacturaMedioPagoPK(Factura factura, int id) {
        this.factura = factura;
        this.id = id;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(factura, id);
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
        FacturaMedioPagoPK other = (FacturaMedioPagoPK) obj;
        return id == other.id && Objects.equals(factura, other.factura);
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.FacturaMedioPagoPK [id=" + id + "]";
    }

}
