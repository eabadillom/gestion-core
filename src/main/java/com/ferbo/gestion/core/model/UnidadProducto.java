package com.ferbo.gestion.core.model;

<<<<<<< Updated upstream
public class UnidadProducto {
	private Integer idUnidadProducto = null;
	private Integer idProducto = null;
	private Integer idUnidadManejo;
	private Producto producto = null;
	private UnidadManejo unidadManejo = null;
	
	public Integer getIdUnidadProducto() {
		return idUnidadProducto;
	}
	public void setIdUnidadProducto(Integer idUnidadProducto) {
		this.idUnidadProducto = idUnidadProducto;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public Integer getIdUnidadManejo() {
		return idUnidadManejo;
	}
	public void setIdUnidadManejo(Integer idUnidadManejo) {
		this.idUnidadManejo = idUnidadManejo;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public UnidadManejo getUnidadManejo() {
		return unidadManejo;
	}
	public void setUnidadManejo(UnidadManejo unidadManejo) {
		this.unidadManejo = unidadManejo;
	}
	
=======
import java.io.Serializable;
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

@Entity
@Table(name = "unidad_de_producto")
public class UnidadProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UNIDAD_DE_PRODUCTO_CVE")
    private Integer id;
    
    @JoinColumn(name = "UNIDAD_DE_MANEJO_CVE", referencedColumnName = "UNIDAD_DE_MANEJO_CVE")
    @ManyToOne(optional = false)
    private UnidadManejo unidadManejo;

    @JoinColumn(name = "PRODUCTO_CVE", referencedColumnName = "PRODUCTO_CVE")
    @ManyToOne(optional = false)
    private Producto producto;

    public UnidadProducto() {
    }

    public UnidadProducto(Integer id) {
        this.id = id;
    }

    public UnidadProducto(Integer id, int productoCve) {
        this.id = id;
        this.producto = new Producto();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UnidadManejo getUnidadeManejo() {
        return unidadManejo;
    }

    public void setUnidadManejo(UnidadManejo unidadManejo) {
        this.unidadManejo = unidadManejo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
        if (!(object instanceof UnidadProducto)) {
            return false;
        }
        UnidadProducto other = (UnidadProducto) object;
        if ((this.id == null && other.id != null)
                || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.UnidadProducto[ unidadDeProductoCve=" + id + " ]";
    }
>>>>>>> Stashed changes

}
