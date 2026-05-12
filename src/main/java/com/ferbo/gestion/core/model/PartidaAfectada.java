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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Null;

@Entity
@Table(name = "partidas_afectadas")
@NamedQueries({
    @NamedQuery(name = "PartidaAfectada.findAll", query = "SELECT pa FROM PartidaAfectada pa"),
    @NamedQuery(name = "PartidaAfectada.findById", query = "SELECT pa FROM PartidaAfectada pa WHERE pa.id= :idPartidaAfectada"),
    @NamedQuery(name = "PartidaAfectada.findByTraspaso", query = "SELECT pa FROM PartidaAfectada pa WHERE pa.traspaso = :traspaso"),
    @NamedQuery(name = "PartidaAfectada.findByPartida", query = "SELECT pa FROM PartidaAfectada pa WHERE pa.partida = :partida"),
    @NamedQuery(name = "PartidaAfectada.findByPartidaTraspaso", query = "SELECT pa FROM PartidaAfectada pa WHERE pa.traspasoPartida = :partidaTraspaso")
})
public class PartidaAfectada implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = true)
    @Null
    @Column(name = "traspaso")
    private String traspaso;

    @ManyToOne(optional = false)
    @JoinColumn(name = "partida", referencedColumnName = "PARTIDA_CVE")
    private Partida partida;

    @OneToOne(optional = false)
    @JoinColumn(name = "PARTIDA_TRASPASO", referencedColumnName = "id")
    private TraspasoPartida traspasoPartida;

    public PartidaAfectada() {
    }

    public PartidaAfectada(String traspaso, Partida partida, TraspasoPartida traspasoPartida) {
        this.traspaso = traspaso;
        this.partida = partida;
        this.traspasoPartida = traspasoPartida;
    }

    public String getTraspaso() {
        return traspaso;
    }

    public void setTraspaso(String traspaso) {
        this.traspaso = traspaso;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public TraspasoPartida getTraspasoPartida() {
        return traspasoPartida;
    }

    public void setTraspasoPartida(TraspasoPartida traspasoPartida) {
        this.traspasoPartida = traspasoPartida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partida, traspasoPartida, traspaso);
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
        PartidaAfectada other = (PartidaAfectada) obj;
        return Objects.equals(id, other.id) && Objects.equals(partida, other.partida)
                && Objects.equals(traspasoPartida, other.traspasoPartida) && Objects.equals(traspaso, other.traspaso);
    }
    
    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.PartidaAfectada [id=" + id + ", traspaso=" + traspaso + ", partida=" + partida + ", partidatraspaso="
                + traspasoPartida + "]";
    }

}
