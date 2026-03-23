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
@NamedQueries({
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c"),
    @NamedQuery(name = "Contacto.findByIdContacto", query = "SELECT c FROM Contacto c WHERE c.id = :idContacto"),
    @NamedQuery(name = "Contacto.findByNombre", query = "SELECT c FROM Contacto c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Contacto.findByApellido1", query = "SELECT c FROM Contacto c WHERE c.apellido1 = :apellido1"),
    @NamedQuery(name = "Contacto.findByApellido2", query = "SELECT c FROM Contacto c WHERE c.apellido2 = :apellido2")
})
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
    private String apellido1;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nb_apellido_2")
    private String apellido2;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contacto", orphanRemoval = true)
    private List<ClienteContacto> clienteContactoList;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "contacto", orphanRemoval = true)
    private List<MedioCnt> medioCntList;

    public Contacto() {
    }

    public Contacto(Integer id) {
        this.id = id;
    }
    
    public Contacto(Integer id, String nombre, String apellido1, String apellido2) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
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
    
    public void add(MedioCnt medioCnt) {
    	if(this.medioCntList == null)
    		this.medioCntList = new ArrayList<MedioCnt>();
    	medioCnt.setContacto(this);
    	this.medioCntList.add(medioCnt);
    }
    
    public void remove(MedioCnt medioCnt) {
    	if(this.medioCntList == null)
    		return;
    	medioCnt.setContacto(null);
    	this.medioCntList.remove(medioCnt);
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
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public List<ClienteContacto> getClienteContactoList() {
        return clienteContactoList;
    }

    public void setClienteContactoList(List<ClienteContacto> clienteContactoList) {
        this.clienteContactoList = clienteContactoList;
    }
    
    public List<MedioCnt> getMedioCntList() {
        return medioCntList;
    }

    public void setMedioCntList(List<MedioCnt> medioCntList) {
        this.medioCntList = medioCntList;
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
        return "mx.com.ferbo.model.Contacto[ id=" + id + " ]";
    }
    
}
