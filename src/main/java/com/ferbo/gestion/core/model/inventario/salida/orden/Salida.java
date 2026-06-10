package com.ferbo.gestion.core.model.inventario.salida.orden;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
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

import com.ferbo.gestion.core.model.cliente.Cliente;
import com.ferbo.gestion.core.model.cliente.contacto.Contacto;

@Entity
@Table(name = "salida")
@NamedQuery(name = "Salida.findByFolioSalida", query = "SELECT s FROM Salida s WHERE s.folio = :folioSalida")
@NamedQuery(name = "Salida.findByCliente", query = "SELECT s FROM Salida s INNER JOIN s.status st INNER JOIN s.cliente cl WHERE cl.id = :idCliente AND st.clave = :clave AND s.fechaSalida = :fechaSalida")
@NamedQuery(name = "Salida.findByParametros", query = "SELECT s FROM Salida s INNER JOIN s.status st INNER JOIN s.cliente cl WHERE st.clave = :clave AND s.fechaSalida = :fechaSalida AND cl.id = :idCliente")
public class Salida implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_salida")
    private Integer id;
    
    @Size(max = 15)
    @Column(name = "cd_folio_salida")
    private String folio;
    
    @ManyToOne
    @JoinColumn(name = "cliente_cve", referencedColumnName = "CTE_CVE")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_contacto", referencedColumnName = "id_contacto")
    private Contacto contacto;
    
    @ManyToOne
    @JoinColumn(name = "cd_status", referencedColumnName = "cd_status")
    private StatusSalida status;
    
    @Size(max = 10)
    @Column(name = "nb_placas_transporte")
    private String placasTransporte;
    
    @Size(max = 100)
    @Column(name = "nb_nombre_transportista")
    private String nombreTransportista;
    
    @Size(max = 10)
    @Column(name = "nb_observaciones")
    private String observaciones;
    
    @Column(name = "fh_salida")
    private LocalDate fechaSalida;
    
    @Column(name = "tm_salida")
    private LocalTime horaSalida;
    
    @Column(name = "fh_registro")
    private LocalDate fechaRegistro;
    
    @Column(name = "fh_modificacion")
    private LocalDate fechaModificacion;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "salida")
    private List<SalidaDetalle> detalles;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "salida")
    private List<SalidaServicio> servicios;

    public Salida() {
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public StatusSalida getStatus() {
        return status;
    }

    public void setStatus(StatusSalida status) {
        this.status = status;
    }

    public String getPlacasTransporte() {
        return placasTransporte;
    }

    public void setPlacasTransporte(String placasTransporte) {
        this.placasTransporte = placasTransporte;
    }

    public String getNombreTransportista() {
        return nombreTransportista;
    }

    public void setNombreTransportista(String nombreTransportista) {
        this.nombreTransportista = nombreTransportista;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public List<SalidaDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<SalidaDetalle> detalles) {
        this.detalles = detalles;
    }

    public List<SalidaServicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<SalidaServicio> listServiciosSalida) {
        this.servicios = listServiciosSalida;
    }

    @Override
    public int hashCode() {
        if (this.id == null) {
            return System.identityHashCode(this);
        }
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salida other = (Salida) obj;
        if(this.id == null || other.id == null)
            return Objects.equals(System.identityHashCode(this), System.identityHashCode(other));
        
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Salida[" + "id=" + id + ", folioSalida=" + folio + ", placasTransporte=" + placasTransporte 
            + ", nombreTransportista=" + nombreTransportista + ", observaciones=" + observaciones + ", fechaSalida=" + fechaSalida 
                + ", horaSalida=" + horaSalida + ", fechaRegistro=" + fechaRegistro + ", fechaModificacion=" + fechaModificacion + ']';
    }
    
}
