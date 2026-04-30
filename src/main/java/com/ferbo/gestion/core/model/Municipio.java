package com.ferbo.gestion.core.model;

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
@Table(name = "municipios")
@NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m")
@NamedQuery(name = "Municipio.findByPais", query = "SELECT m FROM Municipio m WHERE m.municipioPK.estado.estadoPK.pais.id = :idPais")
@NamedQuery(name = "Municipio.findByEstado", query = "SELECT m FROM Municipio m WHERE m.municipioPK.estado.estadoPK.id = :idEstado")
@NamedQuery(name = "Municipio.findByMunicipio", query = "SELECT m FROM Municipio m WHERE m.municipioPK.id = :idMunicipio")
@NamedQuery(name = "Municipio.findByDescripcion", query = "SELECT m FROM Municipio m WHERE m.descripcion = :descripcion")
@NamedQuery(name = "Municipio.findByPaisEstado", query = "SELECT m FROM Municipio m WHERE m.municipioPK.estado.estadoPK.pais.id = :idPais AND m.municipioPK.estado.estadoPK.id = :idEstado")
@NamedQuery(name = "Municipio.findByTodo", query = "SELECT m FROM Municipio m WHERE m.municipioPK.id = :idMunicipio AND m.municipioPK.estado.estadoPK.id = :idEstado AND m.municipioPK.estado.estadoPK.pais.id = :idPais")
public class Municipio implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected MunicipioPK municipioPK;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "municipio_ds")
    private String descripcion;
    
    @OneToMany(mappedBy = "ciudadPK.municipio")
    private List<Ciudad> ciudadList;

    public Municipio() {
    }

    public Municipio(Estado estado, int id) {
        this.municipioPK = new MunicipioPK(estado, id);
    }

    public Municipio(Estado estado, int id, String descripcion) {
        this.municipioPK = new MunicipioPK(estado, id);
        this.descripcion = descripcion;
    }

    public MunicipioPK getMunicipioPK() {
        return municipioPK;
    }

    public void setMunicipioPK(MunicipioPK municipioPK) {
        this.municipioPK = municipioPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }

    @Override
    public int hashCode() {
        if(this.municipioPK.getId() == null){
            return System.identityHashCode(this);
        }
        return Objects.hash(this.municipioPK.getId());
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
        final Municipio other = (Municipio) obj;
        return Objects.equals(this.municipioPK.getId(), other.municipioPK.getId());
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Municipio[ idMunicipio=" + municipioPK.getId() + ", descripcion=" + descripcion + " ]";
    }
    
}
