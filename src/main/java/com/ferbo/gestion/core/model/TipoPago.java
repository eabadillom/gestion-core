package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tipo_pago")
@NamedQuery(name = "TipoPago.findAll", query = "SELECT t FROM TipoPago t")
public class TipoPago implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    public static final Integer CHEQUE                     = 1;
    public static final Integer FICHA_DE_DEPOSITO          = 2;
    public static final Integer CHEQUE_DE_CAJA             = 3;
    public static final Integer DOCUMENTO_DE_TRANSFERENCIA = 4;
    public static final Integer NOTA_CREDITO               = 5;
    public static final Integer EFECTIVO                   = 6;
    public static final Integer DOLARES                    = 7;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;

    public TipoPago() {
    }

    public TipoPago(Integer id) {
        this.id = id;
    }

    public TipoPago(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
    	if(this.id == null)
    		return System.identityHashCode(this);
        return Objects.hashCode(this.id);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPago)) {
            return false;
        }
        TipoPago other = (TipoPago) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.TipoPago[ id=" + id + " ]";
    }
    
}
