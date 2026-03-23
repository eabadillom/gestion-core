package com.ferbo.gestion.core.model;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "unidad_de_producto")
@NamedQueries({
    @NamedQuery(name = "UnidadProducto.findAll", query = "SELECT u FROM UnidadProducto u"),
    @NamedQuery(name = "UnidadProducto.findById", query = "SELECT u FROM UnidadProducto u WHERE u.id = :idUP"),
    @NamedQuery(name = "UnidadProducto.findByIdUnidadProducto", query = "SELECT u FROM UnidadProducto u WHERE u.producto.id = :idProducto AND u.unidadManejo.id = :idUnidadManejo"),
    @NamedQuery(name = "UnidadProducto.findByIdProducto", query = "SELECT u FROM UnidadProducto u WHERE u.id = :idProducto"),
    @NamedQuery(name = "UnidadProducto.findByCliente", query = "SELECT udp FROM UnidadProducto udp JOIN udp.producto p JOIN udp.unidadManejo udm JOIN p.productoPorClienteList ppc WHERE ppc.cliente.id = :idCliente ")
})
public class UnidadProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UNIDAD_DE_PRODUCTO_CVE")
    private Integer id;
    
    // @Basic(optional = false)
    // @NotNull
    // @Column(name = "PRODUCTO_CVE")
    // private int productoCve;
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
        return "mx.com.ferbo.model.UnidadProducto[ unidadDeProductoCve=" + id + " ]";
    }

}
