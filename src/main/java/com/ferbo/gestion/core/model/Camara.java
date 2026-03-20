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
@Table(name = "camara")
@NamedQueries({
    @NamedQuery(name = "Camara.findAll", query = "SELECT c FROM Camara c"),
    @NamedQuery(name = "Camara.findByCamaraCve", query = "SELECT c FROM Camara c WHERE c.id = :idCamara"),
    @NamedQuery(name = "Camara.findByPlantaCve", query = "SELECT c FROM Camara c WHERE c.planta.id = :idPlanta"),
    @NamedQuery(name = "Camara.findByCamaraDs", query = "SELECT c FROM Camara c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Camara.findByCamaraAbrev", query = "SELECT c FROM Camara c WHERE c.clave = :clave")
})
public class Camara implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CAMARA_CVE")
    private Integer id;
    
    @Size(max = 80)
    @Column(name = "CAMARA_DS")
    private String descripcion;
    
    @Size(max = 6)
    @Column(name = "CAMARA_ABREV")
    private String clave;
    
    @Column(name = "TOTAL_POSICIONES")
    private Integer totalPosicion;
    
    @JoinColumn(name = "PLANTA_CVE", referencedColumnName = "PLANTA_CVE")
    @ManyToOne
    private Planta planta;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "camara")
    private List<Posicion> posicionList;
    
    public Camara() {
    }

    public Camara(Integer id) {
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }       

    public Integer getTotalPosicion() {
        return totalPosicion;
    }

    public void setTotalPosicion(Integer totalPosicion) {
        this.totalPosicion = totalPosicion;
    }

    @Override
    public int hashCode() {
    	if(this.id == null)
    		return System.identityHashCode(this);
    	return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Camara)) {
            return false;
        }
        Camara other = (Camara) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.Camara[ id=" + id + " ]";
    }
    
}
