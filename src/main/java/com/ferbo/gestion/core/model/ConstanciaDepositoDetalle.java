package com.ferbo.gestion.core.model;

import java.math.BigDecimal;
<<<<<<< Updated upstream

public class ConstanciaDepositoDetalle {
	
	private Integer idConstanciaDepositoDetalle = null;
	private Integer idServicio = null;
	private Servicio servicio = null;
	private Integer folio = null;
	private BigDecimal cantidad = null;
	
	public Integer getIdConstanciaDepositoDetalle() {
		return idConstanciaDepositoDetalle;
	}
	public void setIdConstanciaDepositoDetalle(Integer idConstanciaDepositoDetalle) {
		this.idConstanciaDepositoDetalle = idConstanciaDepositoDetalle;
	}
	public Integer getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	public Integer getFolio() {
		return folio;
	}
	public void setFolio(Integer folio) {
		this.folio = folio;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "{\"idConstanciaDepositoDetalle\":\"" + idConstanciaDepositoDetalle + "\", \"idServicio\":\""
				+ idServicio + "\", \"servicio\":\"" + servicio + "\", \"folio\":\"" + folio + "\", \"cantidad\":\""
				+ cantidad + "\"}";
	}
=======
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "constancia_deposito_detalle")
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
    private BigDecimal cantidad;

    @JoinColumn(name = "FOLIO", referencedColumnName = "FOLIO", nullable = false)
    @ManyToOne(optional = false)
    private ConstanciaDeposito constancia;

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

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public ConstanciaDeposito getConstancia() {
        return constancia;
    }

    public void setConstancia(ConstanciaDeposito constancia) {
        this.constancia = constancia;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
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
    
>>>>>>> Stashed changes
}
