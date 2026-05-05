package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "constancia_de_deposito")
@NamedQuery(name = "ConstanciaDeposito.findByIdCliente", query = "SELECT c FROM ConstanciaDeposito c WHERE c.cliente.id = :idCliente")
@NamedQuery(name = "ConstanciaDeposito.findByFolioCliente", query = "SELECT c FROM ConstanciaDeposito c WHERE c.folioCliente = :folioCliente")
public class ConstanciaDeposito implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FOLIO")
    private Integer id;

    @Column(name = "FECHA_INGRESO")
    private LocalDate fechaIngreso;

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
    private List<Partida> partidas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "constanciaDeposito")
    private List<ConstanciaDepositoDetalle> servicios;

    @JoinColumn(name = "CTE_CVE", referencedColumnName = "CTE_CVE", nullable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;

    @JoinColumn(name = "aviso_cve", referencedColumnName = "aviso_cve", nullable = false)
    @ManyToOne
    private Aviso aviso;

    @JoinColumn(name = "status", referencedColumnName = "edo_cve", nullable = false)
    @ManyToOne
    private EstadoConstancia status;

    public ConstanciaDeposito() {
    }

    public ConstanciaDeposito(Integer folio) {
        this.id = folio;
    }

    public ConstanciaDeposito(Integer folio, String folioCliente) {
        this.id = folio;
        this.folioCliente = folioCliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
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

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {//modificar para mappedby 
        this.partidas = partidas;
        for (Partida p : partidas) {
            p.setConstanciaDeposito(this);
        }
    }

    public List<ConstanciaDepositoDetalle> getServicios() {
        return servicios;
    }

    public void setServicios(List<ConstanciaDepositoDetalle> servicios) {
        this.servicios = servicios;
        for (ConstanciaDepositoDetalle servicio : servicios) {
            servicio.setConstancia(this);
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    public EstadoConstancia getStatus() {
        return status;
    }

    public void setStatus(EstadoConstancia status) {
        this.status = status;
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
        if (!(object instanceof ConstanciaDeposito)) {
            return false;
        }
        ConstanciaDeposito other = (ConstanciaDeposito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.ConstanciaDeposito[ folio=" + id + " ]";
    }

}
