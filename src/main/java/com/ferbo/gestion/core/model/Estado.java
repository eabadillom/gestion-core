package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "estados")
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
    @NamedQuery(name = "Estado.findByPais", query = "SELECT e FROM Estado e WHERE e.estadoPK.pais.id = :idPais"),
    @NamedQuery(name = "Estado.findByEstado", query = "SELECT e FROM Estado e WHERE e.estadoPK.id = :idEstado"),
    @NamedQuery(name = "Estado.findByClave", query = "SELECT e FROM Estado e WHERE e.clave = :clave"),
    @NamedQuery(name = "Estado.findByDescripcion", query = "SELECT e FROM Estado e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Estado.findByCriterios", query = "SELECT e FROM Estado e WHERE e.estadoPK.pais.id = :idPais AND e.estadoPK.id = :idEstado")
})
public class Estado implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected EstadoPK estadoPK;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "estado_ds_corta")
    private String clave;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "estado_desc")
    private String descripcion;
    
    @OneToMany(mappedBy = "municipioPK.estado")
    private List<Municipio> municipioList;

    public Estado() {
    }

    public Estado(EstadoPK estadoPK) {
        this.estadoPK = estadoPK;
    }
    
    public Estado(Paises pais, int id) {
        this.estadoPK = new EstadoPK(pais, id);
    }

    public Estado(Paises pais, int id, String clave) {
        this.estadoPK = new EstadoPK(pais, id);
        this.clave = clave;
    }

    public EstadoPK getEstadoPK() {
        return estadoPK;
    }

    public void setEstadoPK(EstadoPK estadoPK) {
        this.estadoPK = estadoPK;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDesccripcion() {
        return descripcion;
    }

    public void setDesccripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Municipio> getMunicipioList() {
        return municipioList;
    }

    public void setMunicipioList(List<Municipio> municipioList) {
        this.municipioList = municipioList;
    }

    @Override
    public int hashCode() {
        if(this.estadoPK.getId() == null){
            return System.identityHashCode(this);
        }
        return Objects.hash(this.estadoPK.getId());
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
        final Estado other = (Estado) obj;
        return Objects.equals(this.estadoPK.getId(), other.estadoPK.getId());
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Estado[ idEstado=" + estadoPK.getId() + ", descripcion=" + descripcion + " ]";
    }
    
}
