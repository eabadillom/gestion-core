package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "regimen_fiscal")
@NamedQueries({
    @NamedQuery(name = "RegimenFiscal.findAll", query = "SELECT r FROM  RegimenFiscal r"),
    @NamedQuery(name = "RegimenFiscal.findById", query = "SELECT r FROM RegimenFiscal r WHERE  r.id = :idRegimen"),
    @NamedQuery(name = "RegimenFiscal.findByDescripcion", query = "SELECT r FROM RegimenFiscal r WHERE  r.descripcion = :descripcion"),
    @NamedQuery(name = "RegimenFiscal.findByPerFisica", query = "SELECT r FROM RegimenFiscal r WHERE r.personaFisica = true ORDER BY r.descripcion"),
    @NamedQuery(name = "RegimenFiscal.findByPerMoral", query = "SELECT r FROM RegimenFiscal r WHERE r.personaMoral = true ORDER BY r.descripcion"),
    @NamedQuery(name = "RegimenFiscal.findByFechaIni", query = "SELECT r FROM RegimenFiscal r WHERE  r.vigenciaInicio = :fh_vigencia_ini"),
    @NamedQuery(name = "RegimenFiscal.findByFechaFin", query = "SELECT r FROM RegimenFiscal r WHERE r.vigenciaFin = :fh_vigencia_fin")
})
public class RegimenFiscal implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "cd_regimen")
    private String id;

    @Size(min = 1, max = 255)
    @Column(name = "nb_regimen")
    private String descripcion;

    @Basic(optional = false)
    @NotNull
    @Column(name = "st_per_fisica")
    private boolean personaFisica;

    @Basic(optional = false)
    @NotNull
    @Column(name = "st_per_moral")
    private boolean personaMoral;

    @Column(name = "fh_vigencia_ini")
    private LocalDate vigenciaInicio;

    @Column(name = "fh_vigencia_fin")
    private LocalDate vigenciaFin;

    public RegimenFiscal() {
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

    public boolean isPersonaFisica() {
        return personaFisica;
    }

    public void setPersonaFisica(boolean personaFisica) {
        this.personaFisica = personaFisica;
    }

    public boolean isPersonaMoral() {
        return personaMoral;
    }

    public void setPersonaMoral(boolean personaMoral) {
        this.personaMoral = personaMoral;
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
        return Objects.hashCode(this.id);
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
        RegimenFiscal other = (RegimenFiscal) obj;
        return Objects.equals(id, other.id) && Objects.equals(descripcion, other.descripcion)
                && personaFisica == other.personaFisica && personaMoral == other.personaMoral
                && Objects.equals(vigenciaFin, other.vigenciaFin)
                && Objects.equals(vigenciaInicio, other.vigenciaInicio);
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.RegimenFiscal [id=" + id + ", descripcion=" + descripcion + ", personaFisica="
                + personaFisica + ", personaMoral=" + personaMoral + ", vigenciaInicio=" + vigenciaInicio
                + ", vigenciaFin=" + vigenciaFin + "]";
    }

}
