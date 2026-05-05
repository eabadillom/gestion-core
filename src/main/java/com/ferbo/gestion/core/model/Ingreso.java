package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ingreso")
public class Ingreso implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ingreso")
    private Integer id;

    @Column(name = "folio")
    @NotNull
    @Size(min = 1, max = 8)
    private String folio;

    @Column(name = "fecha_hora")
    @NotNull
    private LocalDate fechaHora;

    @JoinColumn(name = "id_cliente", referencedColumnName = "CTE_CVE")
    @ManyToOne
    private Cliente cliente;

    @Column(name = "transportista")
    @Size(min = 1, max = 100)
    private String transportista;

    @Column(name = "placas")
    @Size(min = 1, max = 100)
    private String placas;

    @Column(name = "observaciones")
    @Size(min = 1, max = 100)
    private String observaciones;

    @JoinColumn(name = "id_contacto", referencedColumnName = "id_contacto")
    @ManyToOne
    private Contacto contacto;

    @JoinColumn(name = "status", referencedColumnName = "id_status")
    @ManyToOne
    private IngresoStatus status;

    public Ingreso() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTransportista() {
        return transportista;
    }

    public void setTransportista(String transportista) {
        this.transportista = transportista;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public IngresoStatus getStatus() {
        return status;
    }

    public void setStatus(IngresoStatus status) {
        this.status = status;
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
        if (!(object instanceof Ingreso)) {
            return false;
        }
        Ingreso other = (Ingreso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Ingreso [idIngreso=" + id + ", folio=" + folio 
                + ", fechaHora=" + fechaHora + ", transportista=" + transportista 
                + ", placas=" + placas + ", observaciones=" + observaciones + "]";
    }

}
