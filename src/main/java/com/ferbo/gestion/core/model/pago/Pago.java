package com.ferbo.gestion.core.model.pago;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ferbo.gestion.core.model.facturacion.Factura;

@Entity
@Table(name = "pago")
public class Pago implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private BigDecimal monto;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    private LocalDate fecha;
    
    @Basic(optional = true)
    @Column(name = "tm_hora")
    private LocalTime hora;
    
    @Size(max = 20)
    @Column(name = "referencia")
    private String referencia;
    
    @Basic(optional = true)
    @JoinColumn(name = "banco", referencedColumnName = "id")
    @ManyToOne
    private Banco banco;
    
    @JoinColumn(name = "factura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Factura factura;
    
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoPago tipo;
    
    @JoinColumn(name = "cd_comp_pago", referencedColumnName = "cd_comp_pago")
    @ManyToOne(optional = true)
    private ComplementoPago complementoPago;
    
    @Basic(optional = true)
    @Column(name = "cd_forma_pago")
    private String formaPago;
    
    @Basic(optional = true)
    @Column(name = "nu_parcialidad")
    @Size(max = 5)
    private Integer parcialidad;
    
    @Override
    public int hashCode() {
    	if (this.id == null) {
            return System.identityHashCode(this);
        }
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object object) {
    	if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        final Pago other = (Pago) object;
        if(this.id == null || other.id == null)
            return Objects.equals(System.identityHashCode(this), System.identityHashCode(other));
       
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Pago[ id=" + id + " ]";
    }
    
    public Pago() {
    }

    public Pago(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public TipoPago getTipo() {
        return tipo;
    }

    public void setTipo(TipoPago tipo) {
        this.tipo = tipo;
    }

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public ComplementoPago getComplementoPago() {
		return complementoPago;
	}

	public void setComplementoPago(ComplementoPago complementoPago) {
		this.complementoPago = complementoPago;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Integer getParcialidad() {
		return parcialidad;
	}

	public void setParcialidad(Integer parcialidad) {
		this.parcialidad = parcialidad;
	}
}
