package com.ferbo.gestion.core.model.sistema;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "bitacora")
@NamedQueries({
    @NamedQuery(name = "Bitacora.findAll", query = "SELECT b FROM Bitacora b"),
    @NamedQuery(name = "Bitacora.findByIdBitacora", query = "SELECT b FROM Bitacora b WHERE b.id = :idBitacora"),
    @NamedQuery(name = "Bitacora.findByIdUsuario", query = "SELECT b FROM Bitacora b WHERE b.idUsuario = :idUsuario"),
    @NamedQuery(name = "Bitacora.findByUsuario", query = "SELECT b FROM Bitacora b WHERE b.usuario = :usuario"),
    @NamedQuery(name = "Bitacora.findByUsuarioNombre", query = "SELECT b FROM Bitacora b WHERE b.usuarioNombre = :usuarioNombre"),
    @NamedQuery(name = "Bitacora.findByHostIp", query = "SELECT b FROM Bitacora b WHERE b.hostIp = :hostIp"),
    @NamedQuery(name = "Bitacora.findByHostNombre", query = "SELECT b FROM Bitacora b WHERE b.hostNombre = :hostNombre"),
    @NamedQuery(name = "Bitacora.findByCteCve", query = "SELECT b FROM Bitacora b WHERE b.cteCve = :cteCve"),
    @NamedQuery(name = "Bitacora.findByNumeroCte", query = "SELECT b FROM Bitacora b WHERE b.numeroCte = :numeroCte"),
    @NamedQuery(name = "Bitacora.findByCteNombre", query = "SELECT b FROM Bitacora b WHERE b.cteNombre = :cteNombre"),
    @NamedQuery(name = "Bitacora.findByCteRfc", query = "SELECT b FROM Bitacora b WHERE b.cteRfc = :cteRfc"),
    @NamedQuery(name = "Bitacora.findByModuloNombre", query = "SELECT b FROM Bitacora b WHERE b.moduloNombre = :moduloNombre"),
    @NamedQuery(name = "Bitacora.findByAccion", query = "SELECT b FROM Bitacora b WHERE b.accion = :accion"),
    @NamedQuery(name = "Bitacora.findByValorAntNombre", query = "SELECT b FROM Bitacora b WHERE b.valorAntNombre = :valorAntNombre"),
    @NamedQuery(name = "Bitacora.findByValorAnt", query = "SELECT b FROM Bitacora b WHERE b.valorAnt = :valorAnt"),
    @NamedQuery(name = "Bitacora.findByValorActNombre", query = "SELECT b FROM Bitacora b WHERE b.valorActNombre = :valorActNombre"),
    @NamedQuery(name = "Bitacora.findByValorAct", query = "SELECT b FROM Bitacora b WHERE b.valorAct = :valorAct"),
    @NamedQuery(name = "Bitacora.findByOtroDato", query = "SELECT b FROM Bitacora b WHERE b.otroDato = :otroDato"),
    @NamedQuery(name = "Bitacora.findByFechaCambio", query = "SELECT b FROM Bitacora b WHERE b.fechaCambio = :fechaCambio")
})
public class Bitacora implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_bitacora")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "usuario")
    private String usuario;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usuario_nombre")
    private String usuarioNombre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "host_ip")
    private String hostIp;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "host_nombre")
    private String hostNombre;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "cte_cve")
    private int cteCve;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numero_cte")
    private String numeroCte;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "cte_nombre")
    private String cteNombre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cte_rfc")
    private String cteRfc;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "modulo_nombre")
    private String moduloNombre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "accion")
    private String accion;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "valor_ant_nombre")
    private String valorAntNombre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "valor_ant")
    private String valorAnt;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "valor_act_nombre")
    private String valorActNombre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "valor_act")
    private String valorAct;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "otro_dato")
    private String otroDato;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_cambio")
    private LocalDateTime fechaCambio;

    public Bitacora() {
    }

    public Bitacora(Integer id) {
        this.id = id;
    }

    public Bitacora(Integer id, int idUsuario, String usuario, String usuarioNombre, String hostIp, String hostNombre, int cteCve, String numeroCte, String cteNombre, String cteRfc, String moduloNombre, String accion, String valorAntNombre, String valorAnt, String valorActNombre, String valorAct, String otroDato, LocalDateTime fechaCambio) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.usuarioNombre = usuarioNombre;
        this.hostIp = hostIp;
        this.hostNombre = hostNombre;
        this.cteCve = cteCve;
        this.numeroCte = numeroCte;
        this.cteNombre = cteNombre;
        this.cteRfc = cteRfc;
        this.moduloNombre = moduloNombre;
        this.accion = accion;
        this.valorAntNombre = valorAntNombre;
        this.valorAnt = valorAnt;
        this.valorActNombre = valorActNombre;
        this.valorAct = valorAct;
        this.otroDato = otroDato;
        this.fechaCambio = fechaCambio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public String getHostNombre() {
        return hostNombre;
    }

    public void setHostNombre(String hostNombre) {
        this.hostNombre = hostNombre;
    }

    public int getCteCve() {
        return cteCve;
    }

    public void setCteCve(int cteCve) {
        this.cteCve = cteCve;
    }

    public String getNumeroCte() {
        return numeroCte;
    }

    public void setNumeroCte(String numeroCte) {
        this.numeroCte = numeroCte;
    }

    public String getCteNombre() {
        return cteNombre;
    }

    public void setCteNombre(String cteNombre) {
        this.cteNombre = cteNombre;
    }

    public String getCteRfc() {
        return cteRfc;
    }

    public void setCteRfc(String cteRfc) {
        this.cteRfc = cteRfc;
    }

    public String getModuloNombre() {
        return moduloNombre;
    }

    public void setModuloNombre(String moduloNombre) {
        this.moduloNombre = moduloNombre;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getValorAntNombre() {
        return valorAntNombre;
    }

    public void setValorAntNombre(String valorAntNombre) {
        this.valorAntNombre = valorAntNombre;
    }

    public String getValorAnt() {
        return valorAnt;
    }

    public void setValorAnt(String valorAnt) {
        this.valorAnt = valorAnt;
    }

    public String getValorActNombre() {
        return valorActNombre;
    }

    public void setValorActNombre(String valorActNombre) {
        this.valorActNombre = valorActNombre;
    }

    public String getValorAct() {
        return valorAct;
    }

    public void setValorAct(String valorAct) {
        this.valorAct = valorAct;
    }

    public String getOtroDato() {
        return otroDato;
    }

    public void setOtroDato(String otroDato) {
        this.otroDato = otroDato;
    }

    public LocalDateTime getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(LocalDateTime fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bitacora)) {
            return false;
        }
        Bitacora other = (Bitacora) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Bitacora[ id=" + id + " ]";
    }
    
}
