package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "telefono")
@NamedQueries({
        @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t"),
        @NamedQuery(name = "Telefono.findById", query = "SELECT t FROM Telefono t WHERE t.id = :idTelefono"),
        @NamedQuery(name = "Telefono.findByTelefono", query = "SELECT t FROM Telefono t WHERE t.telefono = :telefono"),
        @NamedQuery(name = "Telefono.findByStPrincipal", query = "SELECT t FROM Telefono t WHERE t.principal = :principal")
})
public class Telefono implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_telefono")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "nb_telefono")
    private String telefono;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "st_principal")
    private boolean principal;
    
    @JoinColumn(name = "tp_telefono", referencedColumnName = "tp_telefono")
    @ManyToOne(optional = false)
    private TipoTelefono tpTelefono;
    
    @OneToMany(mappedBy = "telefono")
    private List<MedioCnt> medioCntList;

    public Telefono() {
    }

    public Telefono(Integer id) {
        this.id = id;
    }

    public Telefono(Integer id, String telefono, boolean principal) {
        this.id = id;
        this.telefono = telefono;
        this.principal = principal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public TipoTelefono getTpTelefono() {
        return tpTelefono;
    }

    public void setTpTelefono(TipoTelefono tpTelefono) {
        this.tpTelefono = tpTelefono;
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
        if (!(o instanceof Telefono))
            return false;
        Telefono that = (Telefono) o;

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
        return "mx.com.ferbo.model.Telefono[ id=" + id + " ]";
    }

}
