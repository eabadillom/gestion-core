package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "uso_cfdi")
@NamedQueries({
    @NamedQuery(name = "UsoCfdi.findAll", query = "SELECT u FROM UsoCfdi u"),
    @NamedQuery(name = "UsoCfdi.findByPersonaFisica", query = "SELECT u FROM UsoCfdi u WHERE u.aplicaPersonaFisica = true "),
    @NamedQuery(name = "UsoCfdi.findByPersonaMoral", query = "SELECT u FROM  UsoCfdi u WHERE u.aplicaPersonaMoral = true ")
})
public class UsoCfdi implements Serializable 
{
    private static final long serialVersionUID = 2460444038539852730L;

    @Id
    @Column(name = "cd_uso_cfdi")
    private String id;

    @Column(name = "nb_uso_cfdi")
    @Size(min = 1, max = 150)
    private String descripcion;

    @Column(name = "st_apl_per_fisica")
    private Boolean aplicaPersonaFisica;

    @Column(name = "st_apl_per_moral")
    private Boolean aplicaPersonaMoral;

    @Column(name = "fh_vigencia_ini")
    private LocalDate vigenciaInicio;

    @Column(name = "fh_vigencia_fin")
    private LocalDate vigenciaFin;

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

    public Boolean getAplicaPersonaFisica() {
        return aplicaPersonaFisica;
    }

    public void setAplicaPersonaFisica(Boolean aplicaPersonaFisica) {
        this.aplicaPersonaFisica = aplicaPersonaFisica;
    }

    public Boolean getAplicaPersonaMoral() {
        return aplicaPersonaMoral;
    }

    public void setAplicaPersonaMoral(Boolean aplicaPersonaMoral) {
        this.aplicaPersonaMoral = aplicaPersonaMoral;
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
        UsoCfdi other = (UsoCfdi) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.UsoCfdi [id=" + id + ", descripcion=" + descripcion + ", aplicaPersonaFisica="
                + aplicaPersonaFisica + ", aplicaPersonaMoral=" + aplicaPersonaMoral + ", vigenciaInicio="
                + vigenciaInicio + ", vigenciaFin=" + vigenciaFin + "]";
    }
    
}
