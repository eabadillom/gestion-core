package com.ferbo.gestion.core.model;

<<<<<<< Updated upstream
import java.util.Date;

public class ClienteContacto {
	
	private Integer idCliente = null;
	private Integer idContacto = null;
	private boolean habilitado = false;
	private String usuario = null;
	private String password = null;
	private String statusUsuario = null;
	private Date fechaAlta = null;
	private Date fechaCaducidad = null;
	private Date fechaUltimoAcceso = null;
	private boolean facturacion = false;
	private boolean inventario = false;
	
	private Contacto contacto = null;
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Integer getIdContacto() {
		return idContacto;
	}
	public void setIdContacto(Integer idContacto) {
		this.idContacto = idContacto;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	public Contacto getContacto() {
		return contacto;
	}
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
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
	public String getStatusUsuario() {
		return statusUsuario;
	}
	public void setStatusUsuario(String stUsuario) {
		this.statusUsuario = stUsuario;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public Date getFechaUltimoAcceso() {
		return fechaUltimoAcceso;
	}
	public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
		this.fechaUltimoAcceso = fechaUltimoAcceso;
	}
    public boolean isFacturacion() {
        return facturacion;
    }
    public void setFacturacion(boolean facturacion) {
        this.facturacion = facturacion;
    }
    public boolean isInventario() {
        return inventario;
    }
    public void setInventario(boolean inventario) {
        this.inventario = inventario;
=======
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
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente_contacto")
@NamedQuery(name = "ClienteContacto.findAllByIdCliente", query = "SELECT DISTINCT cc FROM ClienteContacto cc LEFT JOIN cc.contacto c LEFT JOIN c.medioCntList mc WHERE cc.cliente.id = :idCliente")
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
    private String statusUsuario;

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
        this.statusUsuario = stUsuario;
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

    public String getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(String stUsuario) {
        this.statusUsuario = stUsuario;
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
>>>>>>> Stashed changes
    }
    @Override
    public String toString() {
        return "{\"idCliente\":\"" + idCliente + "\", \"idContacto\":\"" + idContacto + "\", \"habilitado\":\""
                + habilitado + "\", \"usuario\":\"" + usuario + "\", \"statusUsuario\":\"" + statusUsuario
                + "\", \"fechaAlta\":\"" + fechaAlta + "\", \"fechaCaducidad\":\"" + fechaCaducidad
                + "\", \"fechaUltimoAcceso\":\"" + fechaUltimoAcceso + "\", \"facturacion\":\"" + facturacion
                + "\", \"inventario\":\"" + inventario + "\", \"contacto\":\"" + contacto + "\", \"getIdCliente()\":\""
                + getIdCliente() + "\", \"getIdContacto()\":\"" + getIdContacto() + "\", \"isHabilitado()\":\""
                + isHabilitado() + "\", \"getContacto()\":\"" + getContacto() + "\", \"getUsuario()\":\"" + getUsuario()
                + "\", \"getPassword()\":\"" + getPassword() + "\", \"getStatusUsuario()\":\"" + getStatusUsuario()
                + "\", \"getFechaAlta()\":\"" + getFechaAlta() + "\", \"getFechaCaducidad()\":\"" + getFechaCaducidad()
                + "\", \"getFechaUltimoAcceso()\":\"" + getFechaUltimoAcceso() + "\", \"isFacturacion()\":\""
                + isFacturacion() + "\", \"isInventario()\":\"" + isInventario() + "\", \"getClass()\":\"" + getClass()
                + "\", \"hashCode()\":\"" + hashCode() + "\", \"toString()\":\"" + super.toString() + "\"}";
    }

}
