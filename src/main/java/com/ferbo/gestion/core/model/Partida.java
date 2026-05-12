package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "partida")
@NamedQueries({
    @NamedQuery(name = "Partida.findAll", query = "SELECT p FROM Partida p"),
    @NamedQuery(name = "Partida.findByPartida", query = "SELECT p FROM Partida p WHERE p.id = :idPartida"),
    @NamedQuery(name = "Partida.findByPesoTotal", query = "SELECT p FROM Partida p WHERE p.pesoTotal = :pesoTotal"),
    @NamedQuery(name = "Partida.findByCantidadTotal", query = "SELECT p FROM Partida p WHERE p.cantidadTotal = :cantidadTotal"),
    @NamedQuery(name = "Partida.findByUnidadProducto", query = "SELECT p FROM Partida p WHERE p.unidadProducto = :unidadProducto"),
    @NamedQuery(name = "Partida.findByCantidadDeCobro", query = "SELECT p FROM Partida p WHERE p.cantidadCobro = :cantidadDeCobro"),
    @NamedQuery(name = "Partida.findByPartidaSeq", query = "SELECT p FROM Partida p WHERE p.partidaSeq = :partidaSeq"),
    @NamedQuery(name = "Partida.findByValorMercancia", query = "SELECT p FROM Partida p WHERE p.valorMercancia = :valorMercancia"),
    @NamedQuery(name = "Partida.findByRendimiento", query = "SELECT p FROM Partida p WHERE p.rendimiento = :rendimiento"),
    @NamedQuery(name = "Partida.findByNoTarimas", query = "SELECT p FROM Partida p WHERE p.numeroTarimas = :noTarimas"),
    @NamedQuery(name = "Partida.findByConstanciaDeDeposito", query = "SELECT p FROM Partida p WHERE p.constanciaDeposito.folioCliente = :folioCliente")
})
public class Partida implements Serializable, Cloneable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PARTIDA_CVE")
    private Integer id;

    @Column(name = "PESO_TOTAL")
    private BigDecimal pesoTotal;

    @Column(name = "CANTIDAD_TOTAL")
    private Integer cantidadTotal;

    @Column(name = "cantidad_de_cobro")
    private BigDecimal cantidadCobro;

    @Column(name = "partida_seq")
    private Integer partidaSeq;

    @Column(name = "valorMercancia")
    private BigDecimal valorMercancia;

    @Column(name = "rendimiento")
    private BigDecimal rendimiento;

    @Basic(optional = true)
    @NotNull
    @Column(name = "no_tarimas")
    private BigDecimal numeroTarimas;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "key.partida")//PENDIENTE NO MNODIFICA EL DETALLE PARTIDA DE LA PARTIDA SELECCIONADA detallePartidaPK.id
    private List<DetallePartida> detallesPartida;

    @JoinColumn(name = "CAMARA_CVE", referencedColumnName = "CAMARA_CVE")
    @ManyToOne
    private Camara camara;

    @JoinColumn(name = "FOLIO", referencedColumnName = "FOLIO")
    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    private ConstanciaDeposito constanciaDeposito;

    @JoinColumn(name = "unidad_de_cobro", referencedColumnName = "UNIDAD_DE_MANEJO_CVE")
    @ManyToOne
    private UnidadManejo unidadCobro;
    
    @OneToMany(mappedBy = "partida", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private List<DetalleConstanciaSalida> detallesSalida;

    @JoinColumn(name = "UNIDAD_DE_PRODUCTO_CVE", referencedColumnName = "UNIDAD_DE_PRODUCTO_CVE")
    @ManyToOne(optional = false)
    private UnidadProducto unidadProducto;

    @OneToMany(mappedBy = "partida", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private List<TraspasoPartida> traspasosPartida;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "cd_tarima", referencedColumnName = "cd_tarima")
    private Tarima tarima;  

    public void add(DetallePartida detalle) {
        if (this.detallesPartida == null) {
            this.detallesPartida = new ArrayList<DetallePartida>();
        }

        if (detalle.getKey() == null) {
            detalle.setKey(new DetallePartidaPK(detallesPartida.size(), this));
        }

        this.detallesPartida.add(detalle);
    }

    public void add(DetalleConstanciaSalida detallesSalida) {
        if (this.detallesSalida == null) {
            this.detallesSalida = new ArrayList<DetalleConstanciaSalida>();
        }

        this.detallesSalida.add(detallesSalida);
    }

    public void setUnidadProducto(UnidadProducto unidadProducto) {
        this.unidadProducto = unidadProducto;
    }

    public Partida() {
    }

    public Partida(Integer id) {
        this.id = id;
    }

    public Partida(Integer id, BigDecimal noTarimas) {
        this.id = id;
        this.numeroTarimas = noTarimas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(BigDecimal pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public Integer getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Integer cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public BigDecimal getCantidadCobro() {
        return cantidadCobro;
    }

    public void setCantidadCobro(BigDecimal cantidadCobro) {
        this.cantidadCobro = cantidadCobro;
    }

    public Integer getPartidaSeq() {
        return partidaSeq;
    }

    public void setPartidaSeq(Integer partidaSeq) {
        this.partidaSeq = partidaSeq;
    }

    public BigDecimal getValorMercancia() {
        return valorMercancia;
    }

    public void setValorMercancia(BigDecimal valorMercancia) {
        this.valorMercancia = valorMercancia;
    }

    public BigDecimal getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(BigDecimal rendimiento) {
        this.rendimiento = rendimiento;
    }

    public BigDecimal getNumeroTarimas() {
        return numeroTarimas;
    }

    public void setNumeroTarimas(BigDecimal numeroTarimas) {
        this.numeroTarimas = numeroTarimas;
    }

    public List<DetallePartida> getDetallesPartida() {
        return detallesPartida;
    }

    public void setDetallesPartida(List<DetallePartida> detallesPartida) {
        this.detallesPartida = detallesPartida;
        for (DetallePartida detallePartida : detallesPartida) {
            detallePartida.getKey().setPartida(this);
        }
    }

    public Camara getCamara() {
        return camara;
    }

    public void setCamara(Camara camara) {
        this.camara = camara;
    }

    public ConstanciaDeposito getConstanciaDeposito() {
        return constanciaDeposito;
    }

    public void setConstanciaDeposito(ConstanciaDeposito constanciaDeposito) {
        this.constanciaDeposito = constanciaDeposito;
    }

    public UnidadManejo getUnidadCobro() {
        return unidadCobro;
    }

    public void setUnidadCobro(UnidadManejo unidadCobro) {
        this.unidadCobro = unidadCobro;
    }

    public List<DetalleConstanciaSalida> getDetallesSalida() {
        return detallesSalida;
    }

    public void setDetallesSalida(List<DetalleConstanciaSalida> detallesSalida) {
        this.detallesSalida = detallesSalida;
    }

    public UnidadProducto getUnidadProducto() {
        return unidadProducto;
    }

    public List<TraspasoPartida> getTraspasosPartida() {
        return traspasosPartida;
    }

    public void setTraspasosPartida(List<TraspasoPartida> traspasosPartida) {
        this.traspasosPartida = traspasosPartida;
    }

    public Tarima getTarima() {
        return tarima;
    }

    public void setTarima(Tarima tarima) {
        this.tarima = tarima;
    }

    public Partida clone() throws CloneNotSupportedException {
        Partida partida = null;

        partida = new Partida();
        partida.setId(this.id == null ? null : new Integer(this.id));
        partida.setPesoTotal(this.pesoTotal);
        partida.setCantidadTotal(this.cantidadTotal == null ? null : new Integer(this.cantidadTotal));
        partida.setCantidadCobro(this.cantidadCobro);
        partida.setPartidaSeq(this.partidaSeq == null ? null : new Integer(this.partidaSeq));
        partida.setValorMercancia(this.valorMercancia);
        partida.setRendimiento(this.rendimiento);
        partida.setNumeroTarimas(this.numeroTarimas);

        if (this.detallesPartida != null) {
            partida.setDetallesPartida(new ArrayList<DetallePartida>());
        }

        for (DetallePartida dp : this.detallesPartida) {
            DetallePartida detalle = dp.clone();
            detalle.setKey(new DetallePartidaPK(partida, dp.getKey().getId()));
            partida.add(detalle);
        }

        if (this.camara != null) {
            partida.setCamara(this.camara);
        }

        if (this.constanciaDeposito != null) {
            partida.setConstanciaDeposito(constanciaDeposito);
        }

        if (this.unidadCobro != null) {
            partida.setUnidadCobro(this.unidadCobro);
        }

        //Se omite la lista de DetalleConstanciaSalida
        partida.setDetallesSalida(null);

        if (this.unidadProducto != null) {
            partida.setUnidadProducto(this.unidadProducto);
        }

        //Se omite la lista de TraspasoPartida
        partida.setTraspasosPartida(null);

        //Se omite Tarima.
        partida.setTarima(null);

        return partida;
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
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        final Partida other = (Partida) object;
        if (this.id == null && other.id == null) {
            return Objects.equals(System.identityHashCode(this), System.identityHashCode(other));
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Partida[ id=" + id + ", productoDs=" + unidadProducto.getProducto().getDescripcion() + " ]";
    }
    
}
