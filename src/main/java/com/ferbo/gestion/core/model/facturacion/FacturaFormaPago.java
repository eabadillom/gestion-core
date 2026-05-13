package com.ferbo.gestion.core.model.facturacion;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ferbo.gestion.core.model.catalogo.sat.FormaPago;

@Entity
@Table(name = "factura_medio_pago")
public class FacturaFormaPago implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected FacturaFormaPagoPK key;
    
    @JoinColumn(name = "mp_id", referencedColumnName = "mp_id")
    @ManyToOne(optional = false)
    private FormaPago medioPago;
    
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
    
    public FacturaFormaPago() {
    }

    public FacturaFormaPago(FacturaFormaPagoPK primaryKey) {
        this.key = primaryKey;
    }

    public FacturaFormaPago(FacturaFormaPagoPK primaryKey, String descripcion, int porcentaje) {
        this.key = primaryKey;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
    }

    public FacturaFormaPago(Factura idFactura, int fmpId) {
        this.key = new FacturaFormaPagoPK(idFactura, fmpId);
    }
	
    public FacturaFormaPagoPK getFacturaMedioPagoPK() {
        return key;
    }

    public void setFacturaMedioPagoPK(FacturaFormaPagoPK facturaMedioPagoPK) {
        this.key = facturaMedioPagoPK;
    }

    public FormaPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(FormaPago medioPago) {
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
    	if(this.key == null)
    		return System.identityHashCode(this);
    	return this.key.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaFormaPago)) {
            return false;
        }
        FacturaFormaPago other = (FacturaFormaPago) object;
        if ((this.key == null && other.key != null) || (this.key != null && !this.key.equals(other.key))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.FacturaFormaPago[ key=" + key + " ]";
    }
    
}
