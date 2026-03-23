package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.id = :idProducto"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Producto.findByNumeroProd", query = "SELECT p FROM Producto p WHERE p.numeroProd = :numeroProd"),
    @NamedQuery(name = "Producto.findByCategoria", query = "SELECT p FROM Producto p WHERE p.categoria = :categoria"),
    @NamedQuery(name = "Producto.findByCliente", query = "SELECT p FROM Producto p JOIN p.productoPorClienteList ppc WHERE ppc.cliente.id = :idCliente ORDER BY p.descripcion ASC")
})
public class Producto implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUCTO_CVE")
    private Integer id;

    @Size(max = 80)
    @Column(name = "PRODUCTO_DS")
    private String descripcion;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NUMERO_PROD")
    private String numeroProd;

    @Basic(optional = false)
    @NotNull
    @Column(name = "categoria")
    private int categoria;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.PERSIST}, mappedBy = "producto")
    private List<ProductoPorCliente> productoPorClienteList;

    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(Integer id, String numeroProd, int categoria) {
        this.id = id;
        this.numeroProd = numeroProd;
        this.categoria = categoria;
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

    public String getNumeroProd() {
        return numeroProd;
    }

    public void setNumeroProd(String numeroProd) {
        this.numeroProd = numeroProd;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public List<ProductoPorCliente> getProductoPorClienteList() {
        return productoPorClienteList;
    }

    public void setProductoPorClienteList(List<ProductoPorCliente> productoPorClienteList) {
        this.productoPorClienteList = productoPorClienteList;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.Producto[ id=" + id + " ]";
    }
    
}
