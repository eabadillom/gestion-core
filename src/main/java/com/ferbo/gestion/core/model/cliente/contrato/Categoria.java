package com.ferbo.gestion.core.model.cliente.contrato;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categoria")
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c ORDER BY c.descripcion"),
    @NamedQuery(name = "Categoria.findByCategoriaCve", query = "SELECT c FROM Categoria c WHERE c.id = :idCategoria"),
    @NamedQuery(name = "Categoria.findByCategoriaDs", query = "SELECT c FROM Categoria c WHERE c.descripcion = :descripcion")
})
public class Categoria implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "categoria_cve")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "categoria_ds")
    private String descripcion;
    
    public Categoria() {
    }

    public Categoria(Integer id) {
        this.id = id;
    }

    public Categoria(Integer id, String descripcion) {
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

    @Override
    public int hashCode() {
    	if(this.id == null)
    		return System.identityHashCode(this);
    	return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Categoria[ id=" + id + " ]";
    }
    
}
