package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "posicion")
public class Posicion implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_posicion")
    private Integer id;

    @JoinColumn(name = "id_planta", referencedColumnName = "PLANTA_CVE")
    @ManyToOne(optional = false)
    private Planta planta;

    @JoinColumn(name = "id_camara", referencedColumnName = "CAMARA_CVE")
    @ManyToOne(optional = false)
    private Camara camara;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_posicion")
    private String codigo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "desc_posicion")
    private String descripcion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "temp_ini")
    private BigDecimal temperaturaInicial;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "temp_fin")
    private BigDecimal temperaturaFinal;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "habilitada")
    private boolean habilitada;

    public Posicion() {
    }

    public Posicion(Integer id) {
        this.id = id;
    }

    public Posicion(Integer id, Planta planta, Camara camara, String codigo, String descripcion, BigDecimal temperaturaInicial, BigDecimal temperaturaFinal, boolean habilitada) {
        this.id = id;
        this.planta = planta;
        this.camara = camara;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.temperaturaInicial = temperaturaInicial;
        this.temperaturaFinal = temperaturaFinal;
        this.habilitada = habilitada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public Camara getCamara() {
        return camara;
    }

    public void setCamara(Camara camara) {
        this.camara = camara;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getTemperaturaInicial() {
        return temperaturaInicial;
    }

    public void setTemperaturaInicial(BigDecimal temperaturaInicial) {
        this.temperaturaInicial = temperaturaInicial;
    }

    public BigDecimal getTemperaturaFinal() {
        return temperaturaFinal;
    }

    public void setTemperaturaFinal(BigDecimal temperaturaFinal) {
        this.temperaturaFinal = temperaturaFinal;
    }

    public boolean getHabilitada() {
        return habilitada;
    }

    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }

    @Override
    public int hashCode() {
    	if(this.id == null)
    		return System.identityHashCode(this);
    	return Objects.hashCode(this.id);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Posicion)) {
            return false;
        }
        Posicion other = (Posicion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Posicion[ id=" + id + " ]";
    }

}
