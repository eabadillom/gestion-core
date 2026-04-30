package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "planta")
@NamedQueries({
    @NamedQuery(name = "Planta.findAll", query = "SELECT p FROM Planta p"),
    @NamedQuery(name = "Planta.findById", query = "SELECT p FROM Planta p WHERE p.id = :idPlanta"),
    @NamedQuery(name = "Planta.findByDescripcion", query = "SELECT p FROM Planta p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Planta.findByAbrev", query = "SELECT p FROM Planta p WHERE p.abrev = :abrev"),
    @NamedQuery(name = "Planta.findBySufijo", query = "SELECT p FROM Planta p WHERE p.sufijo = :sufijo"),
    @NamedQuery(name = "Planta.findByCod", query = "SELECT p FROM Planta p WHERE p.codigo = :codigo")
})
public class Planta implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PLANTA_CVE")
    private Integer id;

    @Size(max = 80)
    @Column(name = "PLANTA_DS")
    private String descripcion;

    @Size(max = 6)
    @Column(name = "planta_abrev")
    private String abrev;

    @Size(max = 6)
    @Column(name = "planta_sufijo")
    private String sufijo;

    @Size(max = 10)
    @Column(name = "PLANTA_COD")
    private String codigo;
    
    @Column(name = "st_habilitado")
    private Boolean habilitado;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "planta")
    private List<Camara> camaraList;

    @OneToMany(mappedBy = "serieConstanciaPK.planta", fetch = FetchType.LAZY, orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<SerieConstancia> serieConstanciaList;

    @Column(name = " id_pais")
    private Integer idPais;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "id_estado")
    private Integer idEstado;

    @Column(name = "id_municipio")
    private Integer idMunicipio;

    @Column(name = "id_ciudad")
    private Integer idCiudad;

    @Column(name = "id_asentamiento")
    private Integer idAsentamiento;

    @Column(name = "tp_asentamiento")
    private Integer tipoAsentamiento;

    @Column(name = "nb_cp")
    private String codigoPostal;

    @Size(max = 20)
    @Column(name = "nb_calle")
    private String calle;

    @Column(name = "nu_exterior")
    private String numExterior;

    @Column(name = "nu_interior")
    private String numInterior;

    @JoinColumn(name = "cd_emisor", referencedColumnName = "cd_emisor")
    @ManyToOne(optional = false)
    private Emisor emisor;

    @JoinColumn(name = "id_sf", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private SerieFactura serieFacturaDefault;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planta")
    private List<Posicion> posicionList;

    public Planta() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNumExterior() {
        return numExterior;
    }

    public void setNumExterior(String numExterior) {
        this.numExterior = numExterior;
    }

    public String getNumInterior() {
        return numInterior;
    }

    public void setNumInterior(String numInterior) {
        this.numInterior = numInterior;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Integer getIdAsentamiento() {
        return idAsentamiento;
    }

    public void setIdAsentamiento(Integer idAsentamiento) {
        this.idAsentamiento = idAsentamiento;
    }

    public Integer getTipoAsentamiento() {
        return tipoAsentamiento;
    }

    public void setTipoAsentamiento(Integer tipoAsentamiento) {
        this.tipoAsentamiento = tipoAsentamiento;
    }

    public Planta(Integer id) {
        this.id = id;
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

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public String getSufijo() {
        return sufijo;
    }

    public void setSufijo(String sufijo) {
        this.sufijo = sufijo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Camara> getCamaraList() {
        return camaraList;
    }

    public void setCamaraList(List<Camara> camaraList) {
        this.camaraList = camaraList;
    }

    public Emisor getEmisor() {
        return emisor;
    }

    public void setEmisor(Emisor emisor) {
        this.emisor = emisor;
    }

    public List<Posicion> getPosicionList() {
        return posicionList;
    }

    public void setPosicionList(List<Posicion> posicionList) {
        this.posicionList = posicionList;
    }

    public List<SerieConstancia> getSerieConstanciaList() {
        return serieConstanciaList;
    }

    public void setSerieConstanciaList(List<SerieConstancia> serieConstanciaList) {
        this.serieConstanciaList = serieConstanciaList;
    }

    public void add(SerieConstancia serieConstancia) {
        if (this.serieConstanciaList == null) {
            this.serieConstanciaList = new ArrayList<SerieConstancia>();
        }

        if (serieConstancia.getSerieConstanciaPK() == null) {
            serieConstancia.setSerieConstanciaPK(new SerieConstanciaPK());
        }

        serieConstancia.getSerieConstanciaPK().setPlanta(this);
        this.serieConstanciaList.add(serieConstancia);
    }

    public SerieFactura getSerieFacturaDefault() {
        return serieFacturaDefault;
    }

    public void setSerieFacturaDefault(SerieFactura serieFacturaDefault) {
        this.serieFacturaDefault = serieFacturaDefault;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Planta)) {
            return false;
        }
        Planta other = (Planta) object;
        if ((this.id == null && other.id != null)
                || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Planta[ id=" + id + " ]";
    }

}
