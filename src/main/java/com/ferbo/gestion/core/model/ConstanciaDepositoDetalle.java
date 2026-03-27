package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "constancia_deposito_detalle")
@NamedQueries({
    @NamedQuery(name = "ConstanciaDepositoDetalle.findAll", query = "SELECT c FROM ConstanciaDepositoDetalle c"),
    @NamedQuery(name = "ConstanciaDepositoDetalle.findByConstanciaDepositoDetalleCve", query = "SELECT c FROM ConstanciaDepositoDetalle c WHERE c.id = :idConstanciaDepositoDet"),
    @NamedQuery(name = "ConstanciaDepositoDetalle.findFolio", query = "SELECT c FROM ConstanciaDepositoDetalle c WHERE c.constanciaDeposito.folio = :folio"),
    @NamedQuery(name = "ConstanciaDepositoDetalle.findByServicioCantidad", query = "SELECT c FROM ConstanciaDepositoDetalle c WHERE c.servicioCantidad = :servicioCantidad")
})
public class ConstanciaDepositoDetalle implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONSTANCIA_DEPOSITO_DETALLE_CVE")
    private Integer id;

    @Column(name = "servicio_cantidad")
    @Basic(optional = false)
    private BigDecimal servicioCantidad;

    @JoinColumn(name = "FOLIO", referencedColumnName = "FOLIO", nullable = false)
    @ManyToOne(optional = false)
    private ConstanciaDeposito constanciaDeposito;

    @JoinColumn(name = "SERVICIO_CVE", referencedColumnName = "SERVICIO_CVE", nullable = false)
    @ManyToOne
    private Servicio servicio;

    public ConstanciaDepositoDetalle() {
    }

    public ConstanciaDepositoDetalle(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getServicioCantidad() {
        return servicioCantidad;
    }

    public void setServicioCantidad(BigDecimal servicioCantidad) {
        this.servicioCantidad = servicioCantidad;
    }

    public ConstanciaDeposito getConstanciaDeposito() {
        return constanciaDeposito;
    }

    public void setConstanciaDeposito(ConstanciaDeposito constanciaDeposito) {
        this.constanciaDeposito = constanciaDeposito;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicioCve(Servicio servicio) {
        this.servicio = servicio;
    }
    
    @Override
    public int hashCode() {
        if (this.id == null) {
            return System.identityHashCode(this);
        }
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ConstanciaDepositoDetalle)) {
            return false;
        }
        ConstanciaDepositoDetalle other = (ConstanciaDepositoDetalle) object;
        if (this.hashCode() != other.hashCode()) {
            return false;
        }

        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }

        if (this.servicio != other.servicio) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.ConstanciaDepositoDetalle[ constanciaDepositoDetalleCve=" + id + " ]";
    }
    
}
