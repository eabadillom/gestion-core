package com.ferbo.gestion.core.model;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "constancia_traspaso")
@NamedQuery(name = "ConstanciaTraspaso.findByNumero", query = "SELECT c FROM ConstanciaTraspaso c WHERE c.numero = :numero")
public class ConstanciaTraspaso implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "numero")
    private String numero;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    private LocalDate fecha;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 500)
    @Column(name = "observacion")
    private String observacion;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nombreCliente")
    private String nombreCliente;
    
    @Size(max = 25)
    @Column(name = "fecha_cadena")
    private String fechaCadena;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "traspaso")
    private List<TraspasoServicio> servicios;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "traspaso")
    private List<TraspasoPartida> partidas;
    
    @JoinColumn(name = "cliente", referencedColumnName = "CTE_CVE")
    @ManyToOne(optional = false)
    private Cliente cliente;

    public ConstanciaTraspaso() {
    }

    public ConstanciaTraspaso(Integer id) {
        this.id = id;
    }

    public ConstanciaTraspaso(Integer id, String numero, LocalDate fecha, String observacion, String nombreCliente) {
        this.id = id;
        this.numero = numero;
        this.fecha = fecha;
        this.observacion = observacion;
        this.nombreCliente = nombreCliente;
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

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getFechaCadena() {
        return fechaCadena;
    }

    public void setFechaCadena(String fechaCadena) {
        this.fechaCadena = fechaCadena;
    }

    public List<TraspasoServicio> getServicios() {
        return servicios;
    }

    public void getServicios(List<TraspasoServicio> servicios) {
        this.servicios = servicios;
    }

    public List<TraspasoPartida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<TraspasoPartida> partidas) {
        this.partidas = partidas;
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
        if (!(object instanceof ConstanciaTraspaso)) {
            return false;
        }
        ConstanciaTraspaso other = (ConstanciaTraspaso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.ConstanciaTraspaso[ id=" + id + " ]";
    }
    
}
