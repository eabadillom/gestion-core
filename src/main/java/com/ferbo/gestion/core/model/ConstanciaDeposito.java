package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "constancia_de_deposito")
@NamedQueries({
    @NamedQuery(name = "ConstanciaDeposito.findAll", query = "SELECT c FROM ConstanciaDeposito c"),
    @NamedQuery(name = "ConstanciaDeposito.findByFolio", query = "SELECT c FROM ConstanciaDeposito c WHERE c.folio = :folio"),
    @NamedQuery(name = "ConstanciaDeposito.findById", query = "SELECT c FROM ConstanciaDeposito c WHERE c.cliente.id = :idCliente"),
    @NamedQuery(name = "ConstanciaDeposito.findByIdAndPlanta", query = "SELECT DISTINCT (c) FROM ConstanciaDeposito c INNER JOIN c.partidaList p WHERE c.cliente.id = :idCliente and p.camara.planta.id = :idPlanta"),
    @NamedQuery(name = "ConstanciaDeposito.findByFechaIngreso", query = "SELECT c FROM ConstanciaDeposito c WHERE c.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "ConstanciaDeposito.findByNombreTransportista", query = "SELECT c FROM ConstanciaDeposito c WHERE c.nombreTransportista = :nombreTransportista"),
    @NamedQuery(name = "ConstanciaDeposito.findByPlacasTransporte", query = "SELECT c FROM ConstanciaDeposito c WHERE c.placasTransporte = :placasTransporte"),
    @NamedQuery(name = "ConstanciaDeposito.findByObservaciones", query = "SELECT c FROM ConstanciaDeposito c WHERE c.observaciones = :observaciones"),
    @NamedQuery(name = "ConstanciaDeposito.findByFolioCliente", query = "SELECT c FROM ConstanciaDeposito c WHERE c.folioCliente = :folioCliente"),
    @NamedQuery(name = "ConstanciaDeposito.findByValorDeclarado", query = "SELECT c FROM ConstanciaDeposito c WHERE c.valorDeclarado = :valorDeclarado"),
    @NamedQuery(name = "ConstanciaDeposito.findByFolioClientePeriodo", query = "SELECT c FROM ConstanciaDeposito c WHERE (c.fechaIngreso BETWEEN :fechaInicio AND :fechaFin) AND ((c.folioCliente = :folioCliente OR :folioCliente IS NULL) OR (c.cliente.id = :idCliente OR :idCliente IS NULL)\t) "),
    @NamedQuery(name = "ConstanciaDeposito.findByTemperatura", query = "SELECT c FROM ConstanciaDeposito c WHERE c.temperatura = :temperatura"),
    @NamedQuery(name = "ConstanciaDeposito.findByProducto", query = "SELECT distinct c from ConstanciaDeposito c INNER JOIN c.partidaList p INNER JOIN p.unidadProducto up INNER JOIN up.producto pr where pr.descripcion like :nombreProducto OR pr.numeroProd like :nombreProducto order by c.fechaIngreso DESC")
})
public class ConstanciaDeposito implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FOLIO")
    private Integer folio;

    @Column(name = "FECHA_INGRESO")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    @Size(max = 100)
    @Column(name = "NOMBRE_TRANSPORTISTA")
    private String nombreTransportista;

    @Size(max = 10)
    @Column(name = "PLACAS_TRANSPORTE")
    private String placasTransporte;

    @Size(max = 200)
    @Column(name = "OBSERVACIONES")
    private String observaciones;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "folio_cliente")
    private String folioCliente;

    @Column(name = "valor_declarado")
    private BigDecimal valorDeclarado;

    @Size(max = 50)
    @Column(name = "temperatura")
    private String temperatura;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "constanciaDeposito")
    private List<Partida> partidaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "constanciaDeposito")
    private List<ConstanciaDepositoDetalle> constanciaDepositoDetalleList;

    @JoinColumn(name = "CTE_CVE", referencedColumnName = "CTE_CVE", nullable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;

    @JoinColumn(name = "aviso_cve", referencedColumnName = "aviso_cve", nullable = false)
    @ManyToOne
    private Aviso avisoCve;

    @JoinColumn(name = "status", referencedColumnName = "edo_cve", nullable = false)
    @ManyToOne
    private EstadoConstancia status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "constanciaDeposito")
    private List<ConstanciaFactura> constanciaFacturaList;

    public ConstanciaDeposito() {
    }

    public ConstanciaDeposito(Integer folio) {
        this.folio = folio;
    }

    public ConstanciaDeposito(Integer folio, String folioCliente) {
        this.folio = folio;
        this.folioCliente = folioCliente;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getNombreTransportista() {
        return nombreTransportista;
    }

    public void setNombreTransportista(String nombreTransportista) {
        this.nombreTransportista = nombreTransportista;
    }

    public String getPlacasTransporte() {
        return placasTransporte;
    }

    public void setPlacasTransporte(String placasTransporte) {
        this.placasTransporte = placasTransporte;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFolioCliente() {
        return folioCliente;
    }

    public void setFolioCliente(String folioCliente) {
        this.folioCliente = folioCliente;
    }

    public BigDecimal getValorDeclarado() {
        return valorDeclarado;
    }

    public void setValorDeclarado(BigDecimal valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public List<Partida> getPartidaList() {
        return partidaList;
    }

    public void setPartidaList(List<Partida> partidaList) {//modificar para mappedby 
        this.partidaList = partidaList;
        for (Partida p : partidaList) {
            p.setConstanciaDeposito(this);
        }
    }

    public List<ConstanciaDepositoDetalle> getConstanciaDepositoDetalleList() {
        return constanciaDepositoDetalleList;
    }

    public void setConstanciaDepositoDetalleList(List<ConstanciaDepositoDetalle> constanciaDepositoDetalleList) {
        this.constanciaDepositoDetalleList = constanciaDepositoDetalleList;
        for (ConstanciaDepositoDetalle c : constanciaDepositoDetalleList) {
            c.setConstanciaDeposito(this);
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Aviso getAvisoCve() {
        return avisoCve;
    }

    public void setAvisoCve(Aviso avisoCve) {
        this.avisoCve = avisoCve;
    }

    public EstadoConstancia getStatus() {
        return status;
    }

    public void setStatus(EstadoConstancia status) {
        this.status = status;
    }

    public List<ConstanciaFactura> getConstanciaFacturaList() {
        return constanciaFacturaList;
    }

    public void setConstanciaFacturaList(List<ConstanciaFactura> constanciaFacturaList) {
        this.constanciaFacturaList = constanciaFacturaList;
    }

    @Override
    public int hashCode() {
        if (this.folio == null) {
            return System.identityHashCode(this);
        }
        return Objects.hash(this.folio);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConstanciaDeposito)) {
            return false;
        }
        ConstanciaDeposito other = (ConstanciaDeposito) object;
        if ((this.folio == null && other.folio != null) || (this.folio != null && !this.folio.equals(other.folio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.ConstanciaDeposito[ folio=" + folio + " ]";
    }

}
