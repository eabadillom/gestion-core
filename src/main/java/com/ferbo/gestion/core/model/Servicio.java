package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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

    @OneToMany(mappedBy = "servicio")
    private List<DetalleConstanciaServicio> detalleConstanciaServicioList;

    @OneToMany(mappedBy = "servicio")
    private List<ConstanciaSalidaServicio> constanciaSalidaServicioList;

    @JoinColumn(name = "COBRO", referencedColumnName = "id")
    @ManyToOne
    private TipoCobro cobro;

    @JoinColumn(name = "cd_unidad", referencedColumnName = "cd_unidad", insertable = false, updatable = false)
    @ManyToOne
    private ClaveUnidad claveUnit;

    @OneToMany(mappedBy = "servicio")
    private List<CuotaMensualServicio> cuotaMensualServicioList;

    @OneToMany(mappedBy = "servicio")
    private List<PrecioServicio> precioServicioList;

    @OneToMany(mappedBy = "servicio")
    private List<ConstanciaDepositoDetalle> constanciaDepositoDetalleList;

    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "servicio")
    private List<ConstanciaServicioDetalle> constanciaServicioDetalleList;

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

    public List<DetalleConstanciaServicio> getDetalleConstanciaServicioList() {
        return detalleConstanciaServicioList;
    }

    public void setDetalleConstanciaServicioList(List<DetalleConstanciaServicio> detalleConstanciaServicioList) {
        this.detalleConstanciaServicioList = detalleConstanciaServicioList;
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

    public List<CuotaMensualServicio> getCuotaMensualServicioList() {
        return cuotaMensualServicioList;
    }

    public void setCuotaMensualServicioList(List<CuotaMensualServicio> cuotaMensualServicioList) {
        this.cuotaMensualServicioList = cuotaMensualServicioList;
    }

    public List<PrecioServicio> getPrecioServicioList() {
        return precioServicioList;
    }

    public void setPrecioServicioList(List<PrecioServicio> precioServicioList) {
        this.precioServicioList = precioServicioList;
    }

    public List<ConstanciaDepositoDetalle> getConstanciaDepositoDetalleList() {
        return constanciaDepositoDetalleList;
    }

    public void setConstanciaDepositoDetalleList(List<ConstanciaDepositoDetalle> constanciaDepositoDetalleList) {
        this.constanciaDepositoDetalleList = constanciaDepositoDetalleList;
    }

    public List<ConstanciaServicioDetalle> getConstanciaServicioDetalleList() {
        return constanciaServicioDetalleList;
    }

    public void setConstanciaServicioDetalleList(List<ConstanciaServicioDetalle> constanciaServicioDetalleList) {
        this.constanciaServicioDetalleList = constanciaServicioDetalleList;
    }

    public List<ConstanciaSalidaServicio> getConstanciaSalidaServicioList() {
        return constanciaSalidaServicioList;
    }

    public void setConstanciaSalidaServicioList(List<ConstanciaSalidaServicio> constanciaSalidaServicioList) {
        this.constanciaSalidaServicioList = constanciaSalidaServicioList;
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
        return "mx.com.ferbo.model.Servicio[ id=" + id + " ]";
    }
    
}
