package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente")
@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c ORDER BY c.nombre")
@NamedQuery(name = "Cliente.findByCodigoUnico", query = "SELECT c FROM Cliente c WHERE c.codigoUnico = :codigoUnico")
public class Cliente implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CTE_CVE")
    private Integer id;

    @Size(max = 150)
    @Column(name = "CTE_NOMBRE")
    private String nombre;

    @Size(max = 150)
    @Column(name = "nb_alias")
    private String alias;

    @Size(max = 20)
    @Column(name = "CTE_RFC")
    private String rfc;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numero_cte")
    private String numeroCte;

    @Size(max = 255)
    @Column(name = "cte_mail")
    private String mail;

    @Basic(optional = false)
    @NotNull
    @Column(name = "habilitado")
    private boolean habilitado;

    @Size(max = 3)
    @Column(name = "COD_UNICO")
    private String codigoUnico;

    @Size(min = 1, max = 1)
    @Column(name = "tp_persona")
    private String tipoPersona;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "cd_regimen", referencedColumnName = "cd_regimen")
    private RegimenFiscal regimenFiscal;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "cd_uso_cfdi", referencedColumnName = "cd_uso_cfdi")
    private UsoCfdi usoCfdi;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cd_metodo_pago", referencedColumnName = "cd_metodo_pago")
    private MetodoPago metodoPago;

    @Column(name = "cd_forma_pago")
    private String formaPago;

    @Size(max = 150)
    @Column(name = "nb_regimen_capital")
    private String regimenCapital;

    @Size(max = 50)
    @Column(name = "uuid")
    private String uuid;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ClienteDomicilio> clienteDomiciliosList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", orphanRemoval = true)
    private List<ClienteContacto> clienteContactoList;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY, orphanRemoval = true)
    private CandadoSalida candadoSalida;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "key.cliente", orphanRemoval = true)
    private List<SerieConstancia> serieConstanciaList;

    public Cliente() {
    }

    public Cliente(Integer id) {
        this.id = id;
    }

    public Cliente(Integer id, String numeroCte, boolean habilitado) {
        this.id = id;
        this.numeroCte = numeroCte;
        this.habilitado = habilitado;
    }

    public void add(ClienteContacto clienteContacto) {
        if (this.clienteContactoList == null) {
            this.clienteContactoList = new ArrayList<ClienteContacto>();
        }
        clienteContacto.setCliente(this);
        this.clienteContactoList.add(clienteContacto);
    }

    public void remove(ClienteContacto clienteContacto) {
        if (this.clienteContactoList == null) {
            return;
        }
        clienteContacto.setCliente(null);
        this.clienteContactoList.remove(clienteContacto);
    }

    public void remove(CandadoSalida candadoSalida) {
        candadoSalida.setCliente(null);
        this.candadoSalida = null;
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

    public void setNombre(String cteNombre) {
        if (cteNombre != null) {
            cteNombre = cteNombre.trim();
        }
        this.nombre = cteNombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        if (alias != null) {
            alias = alias.trim();
        }
        this.alias = alias;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNumeroCte() {
        return numeroCte;
    }

    public void setNumeroCte(String numeroCte) {
        if (numeroCte != null) {
            numeroCte = numeroCte.trim();
        }
        this.numeroCte = numeroCte;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        if (mail != null) {
            mail = mail.trim();
        }
        this.mail = mail;
    }

    public boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        if (codigoUnico != null) {
            codigoUnico = codigoUnico.trim();
        }
        this.codigoUnico = codigoUnico;
    }

    public List<ClienteDomicilio> getClienteDomiciliosList() {
        return clienteDomiciliosList;
    }

    public void setClienteDomiciliosList(List<ClienteDomicilio> clienteDomiciliosList) {
        this.clienteDomiciliosList = clienteDomiciliosList;
    }

    public List<ClienteContacto> getClienteContactoList() {
        return clienteContactoList;
    }

    public void setClienteContactoList(List<ClienteContacto> clienteContactoList) {
        this.clienteContactoList = clienteContactoList;
    }

    public String getRegimenCapital() {
        return regimenCapital;
    }

    public void setRegimenCapital(String regimenCapital) {
        this.regimenCapital = regimenCapital;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public RegimenFiscal getRegimenFiscal() {
        return regimenFiscal;
    }

    public void setRegimenFiscal(RegimenFiscal regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }

    public UsoCfdi getUsoCfdi() {
        return usoCfdi;
    }

    public void setUsoCfdi(UsoCfdi usoCfdi) {
        this.usoCfdi = usoCfdi;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public CandadoSalida getCandadoSalida() {
        return candadoSalida;
    }

    public void setCandadoSalida(CandadoSalida candadoSalida) {
        this.candadoSalida = candadoSalida;
    }

    public List<SerieConstancia> getSerieConstanciaList() {
        return serieConstanciaList;
    }

    public void setSerieConstanciaList(List<SerieConstancia> serieConstanciaList) {
        this.serieConstanciaList = serieConstanciaList;
    }

    public void addSerieConstancia(SerieConstancia serie) {
        if (this.serieConstanciaList == null) {
            this.serieConstanciaList = new ArrayList<SerieConstancia>();
        }

        if (serie.getKey() == null) {
            serie.setKey(new SerieConstanciaPK());
        }

        serie.getKey().setCliente(this);

        this.serieConstanciaList.add(serie);
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Cliente[ id=" + id + " ]";
    }

}
