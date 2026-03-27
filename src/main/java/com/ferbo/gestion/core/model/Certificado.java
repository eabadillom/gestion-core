package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.time.LocalDateTime;
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
import javax.validation.constraints.Size;

@Entity
@Table(name = "certificado")
@NamedQueries({
    @NamedQuery(name = "Certificado.findAll", query = "SELECT c FROM Certificado c"),
    @NamedQuery(name = "Certificado.findById", query = "SELECT c FROM Certificado c WHERE c.id = :idCertificado"),
    @NamedQuery(name = "Certificado.findByAlta", query = "SELECT c FROM Certificado c WHERE c.fechaAlta = :fh_alta"),
    @NamedQuery(name = "Certificado.findByNombreCertificado", query = "SELECT c FROM Certificado c WHERE c.nombreCertificado = :nb_certificado"),
    @NamedQuery(name = "Certificado.findByFecha", query = "SELECT max(c.fechaAlta), c.certificado FROM Certificado c GROUP BY c.certificado"),
    @NamedQuery(name = "Certificado.findByEmisor", query = "SELECT c FROM Certificado c WHERE c.emisor.id = :idEmisor")
})
public class Certificado implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_certificado")
    private Integer id;

    @Column(name = "fh_alta")
    private LocalDateTime fechaAlta;

    @Size(min = 1, max = 256)
    @Column(name = "nb_certificado")
    private String nombreCertificado;

    @Size(min = 1, max = 1638)
    @Column(name = "dt_certificado")
    private byte[] certificado;

    @Size(min = 1, max = 256)
    @Column(name = "nb_llave_privada")
    private String llavePrivada;

    @Size(min = 1, max = 1638)
    @Column(name = "dt_llave_privada")
    private byte[] dtLlavePrivada;

    @Size(min = 1, max = 100)
    @Column(name = "nb_pass")
    private String password;

    @JoinColumn(name = "cd_emisor")
    @ManyToOne
    private Emisor emisor;

    public Certificado() {
    }
    
    public Certificado(Integer id, LocalDateTime fechaAlta, String nombreCertificado, byte[] certificado, String llavePrivada,
            byte[] dtLlavePrivada, String password, Emisor emisor) {
        this.id = id;
        this.fechaAlta = fechaAlta;
        this.nombreCertificado = nombreCertificado;
        this.certificado = certificado;
        this.llavePrivada = llavePrivada;
        this.dtLlavePrivada = dtLlavePrivada;
        this.password = password;
        this.emisor = emisor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getNombreCertificado() {
        return nombreCertificado;
    }

    public void setNombreCertificado(String nombreCertificado) {
        this.nombreCertificado = nombreCertificado;
    }

    public byte[] getCertificado() {
        return certificado;
    }

    public void setCertificado(byte[] certificado) {
        this.certificado = certificado;
    }

    public String getLlavePrivada() {
        return llavePrivada;
    }

    public void setLlavePrivada(String llavePrivada) {
        this.llavePrivada = llavePrivada;
    }

    public byte[] getDtLlavePrivada() {
        return dtLlavePrivada;
    }

    public void setDtLlavePrivada(byte[] dtLlavePrivada) {
        this.dtLlavePrivada = dtLlavePrivada;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Emisor getEmisor() {
        return emisor;
    }

    public void setEmisor(Emisor emisor) {
        this.emisor = emisor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(certificado, dtLlavePrivada, id, emisor, fechaAlta, llavePrivada,
                nombreCertificado, password);
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
        Certificado other = (Certificado) obj;
        return Objects.equals(certificado, other.certificado) && Objects.equals(dtLlavePrivada, other.dtLlavePrivada)
                && Objects.equals(id, other.id) && Objects.equals(emisor, other.emisor)
                && Objects.equals(fechaAlta, other.fechaAlta) && Objects.equals(llavePrivada, other.llavePrivada)
                && Objects.equals(nombreCertificado, other.nombreCertificado)
                && Objects.equals(password, other.password);
    }

}
