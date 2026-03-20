package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "medio_pago")
@NamedQueries({
    @NamedQuery(name = "MedioPago.findAll", query = "SELECT m FROM MedioPago m ORDER BY m.descripcion, m.vigenciaInicio, m.vigenciaFin"),
    @NamedQuery(name = "MedioPago.findByMpId", query = "SELECT m FROM MedioPago m WHERE m.id = :idMedioPago"),
    @NamedQuery(name = "MedioPago.findByMpDescripcion", query = "SELECT m FROM MedioPago m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "MedioPago.findVigentes", query = "SELECT m FROM MedioPago m WHERE m.vigenciaInicio <= :fecha AND (m.vigenciaFin IS NULL OR m.vigenciaFin >= :fecha) ORDER BY m.descripcion"),
    @NamedQuery(name = "MedioPago.findByMpReqReferencia", query = "SELECT m FROM MedioPago m WHERE m.reqReferencia = :reqReferencia"),
    @NamedQuery(name = "MedioPago.findBympformaPago", query = "SELECT m FROM MedioPago m WHERE m.formaPago = :mpformaPago")
})
public class MedioPago implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mp_id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "mp_descripcion")
    private String descripcion;

    @Basic(optional = false)
    @NotNull
    @Column(name = "mp_req_referencia")
    private boolean reqReferencia;

    @Column(name = "mp_forma_pago")
    @Size(min = 1, max = 5)
    private String formaPago = null;

    @Column(name = "mp_fh_vigencia_ini")
    @Temporal(TemporalType.DATE)
    private Date vigenciaInicio = null;

    @Column(name = "mp_fh_vigencia_fin")
    @Temporal(TemporalType.DATE)
    private Date vigenciaFin = null;

    public MedioPago() {
    }

    public MedioPago(Integer id) {
        this.id = id;
    }

    public MedioPago(Integer id, String descripcion, boolean reqReferencia) {
        this.id = id;
        this.descripcion = descripcion;
        this.reqReferencia = reqReferencia;
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

    public boolean isReqReferencia() {
        return reqReferencia;
    }

    public void setReqReferencia(boolean reqReferencia) {
        this.reqReferencia = reqReferencia;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Date getVigenciaInicio() {
        return vigenciaInicio;
    }

    public void setVigenciaInicio(Date vigenciaInicio) {
        this.vigenciaInicio = vigenciaInicio;
    }

    public Date getVigenciaFin() {
        return vigenciaFin;
    }

    public void setVigenciaFin(Date vigenciaFin) {
        this.vigenciaFin = vigenciaFin;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedioPago)) {
            return false;
        }
        MedioPago other = (MedioPago) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.ferbo.model.MedioPago[ id=" + id + " ]";
    }

}
