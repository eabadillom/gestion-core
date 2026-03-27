package com.ferbo.gestion.core.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class CuotaMinimaPK implements Serializable 
{
    @Basic(optional = false)
    @NotNull
    @Column(name = "cte_cve")
    private int idCliente;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuota_id")
    private int idCuota;

    public CuotaMinimaPK() {
    }

    public CuotaMinimaPK(int idCliente, int idCuota) {
        this.idCliente = idCliente;
        this.idCuota = idCuota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCliente;
        hash += (int) idCuota;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuotaMinimaPK)) {
            return false;
        }
        CuotaMinimaPK other = (CuotaMinimaPK) object;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (this.idCuota != other.idCuota) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.CuotaMinimaPK[ cteCve=" + idCliente + ", cuotaId=" + idCuota + " ]";
    }
    
}
