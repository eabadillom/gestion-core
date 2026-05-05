package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "metodo_pago")
@NamedQuery(name = "MetodoPago.findVigentes", query = "SELECT mp FROM MetodoPago mp WHERE mp.vigenciaInicio <= :fecha AND (mp.vigenciaFin IS NULL OR mp.vigenciaFin >= :fecha) ORDER BY mp.descripcion")
public class MetodoPago implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cd_metodo_pago")
    @Size(max = 5)
    private String id;

    @NotNull
    @Column(name = "nb_metodo_pago")
    @Size(max = 100)
    private String descripcion;

    @Column(name = "fh_vigencia_ini")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date vigenciaInicio;

    @Column(name = "fh_vigencia_fin")
    @Temporal(TemporalType.DATE)
    private Date vigenciaFin;

    public MetodoPago() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return vigenciaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.vigenciaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return vigenciaFin;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.vigenciaFin = fechaFinal;
    }

    @Override
    public int hashCode() {
    	if(this.id == null)
    		return System.identityHashCode(this);
        return Objects.hash(id);
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
        MetodoPago other = (MetodoPago) obj;
        return Objects.equals(id, other.id);
    }
    
    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.MetodoPago [clave=" + id + "]";
    }

}
