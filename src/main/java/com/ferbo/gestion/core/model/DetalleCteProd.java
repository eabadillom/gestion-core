package com.ferbo.gestion.core.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "detalle_cte_prod")
@NamedQueries({
    @NamedQuery(name = "DetalleCteProd.findAll", query = "SELECT d FROM DetalleCteProd d"),
    @NamedQuery(name = "DetalleCteProd.findByDetCteProdCve", query = "SELECT d FROM DetalleCteProd d WHERE d.detCteProdCve = :detCteProdCve"),
    @NamedQuery(name = "DetalleCteProd.findByValor", query = "SELECT d FROM DetalleCteProd d WHERE d.valor = :valor"),
    @NamedQuery(name = "DetalleCteProd.findByDetPartCve", query = "SELECT d FROM DetalleCteProd d WHERE d.detPartCve = :detPartCve")
})
public class DetalleCteProd implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DET_CTE_PROD_CVE")
    private Integer detCteProdCve;
    
    @Size(max = 30)
    @Column(name = "VALOR")
    private String valor;
    
    @Column(name = "DET_PART_CVE")
    private Integer detPartCve;
    
    @JoinColumn(name = "DATO_ESP_CVE", referencedColumnName = "DATO_ESP_CVE")
    @ManyToOne
    private DatoEspecial datoEspecial;

    public DetalleCteProd() {
    }

    public DetalleCteProd(Integer detCteProdCve) {
        this.detCteProdCve = detCteProdCve;
    }

    public Integer getDetCteProdCve() {
        return detCteProdCve;
    }

    public void setDetCteProdCve(Integer detCteProdCve) {
        this.detCteProdCve = detCteProdCve;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getDetPartCve() {
        return detPartCve;
    }

    public void setDetPartCve(Integer detPartCve) {
        this.detPartCve = detPartCve;
    }

    public DatoEspecial getDatoEspecial() {
        return datoEspecial;
    }

    public void setDatoEspecial(DatoEspecial datoEspecial) {
        this.datoEspecial = datoEspecial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detCteProdCve != null ? detCteProdCve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCteProd)) {
            return false;
        }
        DetalleCteProd other = (DetalleCteProd) object;
        if ((this.detCteProdCve == null && other.detCteProdCve != null) || (this.detCteProdCve != null && !this.detCteProdCve.equals(other.detCteProdCve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.DetalleCteProd[ detCteProdCve=" + detCteProdCve + " ]";
    }
    
}
