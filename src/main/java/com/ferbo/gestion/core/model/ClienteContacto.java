package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.time.LocalDate;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente_contacto")
@NamedQueries({
    @NamedQuery(name = "ClienteContacto.findAll", query = "SELECT c FROM ClienteContacto c"),
    @NamedQuery(name = "ClienteContacto.findByStHabilitado", query = "SELECT c FROM ClienteContacto c WHERE c.habilitado = :habilitado"),
    @NamedQuery(name = "ClienteContacto.findByNbUsuario", query = "SELECT c FROM ClienteContacto c WHERE c.usuario = :usuario"),
    @NamedQuery(name = "ClienteContacto.findByNbPassword", query = "SELECT c FROM ClienteContacto c WHERE c.password = :password"),
    @NamedQuery(name = "ClienteContacto.findByStUsuario", query = "SELECT c FROM ClienteContacto c WHERE c.stUsuario = :stUsuario"),
    @NamedQuery(name = "ClienteContacto.findByFhAlta", query = "SELECT c FROM ClienteContacto c WHERE c.alta = :alta"),
    @NamedQuery(name = "ClienteContacto.findByFhCadPasswd", query = "SELECT c FROM ClienteContacto c WHERE c.cadPasswd = :cadPasswd"),
    @NamedQuery(name = "ClienteContacto.findByFhUltAcceso", query = "SELECT c FROM ClienteContacto c WHERE c.ultAcceso = :ultAcceso"),
    @NamedQuery(name = "ClienteContacto.findById", query = "SELECT c FROM ClienteContacto c WHERE c.id = :id"),
    @NamedQuery(name = "ClienteContacto.findAllByIdCliente", query = "SELECT DISTINCT cc FROM ClienteContacto cc LEFT JOIN cc.contacto c LEFT JOIN c.medioCntList mc WHERE cc.cliente.id = :idCliente")
})
public class ClienteContacto implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Column(name = "st_habilitado")
    private boolean habilitado;

    @Size(max = 50)
    @Column(name = "nb_usuario")
    private String usuario;

    @Size(max = 1024)
    @Column(name = "nb_password")
    private String password;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "st_usuario")
    private String stUsuario;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fh_alta")
    private LocalDate alta;

    @Column(name = "fh_cad_passwd")
    private LocalDate cadPasswd;

    @Column(name = "fh_ult_acceso")
    private LocalDate ultAcceso;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "id_cliente", referencedColumnName = "CTE_CVE")
    @ManyToOne(optional = false)
    private Cliente cliente;

    @JoinColumn(name = "id_contacto", referencedColumnName = "id_contacto")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Contacto contacto;

    @Column(name = "st_facturacion")
    private Boolean recibeFacturacion;

    @Column(name = "st_inventario")
    private Boolean recibeInventario;

    public ClienteContacto() {
        cliente = new Cliente();
        contacto = new Contacto();
    }

    public ClienteContacto(Integer id) {
        this.id = id;
    }

    public ClienteContacto(Integer id, boolean habilitado, String stUsuario, LocalDate alta) {
        this.id = id;
        this.habilitado = habilitado;
        this.stUsuario = stUsuario;
        this.alta = alta;
    }

    public boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
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

    public String getStUsuario() {
        return stUsuario;
    }

    public void setStUsuario(String stUsuario) {
        this.stUsuario = stUsuario;
    }

    public LocalDate getAlta() {
        return alta;
    }

    public void setAlta(LocalDate alta) {
        this.alta = alta;
    }

    public LocalDate getCadPasswd() {
        return cadPasswd;
    }

    public void setCadPasswd(LocalDate cadPasswd) {
        this.cadPasswd = cadPasswd;
    }

    public LocalDate getUltAcceso() {
        return ultAcceso;
    }

    public void setUltAcceso(LocalDate ultAcceso) {
        this.ultAcceso = ultAcceso;
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

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public Boolean getRecibeFacturacion() {
        return recibeFacturacion;
    }

    public void setRecibeFacturacion(Boolean recibeFacturacion) {
        this.recibeFacturacion = recibeFacturacion;
    }

    public Boolean getRecibeInventario() {
        return recibeInventario;
    }

    public void setRecibeInventario(Boolean recibeInventario) {
        this.recibeInventario = recibeInventario;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClienteContacto)) {
            return false;
        }

        ClienteContacto that = (ClienteContacto) o;

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
        return "com.ferbo.gestion.core.model.ClienteContacto[ id=" + id + " ]";
    }

}
