package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cuota_mensual_servicio_det")
@NamedQueries({
    @NamedQuery(name = "CuotaMensualServicioDet.findAll", query = "SELECT c FROM CuotaMensualServicioDet c"),
    @NamedQuery(name = "CuotaMensualServicioDet.findById", query = "SELECT c FROM CuotaMensualServicioDet c WHERE c.id = :id"),
    @NamedQuery(name = "CuotaMensualServicioDet.findByAviso", query = "SELECT c FROM CuotaMensualServicioDet c WHERE c.idAviso = :idAviso"),
    @NamedQuery(name = "CuotaMensualServicioDet.findByCliente", query = "SELECT c FROM CuotaMensualServicioDet c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "CuotaMensualServicioDet.findByServicio", query = "SELECT c FROM CuotaMensualServicioDet c WHERE c.idServicio = :idServicio"),
    @NamedQuery(name = "CuotaMensualServicioDet.findByCuotaDet", query = "SELECT c FROM CuotaMensualServicioDet c WHERE c.id = :idCuotaMenSrv"),
    @NamedQuery(name = "CuotaMensualServicioDet.findByCuota", query = "SELECT c FROM CuotaMensualServicioDet c WHERE c.cuota = :cuota")
})
public class CuotaMensualServicioDet implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "aviso_cve")
    private int idAviso;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "cte_cve")
    private int idCliente;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "servicio_cve")
    private int idServicio;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuota_det_cve")
    private int cuotaDetalle;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuota")
    private BigDecimal cuota;
    
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private CuotaMensualServicio cuotaMensualServicio;

    public CuotaMensualServicioDet() {
    }

    public CuotaMensualServicioDet(Integer id) {
        this.id = id;
    }

    public CuotaMensualServicioDet(Integer id, int idAviso, int idCliente, int idServicio, int cuotaDetalle, BigDecimal cuota) {
        this.id = id;
        this.idAviso = idAviso;
        this.idCliente = idCliente;
        this.idServicio = idServicio;
        this.cuotaDetalle = cuotaDetalle;
        this.cuota = cuota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(int idAviso) {
        this.idAviso = idAviso;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getCuotaDetalle() {
        return cuotaDetalle;
    }

    public void setCuotaDetalle(int cuotaDetalle) {
        this.cuotaDetalle = cuotaDetalle;
    }

    public BigDecimal getCuota() {
        return cuota;
    }

    public void setCuota(BigDecimal cuota) {
        this.cuota = cuota;
    }

    public CuotaMensualServicio getCuotaMensualServicio() {
        return cuotaMensualServicio;
    }

    public void setCuotaMensualServicio(CuotaMensualServicio cuotaMensualServicio) {
        this.cuotaMensualServicio = cuotaMensualServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuotaMensualServicioDet)) {
            return false;
        }
        CuotaMensualServicioDet other = (CuotaMensualServicioDet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.CuotaMensualServicioDet[ id=" + id + " ]";
    }
    
}
