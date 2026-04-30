package com.ferbo.gestion.core.model;

<<<<<<< Updated upstream
public class Servicio {
	
	private Integer idServicio = null;
	private String descripcion = null;
	private Integer idTipoCobro = null;
	private TipoCobro tipoCobro = null;
	private String codigo = null;
	private String cdUnidad = null;
	private String nombre = null;
	private String uuid = null;
	private Boolean statusDefault = null;
	
	public Integer getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getIdTipoCobro() {
		return idTipoCobro;
	}
	public void setIdTipoCobro(Integer idTipoCobro) {
		this.idTipoCobro = idTipoCobro;
	}
	public TipoCobro getTipoCobro() {
		return tipoCobro;
	}
	public void setTipoCobro(TipoCobro tipoCobro) {
		this.tipoCobro = tipoCobro;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCdUnidad() {
		return cdUnidad;
	}
	public void setCdUnidad(String cdUnidad) {
		this.cdUnidad = cdUnidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Boolean getStatusDefault() {
		return statusDefault;
	}
	public void setStatusDefault(Boolean statusDefault) {
		this.statusDefault = statusDefault;
	}
	@Override
	public String toString() {
		return "{\"idServicio\":\"" + idServicio + "\", \"descripcion\":\"" + descripcion + "\", \"idTipoCobro\":\""
				+ idTipoCobro + "\", \"tipoCobro\":\"" + tipoCobro + "\", \"codigo\":\"" + codigo
				+ "\", \"cdUnidad\":\"" + cdUnidad + "\", \"nombre\":\"" + nombre + "\", \"uuid\":\"" + uuid
				+ "\", \"statusDefault\":\"" + statusDefault + "\"}";
	}
=======
import java.io.Serializable;
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
import javax.validation.constraints.Size;

@Entity
@Table(name = "servicio")
@NamedQueries({
    @NamedQuery(name = "Servicio.findByDescripcion", query = "SELECT s FROM Servicio s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "Servicio.findByCodigo", query = "SELECT s FROM Servicio s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "Servicio.findByUnidad", query = "SELECT s FROM Servicio s WHERE s.unidad = :unidad"),
    @NamedQuery(name = "Servicio.findByUuId", query = "SELECT s FROM Servicio s WHERE s.uuId = :uuId")
})
public class Servicio implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SERVICIO_CVE")
    private Integer id;

    @Size(max = 80)
    @Column(name = "SERVICIO_DS")
    private String descripcion;

    @Size(max = 20)
    @Column(name = "SERVICIO_COD")
    private String codigo;

    @Size(max = 50)
    @Column(name = "SERVICIO_NOM")
    private String nombre;

    @Size(max = 50)
    @Column(name = "uuid")
    private String uuid;

    @JoinColumn(name = "COBRO", referencedColumnName = "id")
    @ManyToOne
    private TipoCobro tipoCobro;

    @JoinColumn(name = "cd_unidad", referencedColumnName = "cd_unidad", insertable = false, updatable = false)
    @ManyToOne
    private ClaveUnidad unidad;

    public Servicio() {
    }

    public Servicio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuId) {
        this.uuid = uuId;
    }

    public TipoCobro getTipoCobro() {
        return tipoCobro;
    }

    public void setTipoCobro(TipoCobro tipoCobro) {
        this.tipoCobro = tipoCobro;
    }

    public ClaveUnidad getUnidad() {
        return unidad;
    }

    public void setUnidad(ClaveUnidad claveUnidad) {
        this.unidad = claveUnidad;
    }

    @Override
    public int hashCode() {
        if (this.id == null) {
            return System.identityHashCode(this);
        }
        return Objects.hashCode(this.id);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Servicio)) {
            return false;
        }

        Servicio other = (Servicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Servicio[ id=" + id + " ]";
    }
    
>>>>>>> Stashed changes
}
