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

@Entity
@Table(name = "servicios_salida")
@NamedQueries({
    @NamedQuery(name = "ServiciosSalida.findAll", query = "SELECT ss FROM ServiciosSalida ss"),
    @NamedQuery(name = "ServiciosSalida.findById", query = "SELECT ss FROM ServiciosSalida ss WHERE ss.id = :idSrvSalida"),
    @NamedQuery(name = "ServiciosSalida.findByFolioSalida", query = "SELECT ss FROM ServiciosSalida ss INNER JOIN ss.salida s WHERE s.folioSalida = :folioSalida")
})
public class ServiciosSalida implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_srv_salida")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "cd_salida", referencedColumnName = "cd_salida")
    private Salida salida;
    
    @ManyToOne
    @JoinColumn(name = "servicio_cve", referencedColumnName = "servicio_cve")
    private Servicio servicio;
    
    @ManyToOne
    @JoinColumn(name = "unidad_de_manejo_cve", referencedColumnName = "unidad_de_manejo_cve")
    private UnidadManejo unidadManejo;
    
    @Column(name = "nu_cantidad")
    private Integer cantidad;

    public ServiciosSalida() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Salida getSalida() {
        return salida;
    }

    public void setSalida(Salida salida) {
        this.salida = salida;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public UnidadManejo getUnidadManejo() {
        return unidadManejo;
    }

    public void setUnidadManejo(UnidadManejo unidadManejo) {
        this.unidadManejo = unidadManejo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
         if (this.id == null) {
            return System.identityHashCode(this);
        }
        return Objects.hash(this.id);
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
        final ServiciosSalida other = (ServiciosSalida) obj;
        if(this.id == null || other.id == null)
            return Objects.equals(System.identityHashCode(this), System.identityHashCode(other));
        
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.ServiciosSalida[" + "id=" + id + ", cantidad=" + cantidad + ']';
    }
    
}
