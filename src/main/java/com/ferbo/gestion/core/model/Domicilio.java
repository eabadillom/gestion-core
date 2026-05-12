package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Entity
@Table(name = "domicilios")
@NamedQuery(name = "Domicilio.findByCp", query = "SELECT d FROM Domicilio d WHERE d.asentamiento.cp = :domicilioCp")
public class Domicilio implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dom_cve")
    private Integer id;
    
    @Size(max = 100)
    @Column(name = "domicilio_calle")
    private String calle;
    
    @Size(max = 50)
    @Column(name = "domicilio_num_ext")
    private String numeroExterior;
    
    @Size(max = 50)
    @Column(name = "domicilio_num_int")
    private String numeroInterior;
    
    @Size(max = 10)
    @Column(name = "domicilio_tel1")
    private String telefono1;
    
    @Size(max = 10)
    @Column(name = "domicilio_tel2")
    private String telefono2;
    
    @Size(max = 10)
    @Column(name = "domicilio_fax")
    private String fax;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "domicilio")
    private List<ClienteDomicilio> clienteDomicilioList;
    
    @Null
    @JoinColumns(value = {
        @JoinColumn(name = "pais_cve", referencedColumnName = "pais_cve"),
        @JoinColumn(name = "estado_cve", referencedColumnName = "estado_cve"),
        @JoinColumn(name = "municipio_cve", referencedColumnName = "municipio_cve"),
        @JoinColumn(name = "ciudad_cve", referencedColumnName = "ciudad_cve"),
        @JoinColumn(name = "asentamiento_cve", referencedColumnName = "asentamiento_cve")
    }, foreignKey = @ForeignKey(name = "FR_Domicilio_Asentamiento"))
    @OneToOne
    private Asentamiento asentamiento;
    
    @JoinColumn(name = "domicilio_tipo_cve", referencedColumnName = "domicilio_tipo_cve")
    @ManyToOne(optional = false)
    private TipoDomicilio tipoDomicilio;

    public Domicilio() {
    }

    public Domicilio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numExt) {
        this.numeroExterior = numExt;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumInterior(String numInt) {
        this.numeroInterior = numInt;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    
    public List<ClienteDomicilio> getClienteDomicilioList() {
        return clienteDomicilioList;
    }

    public void setClienteDomicilioList(List<ClienteDomicilio> clienteDomicilioList) {
        this.clienteDomicilioList = clienteDomicilioList;
    }

    public Asentamiento getAsentamiento() {
        return asentamiento;
    }

    public void setAsentamiento(Asentamiento asentamiento) {
        this.asentamiento = asentamiento;
    }

    public TipoDomicilio getTipoDomicilio() {
        return tipoDomicilio;
    }

    public void setTipoDomicilio(TipoDomicilio tipoDomicilio) {
        this.tipoDomicilio = tipoDomicilio;
    }

    @Override
    public int hashCode() {
        if(this.id == null)
            return System.identityHashCode(this);
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        Domicilio other = (Domicilio) object;
        if(this.id == null || other.id == null)
            return Objects.equals(System.identityHashCode(this), System.identityHashCode(other));
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Domicilios[ id=" + id + " ]";
    }
    
}
