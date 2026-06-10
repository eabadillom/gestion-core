package com.ferbo.gestion.core.model.facturacion.detalle;

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
@Table(name = "producto_constancia")
public class ProductoConstancia implements Serializable 
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
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "catidad_cobro")
    private BigDecimal peso;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "unidad_cobro")
    private String unidadPeso;
    
    @Column(name = "cantidad_manejo")
    private BigDecimal cantidad;
    
    @Size(max = 255)
    @Column(name = "unidad_manejo")
    private String unidadManejo;
    
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
    
    @Size(max = 80)
    @Column(name = "camara_ds")
    private String camaraDs;
    
    @Size(max = 6)
    @Column(name = "camara_abrev")
    private String camaraAbrev;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "constancia", referencedColumnName = "id")
    private ConstanciaFactura constanciaFactura;

    public ProductoConstancia() {
    }

    public ProductoConstancia(Integer id) {
        this.id = id;
    }

    public ProductoConstancia(Integer id, String descripcion, int constancia, BigDecimal peso, String unidadCobro) {
        this.id = id;
        this.descripcion = descripcion;
        this.peso = peso;
        this.unidadPeso = unidadCobro;
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

    public BigDecimal getCatidadCobro() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getUnidadPeso() {
        return unidadPeso;
    }

    public void setUnidadPeso(String unidadPeso) {
        this.unidadPeso = unidadPeso;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadManejo() {
        return unidadManejo;
    }

    public void setUnidadManejo(String unidadManejo) {
        this.unidadManejo = unidadManejo;
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
    
    public ConstanciaFactura getConstanciaFactura() {
		return constanciaFactura;
	}

	public void setConstanciaFactura(ConstanciaFactura constanciaFactura) {
		this.constanciaFactura = constanciaFactura;
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
        if (!(object instanceof ProductoConstancia)) {
            return false;
        }
        ProductoConstancia other = (ProductoConstancia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.ProductoConstancia[ id=" + id + " ]";
    }
    
}
