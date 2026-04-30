package com.ferbo.gestion.core.model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "medio_cnt")
@NamedQuery(name = "MedioCnt.findByContacto", query = "SELECT m FROM MedioCnt m WHERE m.contacto.id = :idContacto")
public class MedioContacto implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medio")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tp_medio")
    private String tipoMedio;

    @Basic(optional = false)
    @NotNull
    @Column(name = "st_medio")
    private boolean status;

    @JoinColumn(name = "id_contacto", referencedColumnName = "id_contacto")
    @ManyToOne
    private Contacto contacto;

    @JoinColumn(name = "id_mail", referencedColumnName = "id_mail")
    @ManyToOne(cascade = CascadeType.ALL)
    private Mail mail;

    @JoinColumn(name = "id_telefono", referencedColumnName = "id_telefono")
    @ManyToOne(cascade = CascadeType.ALL)
    private Telefono telefono;
    
    public MedioContacto() {
    }

    public MedioContacto(Integer id) {
        this.id = id;
    }

    public MedioContacto(Integer id, String tipoMedio, boolean stMedio) {
        this.id = id;
        this.tipoMedio = tipoMedio;
        this.status = stMedio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoMedio() {
        return tipoMedio;
    }

    public void setTipoMedio(String tipoMedio) {
        this.tipoMedio = tipoMedio;
    }

    public boolean getStMedio() {
        return status;
    }

    public void setStMedio(boolean status) {
        this.status = status;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public Mail getMail() {
        return mail;
    }

    public void setMail(Mail mail) {
        this.mail = mail;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof MedioContacto))
            return false;
        MedioContacto that = (MedioContacto) o;

        if (this.id != null && that.id != null) {
            return Objects.equals(this.id, that.id);
        } else {
            return this == that;
        }
    }

    @Override
    public int hashCode() {
        return (id != null) ? id.hashCode() : System.identityHashCode(this);
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.MedioCnt[ id=" + id + " ]";
    }

}
