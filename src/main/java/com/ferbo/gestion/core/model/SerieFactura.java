package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "serie_factura")
@NamedQuery(name = "SerieFactura.findByEmisor", query = "SELECT s FROM SerieFactura s WHERE s.statusSerie.id in (1,2) AND s.emisor.id = :idEmisor")
public class SerieFactura implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_inicial")
    private int numeroInicial;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_actual")
    private int numeroActual;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_final")
    private Integer numeroFinal;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "nom_serie")
    private String serie;
    
    @JoinColumn(name = "status_serie", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StatusSerie status;
    
    @JoinColumn(name = "cd_emisor", referencedColumnName = "cd_emisor")
    @ManyToOne(optional = true)
    private Emisor emisor;
    
    public SerieFactura() {
    }

    public SerieFactura(Integer id) {
        this.id = id;
    }

    public SerieFactura(Integer id, LocalDate fechaInicio, int numeroInicial, int numeroActual, int numeroFinal, String serie) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.numeroInicial = numeroInicial;
        this.numeroActual = numeroActual;
        this.numeroFinal = numeroFinal;
        this.serie = serie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getNumeroInicial() {
        return numeroInicial;
    }

    public void setNumeroInicial(int numeroInicial) {
        this.numeroInicial = numeroInicial;
    }

    public int getNumeroActual() {
        return numeroActual;
    }

    public void setNumeroActual(int numeroActual) {
        this.numeroActual = numeroActual;
    }

    public Integer getNumeroFinal() {
        return numeroFinal;
    }

    public void setNumeroFinal(Integer numeroFinal) {
        this.numeroFinal = numeroFinal;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public StatusSerie getStatus() {
        return status;
    }

    public void setStatus(StatusSerie status) {
        this.status = status;
    }
    
    public Emisor getEmisor() {
            return emisor;
    }

    public void setEmisor(Emisor emisor) {
            this.emisor = emisor;
    }
    
    @Override
    public int hashCode() {
        if(this.id == null)
        	return System.identityHashCode(this);
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object object) {
    	if(this == object)
    		return true;
    	
    	if(object == null)
    		return false;
    	
        if (!(object instanceof SerieFactura)) {
            return false;
        }
        
        final SerieFactura other = (SerieFactura) object;
        
        if(this.id == null || other.id == null)
        	return Objects.equals(System.identityHashCode(this), System.identityHashCode(other));
        
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.SerieFactura[ id=" + id + " ]";
    }
    
}
