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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "nota_credito")
@NamedQuery(name = "NotaCredito.findByPeriodoCliente", query = "SELECT n FROM NotaCredito n WHERE (n.fecha BETWEEN :fechaInicio AND :fechaFin) AND (n.idcliente = :idCliente OR :idCliente IS NULL) ORDER BY n.fecha ASC")
public class NotaCredito implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NUMERO")
    private String numero;
    
    @ManyToOne
    @JoinColumn(name = "IDCLIENTE")
    private Cliente cliente;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CLIENTE")
    private String nombreCliente;
    
    @Size(max = 255)
    @Column(name = "DOMICILIO")
    private String domicilio;
    
    @Size(max = 20)
    @Column(name = "RFC")
    private String rfc;
    
    @Column(name = "SUBTOTAL")
    private BigDecimal subtotal;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IVA")
    private BigDecimal iva;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL")
    private BigDecimal total;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TOTAL_LETRA")
    private String importeLetra;
    
    @Size(max = 50)
    @Column(name = "SERVICIOS")
    private String servicios;
    
    @Size(max = 15)
    @Column(name = "CONSTANCIA")
    private String constancia;
    
    @Size(max = 20)
    @Column(name = "PERIODO")
    private String periodo;
    
    @Size(max = 200)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    private LocalDate fecha;
    
    @Size(max = 40)
    @Column(name = "CAJERO")
    private String cajero;
    
    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "nota")
    private CancelaNotaCredito cancela;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "notaPorFacturaPK.nota",fetch = FetchType.LAZY)
    private List<NotaPorFactura> notasFactura;
    
    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private StatusNotaCredito status;

    public NotaCredito() {
    }

    public NotaCredito(Integer id) {
        this.id = id;
    }

    public NotaCredito(Integer id, String numero, String cliente, BigDecimal iva, BigDecimal total, String importeLetra, LocalDate fecha) {
        this.id = id;
        this.numero = numero;
        this.nombreCliente = cliente;
        this.iva = iva;
        this.total = total;
        this.importeLetra = importeLetra;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getImporteLetra() {
        return importeLetra;
    }

    public void setImporteLetra(String importeLetra) {
        this.importeLetra = importeLetra;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getConstancia() {
        return constancia;
    }

    public void setConstancia(String constancia) {
        this.constancia = constancia;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCajero() {
        return cajero;
    }

    public void setCajero(String cajero) {
        this.cajero = cajero;
    }

    public CancelaNotaCredito getCancela() {
        return this.cancela;
    }

    public void setCancela(CancelaNotaCredito cancela) {
        this.cancela = cancela;
    }

    public StatusNotaCredito getStatus() {
        return status;
    }

    public void setStatus(StatusNotaCredito status) {
        this.status = status;
    }

    public List<NotaPorFactura> getNotas() {
        return notasFactura;
    }

    public void setNotaFacturaList(List<NotaPorFactura> notaFacturaList) {
            this.notasFactura = notaFacturaList;
    }

    @Override
    public int hashCode() {
    	if(this.id == null)
    		return System.identityHashCode(this);
    	return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaCredito)) {
            return false;
        }
        NotaCredito other = (NotaCredito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.NotaCredito[ id=" + id + " ]";
    }
    
}
