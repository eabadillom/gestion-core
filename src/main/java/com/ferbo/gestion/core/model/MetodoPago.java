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
@NamedQueries({
    @NamedQuery(name = "MetodoPago.findAll", query = "SELECT mp FROM MetodoPago mp "),
    @NamedQuery(name = "MetodoPago.findByVigentes", query = "SELECT mp FROM MetodoPago mp WHERE mp.fechaInicio <= :fecha AND (mp.fechaFinal IS NULL OR mp.fechaFinal >= :fecha) ORDER BY mp.descripcion"),
    @NamedQuery(name = "MetodoPago.findByClave", query = "SELECT mp FROM MetodoPago mp WHERE mp.clave = :clave"),
    @NamedQuery(name = "MetodoPago.findByDescripcion", query = "SELECT mp FROM MetodoPago mp WHERE mp.descripcion = :descripcion")
})
public class MetodoPago implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cd_metodo_pago")
    @Size(max = 5)
    private String clave;

    @NotNull
    @Column(name = "nb_metodo_pago")
    @Size(max = 100)
    private String descripcion;

    @Column(name = "fh_vigencia_ini")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date fechaInicio;

    @Column(name = "fh_vigencia_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;

    public MetodoPago() {
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @Override
    public String toString() {
        return "MetodoPago [clave=" + clave + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(clave);
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
        return Objects.equals(clave, other.clave);
    }

}
