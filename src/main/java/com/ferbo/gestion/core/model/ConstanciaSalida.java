package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
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
@Table(name = "constancia_salida")
@NamedQuery(name = "ConstanciaSalida.findByNumero", query = "SELECT c FROM ConstanciaSalida c WHERE c.numero = :numero")
@NamedQuery(name = "ConstanciaSalida.findByFolioDeposito", query = "SELECT cs FROM ConstanciaDeposito cdd INNER JOIN cdd.partidaList p INNER JOIN p.detalleConstanciaSalidaList dcs INNER JOIN dcs.constancia cs WHERE cdd.folio = :folio")
public class ConstanciaSalida implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    private LocalDate fecha;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NUMERO")
    private String numero;

    @Size(max = 150)
    @Column(name = "NOMBRE_CTE")
    private String nombreCliente;

    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne
    private StatusConstanciaSalida status;

    @Size(max = 75)
    @Column(name = "OBSERVACIONES")
    private String observaciones;

    @NotNull
    @Size(max = 100)
    @Column(name = "nombre_transportista")
    private String nombreTransportista;

    @NotNull
    @Size(max = 10)
    @Column(name = "placas_transporte")
    private String placasTransporte;

    @NotNull
    @Column(name = "status_termo")
    private Boolean statusTermo;

    @NotNull
    @Column(name = "temp_transporte")
    private BigDecimal temperatura;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "constancia")
    private List<DetalleConstanciaSalida> detalles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "constanciaSalida")
    private List<ConstanciaSalidaServicio> servicios;

    @JoinColumn(name = "CLIENTE_CVE", referencedColumnName = "CTE_CVE")
    @ManyToOne(optional = false)
    private Cliente cliente;

    public ConstanciaSalida() {
    }

    public ConstanciaSalida(Integer id) {
        this.id = id;
    }

    public ConstanciaSalida(Integer id, LocalDate fecha, String numero) {
        this.id = id;
        this.fecha = fecha;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombreCte() {
        return nombreCliente;
    }

    public void setNombreCte(String nombreCte) {
        this.nombreCliente = nombreCte;
    }

    public StatusConstanciaSalida getStatus() {
        return status;
    }

    public void setStatus(StatusConstanciaSalida status) {
        this.status = status;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public List<DetalleConstanciaSalida> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleConstanciaSalida> detalles) {
        this.detalles = detalles;
    }

    public List<ConstanciaSalidaServicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<ConstanciaSalidaServicio> servicios) {
        this.servicios = servicios;
    }

    public Cliente getClientee() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boolean getStatusTermo() {
        return statusTermo;
    }

    public void setStatusTermo(Boolean statusTermo) {
        this.statusTermo = statusTermo;
    }

    public BigDecimal getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(BigDecimal temperatura) {
        this.temperatura = temperatura;
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
        if (!(object instanceof ConstanciaSalida)) {
            return false;
        }
        ConstanciaSalida other = (ConstanciaSalida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.ConstanciaSalida[ id=" + id + " ]";
    }

}
