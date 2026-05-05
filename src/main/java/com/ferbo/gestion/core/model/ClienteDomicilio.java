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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "cliente_domicilios")
@NamedQuery(name = "ClienteDomicilio.findAll", query = "SELECT c FROM ClienteDomicilio c")
@NamedQuery(name = "ClienteDomicilio.findById", query = "SELECT c FROM ClienteDomicilio c WHERE c.id = :id")
@NamedQuery(name = "ClienteDomicilio.findByCliente", query = "SELECT c FROM ClienteDomicilio c WHERE c.cliente.id = :idCliente")
@NamedQuery(name = "ClienteDomicilio.findByClienteDomFiscal", query = "SELECT c FROM ClienteDomicilio c WHERE c.domicilio.tipoDomicilio.id = :idTipoDom AND c.cliente.id = :idCliente")
@NamedQuery(name = "ClienteDomicilio.findByClienteTipoDomicilio", query = "SELECT c FROM ClienteDomicilio c WHERE c.cliente.id = :idCliente AND c.domicilio.tipoDomicilio.id = :idTipoDomicilio")
public class ClienteDomicilio implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "CTE_CVE", referencedColumnName = "CTE_CVE")
    @ManyToOne(optional = false)
    private Cliente cliente;
    
    @JoinColumns({
            @JoinColumn(name = "domicilio_tipo_cve", referencedColumnName = "domicilio_tipo_cve"),
            @JoinColumn(name = "dom_cve", referencedColumnName = "dom_cve") })
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
    private Domicilio domicilio;

    public ClienteDomicilio() {
    }

    public ClienteDomicilio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public int hashCode() {
        if(this.id == null){
            return System.identityHashCode(this);
        }
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
        ClienteDomicilio other = (ClienteDomicilio) object;
        if(this.id == null || other.id == null)
            return Objects.equals(System.identityHashCode(this), System.identityHashCode(other));
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.ClienteDomicilio[ id=" + id + " ]";
    }

}
