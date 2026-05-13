package com.ferbo.gestion.core.model.inventario;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.ferbo.gestion.core.model.catalogo.almacen.Planta;
import com.ferbo.gestion.core.model.cliente.Cliente;

@Entity
@Table(name = "serie_constancia")
public class SerieConstancia implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected SerieConstanciaPK key;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "nu_serie")
    private int numero;
    
    public SerieConstancia() {
    }

    public SerieConstancia(SerieConstanciaPK key) {
        this.key = key;
    }

    public SerieConstancia(SerieConstanciaPK key, int numero) {
        this.key = key;
        this.numero = numero;
    }

    public SerieConstancia(Cliente cliente, String tpSerie, Planta planta) {
        this.key = new SerieConstanciaPK(cliente, tpSerie, planta);
    }

    public SerieConstanciaPK getKey() {
        return key;
    }

    public void setKey(SerieConstanciaPK key) {
        this.key = key;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    @Override
    public int hashCode() {
    	if(this.key == null)
    		return System.identityHashCode(this);
        return key.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SerieConstancia)) {
            return false;
        }
        SerieConstancia other = (SerieConstancia) object;
        if ((this.key == null && other.key != null) || (this.key != null && !this.key.equals(other.key))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.SerieConstancia[ serieConstanciaPK=" + key + " ]";
    }
    
}
