package com.ferbo.gestion.core.model;

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
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s ORDER BY s.descripcion"),
    @NamedQuery(name = "Servicio.findById", query = "SELECT s FROM Servicio s WHERE s.id = :idServicio"),
    @NamedQuery(name = "Servicio.findByDescripcion", query = "SELECT s FROM Servicio s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "Servicio.findByCodigo", query = "SELECT s FROM Servicio s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "Servicio.findByUnidad", query = "SELECT s FROM Servicio s WHERE s.unidad = :unidad"),//cd unidad paso a ser clave foranea
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

    @Size(max = 5)
    @Column(name = "cd_unidad")
    private String unidad;

    @Size(max = 50)
    @Column(name = "SERVICIO_NOM")
    private String nombre;

    @Size(max = 50)
    @Column(name = "uuid")
    private String uuId;

    @JoinColumn(name = "COBRO", referencedColumnName = "id")
    @ManyToOne
    private TipoCobro cobro;

    @JoinColumn(name = "cd_unidad", referencedColumnName = "cd_unidad", insertable = false, updatable = false)
    @ManyToOne
    private ClaveUnidad claveUnit;

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

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public TipoCobro getCobro() {
        return cobro;
    }

    public void setCobro(TipoCobro cobro) {
        this.cobro = cobro;
    }

    public ClaveUnidad getClaveUnit() {
        return claveUnit;
    }

    public void setClaveUnit(ClaveUnidad claveUnit) {
        this.claveUnit = claveUnit;
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
    
}
