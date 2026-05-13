package com.ferbo.gestion.core.model.inventario.servicio;

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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ferbo.gestion.core.model.cliente.Cliente;
import com.ferbo.gestion.core.model.facturacion.detalle.ConstanciaFacturaDs;
import com.ferbo.gestion.core.model.inventario.EstadoConstancia;

@Entity
@Table(name = "constancia_de_servicio")
@NamedQuery(name = "ConstanciaServicio.findByFolioCliente", query = "SELECT c FROM ConstanciaServicio c WHERE c.folioCliente = :folioCliente")
public class ConstanciaServicio implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FOLIO")
    private Integer folio;
    
    @Column(name = "FECHA")
    private LocalDate fecha;
    
    @Size(max = 100)
    @Column(name = "NOMBRE_TRANSPORTISTA")
    private String nombreTransportista;
    
    @Size(max = 8)
    @Column(name = "PLACAS_TRANSPORTE")
    private String placasTransporte;
    
    @Size(max = 200)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "FOLIO_CLIENTE")
    private String folioCliente;
    
    @Column(name = "VALOR_DECLARADO")
    private BigDecimal valorDeclarado;
    
    @OneToMany(mappedBy = "constanciaServicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PartidaServicio> partidas;
    
    @JoinColumn(name = "CTE_CVE", referencedColumnName = "CTE_CVE")
    @ManyToOne
    private Cliente cliente;
    
    @JoinColumn(name = "STATUS", referencedColumnName = "edo_cve")
    @ManyToOne
    private EstadoConstancia status;
    
    @OneToMany(mappedBy = "constancia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConstanciaServicioDetalle> servicios;
    
    @Deprecated
    @OneToMany(mappedBy = "constanciaServicio", orphanRemoval = true)
    private List<ConstanciaFacturaDs> constanciaFacturaDsList;
    
    public ConstanciaServicio() {
    }

    public ConstanciaServicio(Integer folio) {
        this.folio = folio;
    }

    public ConstanciaServicio(Integer folio, String folioCliente) {
        this.folio = folio;
        this.folioCliente = folioCliente;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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

    public List<PartidaServicio> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<PartidaServicio> partidas) {
        this.partidas = partidas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoConstancia getStatus() {
        return status;
    }

    public void setStatus(EstadoConstancia status) {
        this.status = status;
    }

    public List<ConstanciaServicioDetalle> getServicios() {
        return servicios;
    }

    public void setServicios(List<ConstanciaServicioDetalle> servicios) {
        this.servicios = servicios;
    }
    
    @Deprecated
    public List<ConstanciaFacturaDs> getConstanciaFacturaDsList() {
        return constanciaFacturaDsList;
    }
    
    @Deprecated
    public void setConstanciaFacturaDsList(List<ConstanciaFacturaDs> constanciaFacturaDsList) {
        this.constanciaFacturaDsList = constanciaFacturaDsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (folio != null ? folio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConstanciaServicio)) {
            return false;
        }
        ConstanciaServicio other = (ConstanciaServicio) object;
        if ((this.folio == null && other.folio != null) || (this.folio != null && !this.folio.equals(other.folio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.ConstanciaDeServicio[ folio=" + folio + " ]";
    }
    
}
