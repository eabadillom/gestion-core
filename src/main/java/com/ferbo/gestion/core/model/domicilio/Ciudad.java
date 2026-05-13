package com.ferbo.gestion.core.model.domicilio;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ciudades")
@NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
@NamedQuery(name = "Ciudad.findByPais", query = "SELECT c FROM Ciudad c WHERE c.ciudadPK.municipio.municipioPK.estado.estadoPK.pais.id = :idPais")
@NamedQuery(name = "Ciudad.findByEstado", query = "SELECT c FROM Ciudad c WHERE c.ciudadPK.municipio.municipioPK.estado.estadoPK.id = :idEstado")
@NamedQuery(name = "Ciudad.findByMunicipio", query = "SELECT c FROM Ciudad c WHERE c.ciudadPK.municipio.municipioPK.id = :idMunicipio")
@NamedQuery(name = "Ciudad.findById", query = "SELECT c FROM Ciudad c WHERE c.ciudadPK.id = :idCiudad")
@NamedQuery(name = "Ciudad.findByDescripcion", query = "SELECT c FROM Ciudad c WHERE c.descripcion = :descripcion")
@NamedQuery(name = "Ciudad.findByParametros", query = "SELECT c FROM Ciudad c WHERE c.ciudadPK.municipio.municipioPK.estado.estadoPK.pais.id = :idPais AND c.ciudadPK.municipio.municipioPK.estado.estadoPK.id = :idEstado AND c.ciudadPK.municipio.municipioPK.id = :idMunicipio AND c.ciudadPK.id = :idCiudad")
@NamedQuery(name = "Ciudad.findByPaisEstadoMunicipio", query = "SELECT c FROM Ciudad c WHERE c.ciudadPK.municipio.municipioPK.id = :idMunicipio AND c.ciudadPK.municipio.municipioPK.estado.estadoPK.id = :idEstado AND c.ciudadPK.id = :idCiudad")
@NamedQuery(name = "Ciudad.findByEstadoMunicipio", query = "SELECT c FROM Ciudad c WHERE c.ciudadPK.municipio.municipioPK.id = :idMunicipio AND c.ciudadPK.municipio.municipioPK.estado.estadoPK.id = :idEstado")
public class Ciudad implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected CiudadPK ciudadPK;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ciudad_ds")
    private String descripcion;
    
    @OneToMany(mappedBy = "asentamientoPK.ciudad")
    private List<Asentamiento> asentamientos;

    public Ciudad() {
    }

    public Ciudad(Municipio municipio, int id) {
        this.ciudadPK = new CiudadPK(municipio, id);
    }

    public Ciudad(Municipio municipio, int id, String descripcion) {
        this.ciudadPK = new CiudadPK(municipio, id);
        this.descripcion = descripcion;
    }

    public CiudadPK getCiudadPK() {
        return ciudadPK;
    }

    public void setCiudadPK(CiudadPK ciudadPK) {
        this.ciudadPK = ciudadPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Asentamiento> getAsentamientos() {
        return asentamientos;
    }

    public void setAsentamientos(List<Asentamiento> asentamientos) {
        this.asentamientos = asentamientos;
    }

    @Override
    public int hashCode() {
        if(this.ciudadPK.getId() == null){
            return System.identityHashCode(this);
        }
        return Objects.hash(this.getCiudadPK().getId());
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
        final Ciudad other = (Ciudad) obj;
        return Objects.equals(this.ciudadPK.getId(), other.ciudadPK.getId());
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Ciudad[ ciudadPK=" + ciudadPK.getId() + ", descripcion=" + descripcion + " ]";
    }
    
}
