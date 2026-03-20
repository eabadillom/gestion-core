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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Entity
@Table(name = "domicilios")
@NamedQueries({
    @NamedQuery(name = "Domicilio.findAll", query = "SELECT d FROM Domicilio d"),
    @NamedQuery(name = "Domicilio.findByDomCve", query = "SELECT d FROM Domicilio d WHERE d.id = :idDomicilio"),
    @NamedQuery(name = "Domicilio.findByDomicilioCalle", query = "SELECT d FROM Domicilio d WHERE d.calle = :calle"),
    @NamedQuery(name = "Domicilio.findByDomicilioNumExt", query = "SELECT d FROM Domicilio d WHERE d.numExt = :numExt"),
    @NamedQuery(name = "Domicilio.findByDomicilioNumInt", query = "SELECT d FROM Domicilio d WHERE d.numInt = :numInt"),
    @NamedQuery(name = "Domicilio.findByDomicilioCp", query = "SELECT d FROM Domicilio d WHERE d.asentamiento.cp = :domicilioCp"),
    @NamedQuery(name = "Domicilio.findByDomicilioTel1", query = "SELECT d FROM Domicilio d WHERE d.telefono1 = :telefono1"),
    @NamedQuery(name = "Domicilio.findByDomicilioTel2", query = "SELECT d FROM Domicilio d WHERE d.telefono2 = :telefono2"),
    @NamedQuery(name = "Domicilio.findByDomicilioFax", query = "SELECT d FROM Domicilio d WHERE d.fax = :fax"),
    @NamedQuery(name = "Domicilio.findByAsentamiento", query = "SELECT d FROM Domicilio d WHERE d.asentamiento.asentamientoPK.ciudad.ciudadPK.municipio.municipioPK.estado.estadoPK.pais.id = :idPais AND d.asentamiento.asentamientoPK.ciudad.ciudadPK.municipio.municipioPK.estado.estadoPK.id = :idEstado AND d.asentamiento.asentamientoPK.ciudad.ciudadPK.municipio.municipioPK.id = :idMunicipio AND d.asentamiento.asentamientoPK.ciudad.ciudadPK.id = :idCiudad AND d.asentamiento.asentamientoPK.id = :idAsentamiento" )
})
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
    private String numExt;
    
    @Size(max = 50)
    @Column(name = "domicilio_num_int")
    private String numInt;
    
    @Size(max = 10)
    @Column(name = "domicilio_tel1")
    private String telefono1;
    
    @Size(max = 10)
    @Column(name = "domicilio_tel2")
    private String telefono2;
    
    @Size(max = 10)
    @Column(name = "domicilio_fax")
    private String fax;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "domicilios")
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

    public String getNumExt() {
        return numExt;
    }

    public void setNumExt(String numExt) {
        this.numExt = numExt;
    }

    public String getNumInt() {
        return numInt;
    }

    public void setNumInt(String numInt) {
        this.numInt = numInt;
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
        return "mx.com.ferbo.model.Domicilios[ id=" + id + " ]";
    }
    
}
