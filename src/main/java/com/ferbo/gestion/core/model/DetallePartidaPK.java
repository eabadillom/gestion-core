package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class DetallePartidaPK implements Serializable, Cloneable 
{
    private static final long serialVersionUID = -7593443111857351832L;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DET_PART_CVE")
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PARTIDA_CVE")
    private Partida partida;

    public DetallePartidaPK() {
    }

    public DetallePartidaPK(Partida partida, Integer id) {
        this.partida = partida;
        this.id = id;
    }

    public DetallePartidaPK clone() throws CloneNotSupportedException {
        return (DetallePartidaPK) super.clone();
    }

    public DetallePartidaPK(@NotNull int id, Partida partida) {
        super();
        this.id = id;
        this.partida = partida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partida);
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
        DetallePartidaPK other = (DetallePartidaPK) obj;
        return id == other.id && Objects.equals(partida, other.partida);
    }

    @Override
    public String toString() {
        return "DetallePartidaPK [id=" + id + ", partida=" + partida + "]";
    }

}
