package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contacto")
public class Contacto implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contacto")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nb_nombre")
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nb_apellido_1")
    private String primerApellido;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nb_apellido_2")
    private String segundoApellido;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contacto", orphanRemoval = true)
    private List<ClienteContacto> clienteContactoList;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "contacto", orphanRemoval = true)
    private List<MedioContacto> mediosContacto;

    public Contacto() {
    }

    public Contacto(Integer id) {
        this.id = id;
    }
    
    public Contacto(Integer id, String nombre, String primerApellido, String segundoApellido) {
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }
    
    public void add(ClienteContacto clienteContacto) {
    	if(this.clienteContactoList == null)
    		this.clienteContactoList = new ArrayList<>();
    	clienteContacto.setContacto(this);
    	this.clienteContactoList.add(clienteContacto);
    }
    
    public void remove(ClienteContacto clienteContacto) {
    	if(this.clienteContactoList == null)
    		return;
    	clienteContacto.setCliente(null);
    	this.clienteContactoList.remove(clienteContacto);
    }
    
    public void add(MedioContacto medioCnt) {
    	if(this.mediosContacto == null)
    		this.mediosContacto = new ArrayList<MedioContacto>();
    	medioCnt.setContacto(this);
    	this.mediosContacto.add(medioCnt);
    }
    
    public void remove(MedioContacto medioCnt) {
    	if(this.mediosContacto == null)
    		return;
    	medioCnt.setContacto(null);
    	this.mediosContacto.remove(medioCnt);
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

    public String getApellido1() {
        return primerApellido;
    }

    public void setApellido1(String apellido1) {
        this.primerApellido = apellido1;
    }

    public String getApellido2() {
        return segundoApellido;
    }

    public void setApellido2(String apellido2) {
        this.segundoApellido = apellido2;
    }

    public List<ClienteContacto> getClienteContactoList() {
        return clienteContactoList;
    }

    public void setClienteContactoList(List<ClienteContacto> clienteContactoList) {
        this.clienteContactoList = clienteContactoList;
    }
    
    public List<MedioContacto> getMediosContacto() {
        return mediosContacto;
    }

    public void setMediosContacto(List<MedioContacto> mediosContacto) {
        this.mediosContacto = mediosContacto;
    }

    @Override 
    public boolean equals(Object o) {
        if(this == o) return true;
        if (!(o instanceof Contacto)) return false;
        Contacto that = (Contacto) o;

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
        return "com.ferbo.gestion.core.model.Contacto[ id=" + id + " ]";
    }
    
}
