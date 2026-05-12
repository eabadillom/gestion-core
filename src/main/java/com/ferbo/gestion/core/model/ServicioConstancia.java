package com.ferbo.gestion.core.model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "servicio_constancia")
public class ServicioConstancia implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "baseCargo")
    private BigDecimal cantidad;
    
    @Column(name = "tarifa")
    private BigDecimal precioUnitario;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private BigDecimal subtotal;
    
    @Column(name = "planta_cve")
    private Integer plantaCve;
    
    @Size(max = 80)
    @Column(name = "planta_ds")
    private String plantaDs;
    
    @Size(max = 6)
    @Column(name = "planta_abrev")
    private String plantaAbrev;
    
    @Column(name = "camara_cve")
    private Integer camaraCve;
    
    @Column(name = "camara_ds")
    @Size(max = 80)
    private String camaraDs;
    
    @Column(name = "camara_abrev")
    @Size(max = 80)
    private String camaraAbrev;
    
    @Size(max = 20)
    @Column(name = "unidad_medida")
    private String unidadMedida;
    
    @Size(max = 20)
    @Column(name = "codigo")
    private String codigo;
    
    @Size(max = 10)
    @Column(name = "planta_cod")
    private String plantaCod;
    
    @Size(max = 5)
    @Column(name = "cd_unidad")
    private String cdUnidad;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "constancia", referencedColumnName = "id")
    private ConstanciaFactura constanciaFactura;

    public ServicioConstancia() {
    }

    public ServicioConstancia(Integer id) {
        this.id = id;
    }

    public ServicioConstancia(Integer id, String descripcion, BigDecimal costo) {
        this.id = id;
        this.descripcion = descripcion;
        this.subtotal = costo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ConstanciaFactura getConstanciaFactura() {
        return constanciaFactura;
    }

    public void setConstanciaFactura(ConstanciaFactura constanciaFactura) {
        this.constanciaFactura = constanciaFactura;
    }

    public BigDecimal getCantidad() {
    	return cantidad;
    }
    
    public void setCantidad(BigDecimal cantidad) {
    	this.cantidad = cantidad;
    }
    
    public BigDecimal getPrecioUnitario() {
    	return precioUnitario;
    }
    
    public void setPrecioUnitario(BigDecimal precioUnitario) {
    	this.precioUnitario = precioUnitario;
    }

    public BigDecimal getSubtotal() {
    	return subtotal;
    }
    
    public void setSubtotal(BigDecimal subtotal) {
    	this.subtotal = subtotal;
    }

    public Integer getPlantaCve() {
        return plantaCve;
    }

    public void setPlantaCve(Integer plantaCve) {
        this.plantaCve = plantaCve;
    }

    public String getPlantaDs() {
        return plantaDs;
    }

    public void setPlantaDs(String plantaDs) {
        this.plantaDs = plantaDs;
    }

    public String getPlantaAbrev() {
        return plantaAbrev;
    }

    public void setPlantaAbrev(String plantaAbrev) {
        this.plantaAbrev = plantaAbrev;
    }

    public Integer getCamaraCve() {
        return camaraCve;
    }

    public void setCamaraCve(Integer camaraCve) {
        this.camaraCve = camaraCve;
    }

    public String getCamaraDs() {
        return camaraDs;
    }

    public void setCamaraDs(String camaraDs) {
        this.camaraDs = camaraDs;
    }

    public String getCamaraAbrev() {
        return camaraAbrev;
    }

    public void setCamaraAbrev(String camaraAbrev) {
        this.camaraAbrev = camaraAbrev;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPlantaCod() {
        return plantaCod;
    }

    public void setPlantaCod(String plantaCod) {
        this.plantaCod = plantaCod;
    }

    public String getCdUnidad() {
        return cdUnidad;
    }

    public void setCdUnidad(String cdUnidad) {
        this.cdUnidad = cdUnidad;
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
        if (!(object instanceof ServicioConstancia)) {
            return false;
        }
        ServicioConstancia other = (ServicioConstancia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.ServicioConstancia[ id=" + id + " ]";
    }
    
}
