package com.ferbo.gestion.core.model;

<<<<<<< Updated upstream
public class Telefono {
	private Integer idTelefono = null;
	private String telefono = null;
	boolean principal = false;
	private Integer tipoTelefono = null;
	
	public Integer getIdTelefono() {
		return idTelefono;
	}
	public void setIdTelefono(Integer idTelefono) {
		this.idTelefono = idTelefono;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public boolean isPrincipal() {
		return principal;
	}
	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}
	public Integer getTipoTelefono() {
		return tipoTelefono;
	}
	public void setTipoTelefono(Integer tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}
=======
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "telefono")
public class Telefono implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_telefono")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "nb_telefono")
    private String telefono;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "st_principal")
    private boolean principal;
    
    @JoinColumn(name = "tp_telefono", referencedColumnName = "tp_telefono")
    @ManyToOne(optional = false)
    private TipoTelefono tipoTelefono;
    
    @OneToMany(mappedBy = "telefono")
    private List<MedioContacto> mediosContacto;

    public Telefono() {
    }

    public Telefono(Integer id) {
        this.id = id;
    }

    public Telefono(Integer id, String telefono, boolean principal) {
        this.id = id;
        this.telefono = telefono;
        this.principal = principal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public TipoTelefono getTpTelefono() {
        return tipoTelefono;
    }

    public void setTpTelefono(TipoTelefono tpTelefono) {
        this.tipoTelefono = tpTelefono;
    }

    public List<MedioContacto> getMediosContacto() {
        return mediosContacto;
    }

    public void setMediosContacto(List<MedioContacto> mediosContacto) {
        this.mediosContacto = mediosContacto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Telefono))
            return false;
        Telefono that = (Telefono) o;

        if (this.id != null && that.id != null) {
            return Objects.equals(this.id, that.id);
        } else {
            return this == that;
        }
    }

    @Override
    public int hashCode() {
    	if(this.id == null)
    		return System.identityHashCode(this);
    	return Objects.hashCode(this.id);
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Telefono[ id=" + id + " ]";
    }

>>>>>>> Stashed changes
}
