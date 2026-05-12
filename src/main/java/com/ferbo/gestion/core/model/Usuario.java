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
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
@NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario")
@NamedQuery(name = "Usuario.findByPerfil", query = "SELECT u FROM Usuario u WHERE u.perfil = :perfil")
public class Usuario implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Size(min = 1, max = 15)
    @Column(name = "usuario")
    private String usuario;

    @Size(min = 0, max = 1024)
    @Column(name = "password")
    private String password;

    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;

    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "perfil")
    private int perfil;

    @Size(max = 50)
    @Column(name = "apellido_1")
    private String apellido1;

    @Size(max = 50)
    @Column(name = "apellido_2")
    private String apellido2;

    @Size(max = 100)
    @Column(name = "mail")
    private String mail;

    @Column(name = "id_planta")
    private Integer idPlanta;

    @Column(name = "st_ntf_srv_ext")
    private boolean stNtfSrvExt;

    @Size(min = 1, max = 1)
    @Column(name = "st_usuario")
    private String stUsuario;

    @Size(max = 10)
    @Column(name = "numEmpleado")
    private String numEmpleado;

    @Basic(optional = false)
    @Column(name = "huella")
    private boolean huella;

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public Usuario(Integer idUsuario) {
        this.id = idUsuario;
    }

    public Usuario(Integer idUsuario, String usuario, String password, int perfil, String stUsuario, String numEmpleado) {
        this.id = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.perfil = perfil;
        this.stUsuario = stUsuario;
        this.numEmpleado = numEmpleado;
    }

    public Integer getidUsuario() {
        return id;
    }

    public void setId(Integer idUsuario) {
        this.id = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(Integer idPlanta) {
        this.idPlanta = idPlanta;
    }

    public String getStUsuario() {
        return stUsuario;
    }

    public String getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(String numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public void setStUsuario(String stUsuario) {
        this.stUsuario = stUsuario;
    }

    public boolean getHuella() {
        return huella;
    }

    public void setHuella(boolean huella) {
        this.huella = huella;
    }

    public boolean isStNtfSrvExt() {
        return stNtfSrvExt;
    }

    public void setStNtfSrvExt(boolean stNtfSrvExt) {
        this.stNtfSrvExt = stNtfSrvExt;
    }
    
    @Override
    public int hashCode() {
        if (this.id == null) {
            return System.identityHashCode(this);
        }
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Usuario[ id=" + id + " ]";
    }

}
