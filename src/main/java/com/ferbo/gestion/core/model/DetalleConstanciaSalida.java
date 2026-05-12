package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "detalle_constancia_salida")
@NamedQuery(name = "DetalleConstanciaSalida.findByPartida", query = "SELECT d FROM DetalleConstanciaSalida d WHERE d.partida.id = :idPartida")
@NamedQuery(name = "DetalleConstanciaSalida.findByParams", query = "SELECT d FROM DetalleConstanciaSalida d WHERE d.partida.id = :idPartida AND d.folioEntrada =:folioEntrada AND d.producto = :producto")
public class DetalleConstanciaSalida implements Serializable, Cloneable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "CAMARA_CVE")
    private int idCamara;

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Basic(optional = false)
    @NotNull
    @Column(name = "PESO")
    private BigDecimal peso;

    @Size(max = 10)
    @Column(name = "UNIDAD")
    private String unidad;

    @Size(max = 150)
    @Column(name = "PRODUCTO")
    private String producto;

    @Size(max = 10)
    @Column(name = "FOLIO_ENTRADA")
    private String folioEntrada;

    @Size(max = 50)
    @Column(name = "CAMARA_CADENA")
    private String camara;

    @Size(max = 6)
    @Column(name = "TEMPERATURA")
    private String temperatura;

    @JoinColumn(name = "CONSTANCIA_CVE", referencedColumnName = "ID")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private ConstanciaSalida constancia;

//    @JoinColumns({
//        @JoinColumn(name = "DET_PART_CVE", referencedColumnName = "DET_PART_CVE"),
//        @JoinColumn(name = "PARTIDA_CVE", referencedColumnName = "PARTIDA_CVE")}
//    )
//    @OneToOne(optional = false, cascade = CascadeType.ALL)
//    private DetallePartida detallePartida;
    @Column(name = "DET_PART_CVE")
    private int detallePartida;

    @JoinColumn(name = "PARTIDA_CVE", referencedColumnName = "PARTIDA_CVE")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private Partida partida;

    public DetalleConstanciaSalida() {
    }

    public DetalleConstanciaSalida(Integer id) {
        this.id = id;
    }

    public DetalleConstanciaSalida(Integer id, int idCamara, BigDecimal peso) {
        this.id = id;
        this.idCamara = idCamara;
        this.peso = peso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdCamara() {
        return idCamara;
    }

    public void setIdCamara(int idCamara) {
        this.idCamara = idCamara;
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

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getFolioEntrada() {
        return folioEntrada;
    }

    public void setFolioEntrada(String folioEntrada) {
        this.folioEntrada = folioEntrada;
    }

    public String getCamara() {
        return camara;
    }

    public void setCamara(String camara) {
        this.camara = camara;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public ConstanciaSalida getConstancia() {
        return constancia;
    }

    public void setConstancia(ConstanciaSalida constancia) {
        this.constancia = constancia;
    }
    
    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public int getDetallePartida() {
        return detallePartida;
    }

    public void setDetallePartida(int detallePartida) {
        this.detallePartida = detallePartida;
    }
    
    @Override
    public int hashCode() {
        if (this.id == null) {
            return System.identityHashCode(this);
        }
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleConstanciaSalida)) {
            return false;
        }
        DetalleConstanciaSalida other = (DetalleConstanciaSalida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.DetalleConstanciaSalida[ id=" + id + " ]";
    }
    
}
