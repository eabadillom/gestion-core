package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "posicion")
@NamedQueries({
    @NamedQuery(name = "Posicion.findAll", query = "SELECT p FROM Posicion p"),
    @NamedQuery(name = "Posicion.findByPosicion", query = "SELECT p FROM Posicion p WHERE p.id = :idPosicion"),
    @NamedQuery(name = "Posicion.findByCamara", query = "SELECT p FROM Posicion p WHERE p.camara.id = :idCamara"),
    @NamedQuery(name = "Posicion.findByPlantaCamara", query = "SELECT p FROM Posicion p WHERE p.planta.id = :idPlanta AND p.camara.id = :idCamara"),
    @NamedQuery(name = "Posicion.findByCodPosicion", query = "SELECT p FROM Posicion p WHERE p.codPosicion = :codPosicion"),
    @NamedQuery(name = "Posicion.findByDescPosicion", query = "SELECT p FROM Posicion p WHERE p.descPosicion = :descPosicion"),
    @NamedQuery(name = "Posicion.findByTempIni", query = "SELECT p FROM Posicion p WHERE p.tempIni = :tempIni"),
    @NamedQuery(name = "Posicion.findByTempFin", query = "SELECT p FROM Posicion p WHERE p.tempFin = :tempFin"),
    @NamedQuery(name = "Posicion.findByHabilitada", query = "SELECT p FROM Posicion p WHERE p.habilitada = :habilitada")
})
public class Posicion implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_posicion")
    private Integer id;

    @JoinColumn(name = "id_planta", referencedColumnName = "PLANTA_CVE")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Planta planta;

    @JoinColumn(name = "id_camara", referencedColumnName = "CAMARA_CVE")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Camara camara;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_posicion")
    private String codPosicion;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "desc_posicion")
    private String descPosicion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "temp_ini")
    private BigDecimal tempIni;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "temp_fin")
    private BigDecimal tempFin;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "habilitada")
    private boolean habilitada;

    public Posicion() {
    }

    public Posicion(Integer id) {
        this.id = id;
    }

    public Posicion(Integer id, Planta planta, Camara camara, String codPosicion, String descPosicion, BigDecimal tempIni, BigDecimal tempFin, boolean habilitada) {
        this.id = id;
        this.planta = planta;
        this.camara = camara;
        this.codPosicion = codPosicion;
        this.descPosicion = descPosicion;
        this.tempIni = tempIni;
        this.tempFin = tempFin;
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

    public String getCodPosicion() {
        return codPosicion;
    }

    public void setCodPosicion(String codPosicion) {
        this.codPosicion = codPosicion;
    }

    public String getDescPosicion() {
        return descPosicion;
    }

    public void setDescPosicion(String descPosicion) {
        this.descPosicion = descPosicion;
    }

    public BigDecimal getTempIni() {
        return tempIni;
    }

    public void setTempIni(BigDecimal tempIni) {
        this.tempIni = tempIni;
    }

    public BigDecimal getTempFin() {
        return tempFin;
    }

    public void setTempFin(BigDecimal tempFin) {
        this.tempFin = tempFin;
    }

    public boolean getHabilitada() {
        return habilitada;
    }

    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
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
        return "mx.com.ferbo.model.Posicion[ id=" + id + " ]";
    }

}
