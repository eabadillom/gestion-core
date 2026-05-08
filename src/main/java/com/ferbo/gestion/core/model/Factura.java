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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "factura")
public class Factura implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    /* * * * * * * * * * * * * Datos generales de la factura * * * * * * * * * * * * * */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "nom_serie")
    private String serie;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "numero")
    private String numero;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "moneda")
    private String moneda;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    private LocalDate fecha;

    @Basic(optional = false)
    @Column(name = "observacion")
    private String observacion;

    @Basic(optional = false)
    @NotNull
    @Column(name = "subtotal")
    private BigDecimal subtotal;

    @Basic(optional = false)
    @NotNull
    @Column(name = "iva")
    private BigDecimal iva;

    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private BigDecimal total;
    
    @Column(name = "valor_declarado")
    private BigDecimal valorDeclarado;

    @Column(name = "inicio_servicios")
    private LocalDate inicioServicios;

    @Column(name = "fin_servicios")
    private LocalDate finServicios;

    @Size(max = 255)
    @Column(name = "monto_letra")
    private String importeLetra;

    @JoinColumn(name = "tipo_facturacion", referencedColumnName = "ID")
    @ManyToOne
    private TipoFacturacion tipoFacturacion;

    @JoinColumn(name = "planta", referencedColumnName = "PLANTA_CVE")
    @ManyToOne
    private Planta planta;

    @Basic(optional = false)
    @NotNull
    @Column(name = "plazo")
    private int plazo;

    @Column(name = "retencion")
    private BigDecimal retencion;

    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje_iva")
    private BigDecimal porcentajeIva;
    
    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne
    private StatusFactura status;

    @Size(max = 5)
    @Column(name = "metodo_pago")
    private String metodoPago;

    /* * * * * * * * * * * Datos del receptor * * * * * * * * * * * */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "rfc")
    private String rfc;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Size(max = 30)
    @Column(name = "numero_cliente")
    private String numeroCliente;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "pais")
    private String pais;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "estado")
    private String estado;

    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 30)
    @Column(name = "municipio")
    private String municipio;

    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 30)
    @Column(name = "ciudad")
    private String ciudad;

    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 150)
    @Column(name = "colonia")
    private String colonia;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "cp")
    private String codigoPostal;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "calle")
    private String calle;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "num_ext")
    private String numeroExterior;

    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 50)
    @Column(name = "num_int")
    private String numeroInterior;

    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 10)
    @Column(name = "telefono")
    private String telefono;

    @Size(max = 10)
    @Column(name = "fax")
    private String fax;
    
    @JoinColumn(name = "cliente", referencedColumnName = "CTE_CVE")
    @ManyToOne
    private Cliente cliente;

    @Size(max = 1)
    @Column(name = "tp_persona")
    private String tipoPersona;

    @Size(max = 5)
    @Column(name = "cd_regimen")
    private String regimenFiscal;

    @Size(max = 5)
    @Column(name = "cd_uso_cfdi")
    private String usoCfdi;

    @Size(max = 50)
    @Column(name = "uuid")
    private String uuid;

    /* * * * * * * * * * * * * * DATOS DEL EMISOR * * * * * * * * * * * * * * */
    @Size(max = 80)
    @Column(name = "emi_nombre")
    private String emisorNombre;
    
    @Size(max = 14)
    @Column(name = "emi_rfc")
    private String emisorRFC;

    @Size(max = 5)
    @Column(name = "emi_cd_regimen")
    private String emisorRegimen;

    @Column(name = "nb_lugar_exp")
    @Size(max = 5)
    @Basic(optional = true)
    private String lugarExpedicion;

    /* * * * * * * * * * * * * * * Otros atributos * * * * * * * * * * * * * * */
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "factura")
    private List<Pago> pagoList;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "key.factura")
    private List<FacturaMedioPago> facturaMedioPagoList;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "factura")
    private List<ServicioFactura> servicioFacturaList;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "factura")
    private List<ConstanciaFacturaDs> constanciaFacturaDsList;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "factura")
    private List<ConstanciaFactura> constanciaFacturaList;

    @OneToMany(mappedBy = "notaPorFacturaPK.factura")
    private List<NotaPorFactura> notaFacturaList;

    @OneToOne(cascade = {CascadeType.MERGE}, mappedBy = "factura")
    private Cfdi cfdi;

    @OneToOne(cascade = {CascadeType.MERGE}, mappedBy = "factura")
    private CancelaFactura cancelaFactura;

    public Factura() {
    }

    public Factura(Integer id) {
        this.id = id;
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

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public BigDecimal getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(BigDecimal porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public BigDecimal getValorDeclarado() {
        return valorDeclarado;
    }

    public void setValorDeclarado(BigDecimal valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }

    public LocalDate getInicioServicios() {
        return inicioServicios;
    }

    public void setInicioServicios(LocalDate inicioServicios) {
        this.inicioServicios = inicioServicios;
    }

    public LocalDate getFinServicios() {
        return finServicios;
    }

    public void setFinServicios(LocalDate finServicios) {
        this.finServicios = finServicios;
    }

    public String getImporteLetra() {
        return importeLetra;
    }

    public void setImporteLetra(String importeLetra) {
        this.importeLetra = importeLetra;
    }

    public TipoFacturacion getTipoFacturacion() {
        return tipoFacturacion;
    }

    public void setTipoFacturacion(TipoFacturacion tipoFacturacion) {
        this.tipoFacturacion = tipoFacturacion;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public BigDecimal getRetencion() {
        return retencion;
    }

    public void setRetencion(BigDecimal retencion) {
        this.retencion = retencion;
    }

    public String getNomSerie() {
        return serie;
    }

    public void setNomSerie(String nomSerie) {
        this.serie = nomSerie;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusFactura getStatus() {
        return status;
    }

    public void setStatus(StatusFactura status) {
        this.status = status;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getCdRegimen() {
        return regimenFiscal;
    }

    public void setCdRegimen(String cdRegimen) {
        this.regimenFiscal = cdRegimen;
    }

    public String getCdUsoCfdi() {
        return usoCfdi;
    }

    public void setCdUsoCfdi(String cdUsoCfdi) {
        this.usoCfdi = cdUsoCfdi;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmisorNombre() {
        return emisorNombre;
    }

    public void setEmisorNombre(String emisorNombre) {
        this.emisorNombre = emisorNombre;
    }

    public String getEmisorRFC() {
        return emisorRFC;
    }

    public void setEmisorRFC(String emisorRFC) {
        this.emisorRFC = emisorRFC;
    }

    public String getEmisorCdRegimen() {
        return emisorRegimen;
    }

    public void setEmisorCdRegimen(String emisorCdRegimen) {
        this.emisorRegimen = emisorCdRegimen;
    }

    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }

    public List<FacturaMedioPago> getFacturaMedioPagoList() {
        return facturaMedioPagoList;
    }

    public void setFacturaMedioPagoList(List<FacturaMedioPago> facturaMedioPagoList) {
        this.facturaMedioPagoList = facturaMedioPagoList;
    }

    public List<ServicioFactura> getServicioFacturaList() {
        return servicioFacturaList;
    }

    public void setServicioFacturaList(List<ServicioFactura> servicioFacturaList) {
        this.servicioFacturaList = servicioFacturaList;
    }

    public List<ConstanciaFacturaDs> getConstanciaFacturaDsList() {
        return constanciaFacturaDsList;
    }

    public void setConstanciaFacturaDsList(List<ConstanciaFacturaDs> constanciaFacturaDsList) {
        this.constanciaFacturaDsList = constanciaFacturaDsList;
    }

    public List<ConstanciaFactura> getConstanciaFacturaList() {
        return constanciaFacturaList;
    }

    public void setConstanciaFacturaList(List<ConstanciaFactura> constanciaFacturaList) {
        this.constanciaFacturaList = constanciaFacturaList;
    }

    public List<NotaPorFactura> getNotaFacturaList() {
        return notaFacturaList;
    }

    public void setNotaFacturaList(List<NotaPorFactura> notaFacturaList) {
        this.notaFacturaList = notaFacturaList;
    }

    public Cfdi getCfdi() {
        return cfdi;
    }

    public void setCfdi(Cfdi cfdi) {
        this.cfdi = cfdi;
    }

    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    public void setLugarExpedicion(String emisorCodigoPostal) {
        this.lugarExpedicion = emisorCodigoPostal;
    }

    public CancelaFactura getCancelaFactura() {
        return cancelaFactura;
    }

    public void setCancelaFactura(CancelaFactura cancelaFactura) {
        this.cancelaFactura = cancelaFactura;
    }
    
    @Override
    public int hashCode() {
    	if(this.id == null)
    		return System.identityHashCode(this);
    	return Objects.hashCode(this.id);
    }
    
    @Override
    public boolean equals(Object object) {
    	// TODO: Warning - this method won't work in the case the id fields are not set
    	if (!(object instanceof Factura)) {
    		return false;
    	}
    	Factura other = (Factura) object;
    	if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
    		return false;
    	}
    	return true;
    }
    
    @Override
    public String toString() {
    	return "com.ferbo.gestion.core.model.Factura[ id=" + id + " ]";
    }
    
}
