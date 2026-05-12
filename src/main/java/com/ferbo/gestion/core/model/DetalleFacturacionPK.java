package com.ferbo.gestion.core.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class DetalleFacturacionPK implements Serializable 
{
    private static final long serialVersionUID = -2888234836056967308L;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DETALLE_CVE")
    private int idDetalleFact;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTE_CVE")
    private int idCliente;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "det_fac_secuencia")
    private int detFacSecuencia;

    public DetalleFacturacionPK() {
    }

    public DetalleFacturacionPK(int idDetalleFact, int idCliente, int detFacSecuencia) {
        this.idDetalleFact = idDetalleFact;
        this.idCliente = idCliente;
        this.detFacSecuencia = detFacSecuencia;
    }

    public int getIdDetalleFact() {
        return idDetalleFact;
    }

    public void setIdDetalleFact(int idDetalleFact) {
        this.idDetalleFact = idDetalleFact;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getDetFacSecuencia() {
        return detFacSecuencia;
    }

    public void setDetFacSecuencia(int detFacSecuencia) {
        this.detFacSecuencia = detFacSecuencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDetalleFact;
        hash += (int) idCliente;
        hash += (int) detFacSecuencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFacturacionPK)) {
            return false;
        }
        DetalleFacturacionPK other = (DetalleFacturacionPK) object;
        if (this.idDetalleFact != other.idDetalleFact) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (this.detFacSecuencia != other.detFacSecuencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.DetalleFacturacionPK[ id=" + idDetalleFact + ", cteCve=" + idCliente + ", detFacSecuencia=" + detFacSecuencia + " ]";
    }
    
}
