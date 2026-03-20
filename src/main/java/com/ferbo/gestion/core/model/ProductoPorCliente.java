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
@Table(name = "producto_por_cliente")
@NamedQueries({
    @NamedQuery(name = "ProductoPorCliente.findAll", query = "SELECT p FROM ProductoPorCliente p"),
    @NamedQuery(name = "ProductoPorCliente.findByProdXCte", query = "SELECT p FROM ProductoPorCliente p WHERE p.id = :idProducto AND p.cliente.id = :idCliente"),
    @NamedQuery(name = "ProductoPorCliente.findByProducto", query = "SELECT p FROM ProductoPorCliente p WHERE p.producto.id = :idProducto"),
    @NamedQuery(name = "ProductoPorCliente.findByCliente", query = "SELECT p FROM ProductoPorCliente p WHERE p.cliente.id = :idCliente"),
    @NamedQuery(name = "ProductoPorCliente.findByClienteOrderByProducto", query = "SELECT p FROM ProductoPorCliente p WHERE p.cliente.id = :idCliente ORDER BY p.producto.descripcion")
})
public class ProductoPorCliente implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PROD_X_CTE_CVE")
    private Integer id;

    @JoinColumn(name = "CTE_CVE", referencedColumnName = "CTE_CVE")
    @ManyToOne(optional = false)
    private Cliente cliente;

    @JoinColumn(name = "PRODUCTO_CVE", referencedColumnName = "PRODUCTO_CVE")
    @ManyToOne(optional = false)
    private Producto producto;

    public ProductoPorCliente() {
    }

    public ProductoPorCliente(Integer id) {
        this.id = id;
    }

    public ProductoPorCliente(Cliente cliente) {//nuevo
        this.cliente = cliente;
    }

    public Integer getProdXCteCve() {
        return id;
    }

    public void setProdXCteCve(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoPorCliente)) {
            return false;
        }
        ProductoPorCliente other = (ProductoPorCliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.ProductoPorCliente[ id=" + id + " ]";
    }

}
