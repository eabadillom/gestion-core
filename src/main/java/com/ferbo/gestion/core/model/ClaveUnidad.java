package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clave_unidad")
@NamedQuery(name = "ClaveUnidad.findById", query = "SELECT c FROM ClaveUnidad c WHERE c.id = :idUnidad")
@NamedQuery(name = "ClaveUnidad.findByNombre", query = "SELECT c FROM ClaveUnidad c WHERE c.nombre = :nombre")
@NamedQuery(name = "ClaveUnidad.likeClaveNombre", query = "SELECT c FROM ClaveUnidad c WHERE c.id like :clave OR c.nombre like :nombre")
public class ClaveUnidad implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(max = 5)
    @Column(name = "cd_unidad")
    private String id;

    @Basic(optional = false)
    @Size(max = 200)
    @Column(name = "nb_unidad")
    private String nombre;

    @Size(max = 1000)
    @Column(name = "nb_descripcion")
    private String descripcion;

    @Size(max = 500)
    @Column(name = "nb_nota")
    private String nota;

    @Basic(optional = false)
    @Column(name = "fh_vigencia_ini")
    private LocalDate fechaInicio;

    @Column(name = "fh_vigencia_fin")
    private LocalDate fechaFinal;

    @Size(max = 50)
    @Column(name = "nb_simbolo")
    private String simboloMedida;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getSimboloMedida() {
        return simboloMedida;
    }

    public void setSimboloMedida(String simboloMedida) {
        this.simboloMedida = simboloMedida;
    }


}
