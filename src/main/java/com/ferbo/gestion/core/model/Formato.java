package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "formato")
@NamedQueries({
    @NamedQuery(name = "Formato.findAll", query = "SELECT f FROM Formato f"),
    @NamedQuery(name = "Formato.findByFormatoCve", query = "SELECT f FROM Formato f WHERE f.id = :idFormato"),
    @NamedQuery(name = "Formato.findByNombre", query = "SELECT f FROM Formato f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "Formato.findByLongitud", query = "SELECT f FROM Formato f WHERE f.longitud = :longitud"),
    @NamedQuery(name = "Formato.findByPrecision", query = "SELECT f FROM Formato f WHERE f.precision = :precision")
})
public class Formato implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FORMATO_CVE")
    private Integer id;
    
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "LONGITUD")
    private Short longitud;
    
    @Column(name = "PRECISION")
    private Short precision;
    
    @OneToMany(mappedBy = "formatoCve")
    private List<DatoEspecial> datosEspecialesList;

    public Formato() {
    }

    public Formato(Integer id) {
        this.id = id;
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

    public Short getLongitud() {
        return longitud;
    }

    public void setLongitud(Short longitud) {
        this.longitud = longitud;
    }

    public Short getPrecision() {
        return precision;
    }

    public void setPrecision(Short precision) {
        this.precision = precision;
    }

    public List<DatoEspecial> getDatosEspecialList() {
        return datosEspecialesList;
    }

    public void setDatosEspecialList(List<DatoEspecial> datosEspecialesList) {
        this.datosEspecialesList = datosEspecialesList;
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
        if (!(object instanceof Formato)) {
            return false;
        }
        Formato other = (Formato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.Formato[ id=" + id + " ]";
    }
    
}
