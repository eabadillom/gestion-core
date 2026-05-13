package com.ferbo.gestion.core.model.facturacion;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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

import com.ferbo.gestion.core.model.catalogo.sat.RegimenFiscal;

@Entity
@Table(name = "emisor")
@NamedQueries({
    @NamedQuery(name = "Emisor.findAll", query = "SELECT e FROM Emisor e ORDER BY e.emisor"),
    @NamedQuery(name = "Emisor.findById", query = "SELECT e FROM Emisor e WHERE e.id = :idEmisor"),
    @NamedQuery(name = "Emisor.findByEmisor", query = "SELECT e FROM Emisor e WHERE e.emisor = :emisor"),
    @NamedQuery(name = "Emisor.findByTpPersona", query = "SELECT e FROM Emisor e WHERE e.tpPersona = :tpPersona"),
    @NamedQuery(name = "Emisor.findByRegimenCapital", query = "SELECT e FROM Emisor e WHERE e.regimenCapital = :regimenCapital"),
    @NamedQuery(name = "Emisor.findByRFC", query = "SELECT e FROM Emisor e WHERE e.rfc = :rfc"),
    @NamedQuery(name = "Emisor.findByIniOperaciones", query = "SELECT e FROM Emisor e WHERE e.inicioOp = :inicioOp"),
    @NamedQuery(name = "Emisor.findByUltimoCambio", query = "SELECT e FROM Emisor e WHERE e.ultCambio = :ultCambio"),
    @NamedQuery(name = "Emisor.findByPadron", query = "SELECT e FROM Emisor e WHERE e.padron = :padron"),
    @NamedQuery(name = "Emisor.findByUuid", query = "SELECT e FROM Emisor e WHERE e.uuid = :uuid"),
    @NamedQuery(name = "Emisor.findByRegimenFiscal", query = "SELECT e FROM Emisor e WHERE e.regimen = :regimen")
})
public class Emisor implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_emisor")
    private Integer id;

    @Size(min = 1, max = 150)
    @Column(name = "nb_emisor")
    private String emisor;

    @Size(min = 1, max = 1)
    @Column(name = "tp_persona")
    private String tpPersona;

    @Size(min = 0, max = 150)
    @Column(name = "nb_regimen_capital")
    private String regimenCapital;

    @Size(min = 1, max = 20)
    @Column(name = "nb_rfc")
    private String rfc;

    @Column(name = "fh_inicio_op")
    private LocalDate inicioOp;

    @Column(name = "fh_ult_cambio")
    private LocalDate ultCambio;

    @Size(min = 0, max = 1)
    @Column(name = "st_padron")
    private String padron;

    @JoinColumn(name = "cd_regimen")
    @ManyToOne
    private RegimenFiscal regimen;

    @Column(name = "nu_cp")
    @Size(min = 0, max = 5)
    @Basic(optional = true)
    private String codigoPostal;

    @Column(name = "uuid")
    @Size(min = 1, max = 50)
    private String uuid = null;

    @OneToMany(mappedBy = "emisor")
    private List<Certificado> listaCertificado;

    public Emisor() {
    }
    
    public Emisor(Integer id, String emisor, String tpPersona, String regimenCapital, String rfc, LocalDate inicioOp, LocalDate ultCambio,
            String padron, RegimenFiscal regimen, String uuid, List<Certificado> listaCertificado) {
        this.id = id;
        this.emisor = emisor;
        this.tpPersona = tpPersona;
        this.regimenCapital = regimenCapital;
        this.rfc = rfc;
        this.inicioOp = inicioOp;
        this.ultCambio = ultCambio;
        this.padron = padron;
        this.regimen = regimen;
        this.uuid = uuid;
        this.listaCertificado = listaCertificado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getTpPersona() {
        return tpPersona;
    }

    public void setTpPersona(String tpPersona) {
        this.tpPersona = tpPersona;
    }

    public String getRegimenCapital() {
        return regimenCapital;
    }

    public void setRegimenCapital(String regimenCapital) {
        this.regimenCapital = regimenCapital;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public LocalDate getInicioOp() {
        return inicioOp;
    }

    public void setInicioOp(LocalDate inicioOp) {
        this.inicioOp = inicioOp;
    }

    public LocalDate getUltCambio() {
        return ultCambio;
    }

    public void setUltCambio(LocalDate ultCambio) {
        this.ultCambio = ultCambio;
    }

    public String getPadron() {
        return padron;
    }

    public void setPadron(String padron) {
        this.padron = padron;
    }

    public RegimenFiscal getRegimen() {
        return regimen;
    }

    public void setRegimen(RegimenFiscal regimen) {
        this.regimen = regimen;
    }
    
    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<Certificado> getListaCertificado() {
        return listaCertificado;
    }

    public void setListaCertificado(List<Certificado> listaCertificado) {
        this.listaCertificado = listaCertificado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Emisor)) {
            return false;
        }
        Emisor other = (Emisor) obj;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Emisor [id=" + id + ", emisor=" + emisor + ", tpPersona=" + tpPersona
                + ", regimenCapital=" + regimenCapital + ", rfc=" + rfc + ", inicioOp="
                + inicioOp + ", ultCambio=" + ultCambio + ", padron=" + padron + ", regimen="
                + regimen + ", uuid=" + uuid + ", listaCertificado=" + listaCertificado + "]";
    }

}
