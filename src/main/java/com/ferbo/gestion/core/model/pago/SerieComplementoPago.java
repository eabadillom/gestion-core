package com.ferbo.gestion.core.model.pago;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ferbo.gestion.core.model.facturacion.Emisor;



public class SerieComplementoPago implements Serializable {

	private static final long serialVersionUID = 2062936149478319074L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_serie_comp_pago")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "nb_serie")
    private String serie;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nu_numero")
    private String numero;
    
    @JoinColumn(name = "cd_emisor", referencedColumnName = "cd_emisor")
    @ManyToOne(optional = true)
    private Emisor emisor;
    
    @JoinColumn(name = "cd_status", referencedColumnName = "cd_status_serie")
    @ManyToOne(optional = true)
    private SerieComplementoStatus status;
    
    @Override
    public int hashCode() {
        if(this.id == null)
            return System.identityHashCode(this);
        return Objects.hash(this.id);
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
        final SerieComplementoPago other = (SerieComplementoPago) obj;
        if(this.id == null || other.id == null)
            return Objects.equals(System.identityHashCode(this), System.identityHashCode(other));
       
        return Objects.equals(this.id, other.id);
    }
    
    @Override
    public String toString() {
        return "SerieComplementoPago[" + "id=" + id + ", serie=" + serie + ", numero=" + numero + ']';
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Emisor getEmisor() {
		return emisor;
	}

	public void setEmisor(Emisor emisor) {
		this.emisor = emisor;
	}

	public SerieComplementoStatus getStatus() {
		return status;
	}

	public void setStatus(SerieComplementoStatus status) {
		this.status = status;
	}

}
