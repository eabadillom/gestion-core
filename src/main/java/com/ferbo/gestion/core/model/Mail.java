package com.ferbo.gestion.core.model;

import java.io.Serializable;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mail")
@NamedQueries({
        @NamedQuery(name = "Mail.findAll", query = "SELECT m FROM Mail m"),
        @NamedQuery(name = "Mail.findById", query = "SELECT m FROM Mail m WHERE m.id = :id"),
        @NamedQuery(name = "Mail.findByMail", query = "SELECT m FROM Mail m WHERE m.mail = :mail"),
        @NamedQuery(name = "Mail.findByStPrincipal", query = "SELECT m FROM Mail m WHERE m.principal = :principal") 
})
public class Mail implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mail")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nb_mail")
    private String mail;

    @Basic(optional = false)
    @NotNull
    @Column(name = "st_principal")
    private boolean principal;

    @JoinColumn(name = "tp_mail", referencedColumnName = "tp_mail")
    @ManyToOne(optional = false)
    private TipoMail tpMail;

    @OneToMany(mappedBy = "mail", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedioCnt> medioCntList;

    public Mail() {
    }

    public Mail(Integer id) {
        this.id = id;
    }

    public Mail(Integer id, String mail, boolean principal) {
        this.id = id;
        this.mail = mail;
        this.principal = principal;
    }

    public Integer getIdMail() {
        return id;
    }

    public void setIdMail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public TipoMail getTpMail() {
        return tpMail;
    }

    public void setTpMail(TipoMail tpMail) {
        this.tpMail = tpMail;
    }

    public List<MedioCnt> getMedioCntList() {
        return medioCntList;
    }

    public void setMedioCntList(List<MedioCnt> medioCntList) {
        this.medioCntList = medioCntList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Mail))
            return false;
        Mail that = (Mail) o;

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
        return "mx.com.ferbo.model.Mail[ id=" + id + " ]";
    }

}
