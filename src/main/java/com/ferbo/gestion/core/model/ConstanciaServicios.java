package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "constancia_servicios")
@NamedQueries({
    @NamedQuery(name = "ConstanciaServicios.findAll", query = "SELECT c FROM ConstanciaServicios c"),
    @NamedQuery(name = "ConstanciaServicios.findById", query = "SELECT c FROM ConstanciaServicios c WHERE c.id = :idConstanciaSrv"),
    @NamedQuery(name = "ConstanciaServicios.findByFecha", query = "SELECT c FROM ConstanciaServicios c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "ConstanciaServicios.findByNumero", query = "SELECT c FROM ConstanciaServicios c WHERE c.numero = :numero"),
    @NamedQuery(name = "ConstanciaServicios.findByNombreCte", query = "SELECT c FROM ConstanciaServicios c WHERE c.nombreCte = :nombreCte"),
    @NamedQuery(name = "ConstanciaServicios.findByObservaciones", query = "SELECT c FROM ConstanciaServicios c WHERE c.observaciones = :observaciones"),
    @NamedQuery(name = "ConstanciaServicios.findByStatus", query = "SELECT c FROM ConstanciaServicios c WHERE c.status = :status")})
public class ConstanciaServicios implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @Size(max = 15)
    @Column(name = "NUMERO")
    private String numero;
    
    @Size(max = 150)
    @Column(name = "NOMBRE_CTE")
    private String nombreCte;
    
    @Size(max = 150)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    
    @Column(name = "STATUS")
    private Integer status;
    
    @OneToMany(mappedBy = "constancia")
    private List<DetalleConstanciaServicio> detalleConstanciaServicioList;
    
    @JoinColumn(name = "CLIENTE_CVE", referencedColumnName = "CTE_CVE")
    @ManyToOne
    private Cliente cliente;

    public ConstanciaServicios() {
    }

    public ConstanciaServicios(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombreCte() {
        return nombreCte;
    }

    public void setNombreCte(String nombreCte) {
        this.nombreCte = nombreCte;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<DetalleConstanciaServicio> getDetalleConstanciaServicioList() {
        return detalleConstanciaServicioList;
    }

    public void setDetalleConstanciaServicioList(List<DetalleConstanciaServicio> detalleConstanciaServicioList) {
        this.detalleConstanciaServicioList = detalleConstanciaServicioList;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        if (!(object instanceof ConstanciaServicios)) {
            return false;
        }
        ConstanciaServicios other = (ConstanciaServicios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.ConstanciaServicios[ id=" + id + " ]";
    }
    
}
