package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "asentamiento_humano")
@NamedQueries({
    @NamedQuery(name = "Asentamiento.findAll", query = "SELECT a FROM Asentamiento a"),
    @NamedQuery(name = "Asentamiento.findByPais", query = "SELECT a FROM Asentamiento a WHERE a.asentamientoPK.ciudad.ciudadPK.municipio.municipioPK.estado.estadoPK.pais.id = :idPais"),
    @NamedQuery(name = "Asentamiento.findByEstado", query = "SELECT a FROM Asentamiento a WHERE a.asentamientoPK.ciudad.ciudadPK.municipio.municipioPK.estado.estadoPK.id = :idEstado"),
    @NamedQuery(name = "Asentamiento.findByMunicipio", query = "SELECT a FROM Asentamiento a WHERE a.asentamientoPK.ciudad.ciudadPK.municipio.municipioPK.id = :idMunicipio"),
    @NamedQuery(name = "Asentamiento.findByCiudad", query = "SELECT a FROM Asentamiento a WHERE a.asentamientoPK.ciudad.ciudadPK.id = :idCiudad"),
    @NamedQuery(name = "Asentamiento.findByTipoasntmnto", query = "SELECT a FROM Asentamiento a WHERE a.tipoAsentamiento.id = :idTipoAsntmnto"),
    @NamedQuery(name = "Asentamiento.findByEntidadPostal", query = "SELECT a FROM Asentamiento a WHERE a.entidadPostal.id = :idEntidadPostal"),
    @NamedQuery(name = "Asentamiento.findById", query = "SELECT a FROM Asentamiento a WHERE a.asentamientoPK.id = :idAsentamiento"),
    @NamedQuery(name = "Asentamiento.findByDescripcion", query = "SELECT a FROM Asentamiento a WHERE a.descripcion = :descricion"),
    @NamedQuery(name = "Asentamiento.findByCp", query = "SELECT a FROM Asentamiento a WHERE a.cp = :cp")
})
public class Asentamiento implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected AsentamientoPK asentamientoPK;
    
    @Size(max = 150)
    @Column(name = "asentamiento_ds")
    private String descripcion;
    
    @Size(max = 5)
    @Column(name = "cp")
    private String cp;
    
    @JoinColumn(name = "entidadpostal_cve", referencedColumnName = "entidadpostal_cve")
    @ManyToOne(optional = false)
    private EntidadPostal entidadPostal;
    
    @JoinColumn(name = "tipoasntmnto_cve", referencedColumnName = "tipoasntmnto_cve")
    @ManyToOne(optional = false)
    private TipoAsentamiento tipoAsentamiento;

    public Asentamiento() {
    }

    public Asentamiento(AsentamientoPK asentamientoPK) {
        this.asentamientoPK = asentamientoPK;
    }

    public Asentamiento(Ciudad ciudad, int id) {
        this.asentamientoPK = new AsentamientoPK(ciudad, id);
    }
    
    public Asentamiento(Ciudad ciudad, int id, String descripcion){
        this.asentamientoPK = new AsentamientoPK(ciudad, id);
        this.descripcion = descripcion;
    }

    public AsentamientoPK getAsentamientoPK() {
        return asentamientoPK;
    }

    public void setAsentamientoPK(AsentamientoPK asentamientoPK) {
        this.asentamientoPK = asentamientoPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setAsentamientoDs(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public EntidadPostal getEntidadPostal() {
        return entidadPostal;
    }

    public void setEntidadPostal(EntidadPostal entidadPostal) {
        this.entidadPostal = entidadPostal;
    }

    public TipoAsentamiento getTipoAsentamiento() {
        return tipoAsentamiento;
    }

    public void setTipoAsentamiento(TipoAsentamiento tipoAsentamiento) {
        this.tipoAsentamiento = tipoAsentamiento;
    }

    @Override
    public int hashCode() {
        if(this.asentamientoPK.getId() == null){
            return System.identityHashCode(this);
        }
        return Objects.hash(this.asentamientoPK.getId());
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
        final Asentamiento other = (Asentamiento) obj;
        return Objects.equals(this.asentamientoPK.getId(), other.asentamientoPK.getId());
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Asentamiento[ asentamientoPK=" + asentamientoPK.getId() + ", descripcion=" + descripcion + ", cp=" + cp + " ]";
    }
    
}
