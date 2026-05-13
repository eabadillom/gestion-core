package com.ferbo.gestion.core.model.inventario.salida.orden;

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

import com.ferbo.gestion.core.model.inventario.entrada.Partida;

@Entity
@Table(name = "salida_detalle")
public class SalidaDetalle implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_salida_det")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "cd_salida", referencedColumnName = "cd_salida")
    private Salida salida;
    
    @ManyToOne
    @JoinColumn(name = "partida_cve", referencedColumnName = "PARTIDA_CVE")
    private Partida partida;
    
    @Column(name = "nu_cantidad")
    private Integer cantidad;
    
    @Column(name = "ct_peso_aprox")
    private BigDecimal peso;

    public SalidaDetalle() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Salida getSalida() {
        return salida;
    }

    public void setSalida(Salida salida) {
        this.salida = salida;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    @Override
    public int hashCode() {
        if (this.id == null) {
            return System.identityHashCode(this);
        }
        return Objects.hash(this.id);
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
        final SalidaDetalle other = (SalidaDetalle) obj;
        if(this.id == null || other.id == null)
            return Objects.equals(System.identityHashCode(this), System.identityHashCode(other));
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.SalidaDetalle[" + "id=" + id + ", cantidad=" + cantidad + ", pesoAprox=" + peso + ']';
    }
    
}
