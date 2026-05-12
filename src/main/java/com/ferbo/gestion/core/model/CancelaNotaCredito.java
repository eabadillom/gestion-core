package com.ferbo.gestion.core.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cancela_nota_credito")
@NamedQuery(name = "CancelaNotaCredito.findAll", query = "SELECT c FROM CancelaNotaCredito c")
@NamedQuery(name = "CancelaNotaCredito.findById", query = "SELECT c FROM CancelaNotaCredito c WHERE c.id = :id")
public class CancelaNotaCredito implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @JoinColumn(name = "NOTA", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private NotaCredito nota;

    public CancelaNotaCredito() {
    }

    public CancelaNotaCredito(Integer id) {
        this.id = id;
    }

    public CancelaNotaCredito(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public NotaCredito getNota() {
        return nota;
    }

    public void setNota(NotaCredito nota) {
        this.nota = nota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CancelaNotaCredito)) {
            return false;
        }
        CancelaNotaCredito other = (CancelaNotaCredito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.CancelaNotaCredito[ id=" + id + " ]";
    }
    
}
