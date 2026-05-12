package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @NotNull
    private LocalDate vigenciaInicio;

    @Column(name = "fh_vigencia_fin")
    private LocalDate vigenciaFin;

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

    public LocalDate getVigenciaInicio() {
        return vigenciaInicio;
    }

    public void setVigenciaInicio(LocalDate vigenciaInicio) {
        this.vigenciaInicio = vigenciaInicio;
    }

    public LocalDate getVigenciaFin() {
        return vigenciaFin;
    }

    public void setVigenciaFin(LocalDate vigenciaFin) {
        this.vigenciaFin = vigenciaFin;
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
