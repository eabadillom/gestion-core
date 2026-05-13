package com.ferbo.gestion.core.model.facturacion.detalle;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

import com.ferbo.gestion.core.model.facturacion.Factura;
import com.ferbo.gestion.core.model.inventario.entrada.ConstanciaDeposito;

@Entity
@Table(name = "constancia_factura")
@NamedQuery(name = "ConstanciaFactura.findByFolioVigenciaInicioVigenciaFin", query = "SELECT c FROM ConstanciaFactura c WHERE c.constanciaDeposito.id = :folio AND c.vigenciaInicio = :vigenciaInicio and c.vigenciaFin = :vigenciaFin")
public class ConstanciaFactura implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "FOLIO", referencedColumnName = "FOLIO")
    @ManyToOne(optional = false)
    private ConstanciaDeposito constanciaDeposito;

    @Size(max = 30)
    @Column(name = "folio_cliente")
    private String folioCliente;

    @Column(name = "vigencia_inicio")
    private LocalDate vigenciaInicio;

    @Column(name = "vigencia_fin")
    private LocalDate vigenciaFin;

    @Column(name = "planta_cve")
    private Integer idPlanta;
    
    @Size(max = 80)
    @Column(name = "planta_ds")
    private String nombrePlanta;

    @Size(max = 6)
    @Column(name = "planta_abrev")
    private String plantaAbrev;

    @Column(name = "camara_cve")
    private Integer idCamara;

    @Size(max = 80)
    @Column(name = "camara_ds")
    private String nombreCamara;

    @Size(max = 6)
    @Column(name = "camara_abrev")
    private String camaraAbrev;

    @ManyToOne
    @JoinColumn(name = "factura", referencedColumnName = "id")
    private Factura factura;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "constanciaFactura")
    private List<ServicioConstancia> serviciosConstancia;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "constanciaFactura")
    private List<ProductoConstancia> productosConstancia;

    public ConstanciaFactura() {
    }

    public ConstanciaFactura(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFolioCliente() {
        return folioCliente;
    }

    public void setFolioCliente(String folioCliente) {
        this.folioCliente = folioCliente;
    }

    public LocalDate getVigenciaInicio() {
        return vigenciaInicio;
    }

    public void setVigenciaInicio(LocalDate vigenciaInicio) {
        this.vigenciaInicio = vigenciaInicio;
    }

    public LocalDate getVigenciaFin() {
        return vigenciaFin;
    }

    public void setVigenciaFin(LocalDate vigenciaFin) {
        this.vigenciaFin = vigenciaFin;
    }

    public Integer getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(Integer idPlanta) {
        this.idPlanta = idPlanta;
    }

    public String getNombrePlanta() {
        return nombrePlanta;
    }

    public void setNombrePlanta(String nombrePlanta) {
        this.nombrePlanta = nombrePlanta;
    }

    public String getPlantaAbrev() {
        return plantaAbrev;
    }

    public Integer getIdCamara() {
        return idCamara;
    }

    public void setIdCamara(Integer idCamara) {
        this.idCamara = idCamara;
    }

    public void setCamaraCve(Integer camaraCve) {
        this.idCamara = camaraCve;
    }

    public String getNombreCamara() {
        return nombreCamara;
    }

    public void setNombreCamara(String nombreCamara) {
        this.nombreCamara = nombreCamara;
    }

    public String getCamaraAbrev() {
        return camaraAbrev;
    }

    public void setCamaraAbrev(String camaraAbrev) {
        this.camaraAbrev = camaraAbrev;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public List<ServicioConstancia> getServiciosConstancia() {
        return serviciosConstancia;
    }

    public void setServiciosConstancia(List<ServicioConstancia> serviciosConstancia) {
        this.serviciosConstancia = serviciosConstancia;
    }

    public List<ProductoConstancia> getProductosConstancia() {
        return productosConstancia;
    }

    public void setProductosConstancia(List<ProductoConstancia> productosConstancia) {
        this.productosConstancia = productosConstancia;
    }

    public ConstanciaDeposito getConstanciaDeposito() {
        return constanciaDeposito;
    }

    public void setConstanciaDeposito(ConstanciaDeposito constanciaDeposito) {
        this.constanciaDeposito = constanciaDeposito;
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
        if (!(object instanceof ConstanciaFactura)) {
            return false;
        }
        ConstanciaFactura other = (ConstanciaFactura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.ConstanciaFactura [id=" + id + ", folio=" + constanciaDeposito + ", folioCliente="
                + folioCliente + ", vigenciaInicio=" + vigenciaInicio + ", vigenciaFin=" + vigenciaFin + ", plantaCve="
                + idPlanta + ", plantaDs=" + nombrePlanta + ", plantaAbrev=" + plantaAbrev + ", camaraCve=" + idCamara
                + ", camaraDs=" + nombreCamara + ", camaraAbrev=" + camaraAbrev + ", factura=" + factura
                + ", servicioConstanciaList=" + serviciosConstancia + ", productoConstanciaList="
                + productosConstancia + "]";
    }
    
}
