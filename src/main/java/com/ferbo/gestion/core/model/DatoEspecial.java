package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "datos_especiales")
@NamedQueries({
    @NamedQuery(name = "DatoEspecial.findAll", query = "SELECT d FROM DatoEspecial d"),
    @NamedQuery(name = "DatoEspecial.findByDatoEspCve", query = "SELECT d FROM DatoEspecial d WHERE d.id = :idDatoEsp"),
    @NamedQuery(name = "DatoEspecial.findByNombre", query = "SELECT d FROM DatoEspecial d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DatoEspecial.findByLongitud", query = "SELECT d FROM DatoEspecial d WHERE d.longitud = :longitud"),
    @NamedQuery(name = "DatoEspecial.findByPrecision", query = "SELECT d FROM DatoEspecial d WHERE d.precision = :precision")
})
public class DatoEspecial implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATO_ESP_CVE")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "LONGITUD")
    private Integer longitud;
    
    @Column(name = "\u00b4PRECISION\u00b4")
    private Integer precision;
    
    @JoinColumn(name = "FORMATO_CVE", referencedColumnName = "FORMATO_CVE")
    @ManyToOne
    private Formato formatoCve;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datoEspCve")
    private List<DetalleFacturacion> detalleFacturacionList;
    
    @OneToMany(mappedBy = "datoEspCve")
    private List<DetalleCteProd> detalleCteProdList;

    public DatoEspecial() {
    }

    public DatoEspecial(Integer id) {
        this.id = id;
    }

    public DatoEspecial(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public Formato getFormatoCve() {
        return formatoCve;
    }

    public void setFormatoCve(Formato formatoCve) {
        this.formatoCve = formatoCve;
    }

    public List<DetalleFacturacion> getDetalleFacturacionList() {
        return detalleFacturacionList;
    }

    public void setDetalleFacturacionList(List<DetalleFacturacion> detalleFacturacionList) {
        this.detalleFacturacionList = detalleFacturacionList;
    }

    public List<DetalleCteProd> getDetalleCteProdList() {
        return detalleCteProdList;
    }

    public void setDetalleCteProdList(List<DetalleCteProd> detalleCteProdList) {
        this.detalleCteProdList = detalleCteProdList;
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
        if (!(object instanceof DatoEspecial)) {
            return false;
        }
        DatoEspecial other = (DatoEspecial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.DatosEspecial[ id=" + id + " ]";
    }
    
}
