package com.ferbo.gestion.core.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "factura_medio_pago")
@NamedQueries({
    @NamedQuery(name = "FacturaMedioPago.findAll", query = "SELECT f FROM FacturaMedioPago f"),
    @NamedQuery(name = "FacturaMedioPago.findByIdFactura", query = "SELECT f FROM FacturaMedioPago f WHERE f.facturaMedioPagoPK.factura.id = :idFactura"),
    @NamedQuery(name = "FacturaMedioPago.findByMedioPago", query = "SELECT f FROM FacturaMedioPago f WHERE f.medioPago.id = :idMedioPago"),
    @NamedQuery(name = "FacturaMedioPago.findByDescripcion", query = "SELECT f FROM FacturaMedioPago f WHERE f.descripcion = :descripcion"),
    @NamedQuery(name = "FacturaMedioPago.findByPorcentaje", query = "SELECT f FROM FacturaMedioPago f WHERE f.porcentaje = :porcentaje"),
    @NamedQuery(name = "FacturaMedioPago.findByReferencia", query = "SELECT f FROM FacturaMedioPago f WHERE f.referencia = :referencia")
})
public class FacturaMedioPago implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected FacturaMedioPagoPK facturaMedioPagoPK;
    
    @JoinColumn(name = "mp_id", referencedColumnName = "mp_id")
    @ManyToOne(optional = false)
    private MedioPago medioPago;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "mp_descripcion")
    private String descripcion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fmp_porcentaje")
    private int porcentaje;
    
    @Size(max = 50)
    @Column(name = "fmp_referencia")
    private String referencia;
    
    public FacturaMedioPago() {
    }

    public FacturaMedioPago(FacturaMedioPagoPK facturaMedioPagoPK) {
        this.facturaMedioPagoPK = facturaMedioPagoPK;
    }

    public FacturaMedioPago(FacturaMedioPagoPK facturaMedioPagoPK, String descripcion, int porcentaje) {
        this.facturaMedioPagoPK = facturaMedioPagoPK;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
    }

    public FacturaMedioPago(Factura facturaId, int fmpId) {
        this.facturaMedioPagoPK = new FacturaMedioPagoPK(facturaId, fmpId);
    }

    public FacturaMedioPagoPK getFacturaMedioPagoPK() {
        return facturaMedioPagoPK;
    }

    public void setFacturaMedioPagoPK(FacturaMedioPagoPK facturaMedioPagoPK) {
        this.facturaMedioPagoPK = facturaMedioPagoPK;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaMedioPagoPK != null ? facturaMedioPagoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaMedioPago)) {
            return false;
        }
        FacturaMedioPago other = (FacturaMedioPago) object;
        if ((this.facturaMedioPagoPK == null && other.facturaMedioPagoPK != null) || (this.facturaMedioPagoPK != null && !this.facturaMedioPagoPK.equals(other.facturaMedioPagoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.FacturaMedioPago[ facturaMedioPagoPK=" + facturaMedioPagoPK + " ]";
    }
    
}
