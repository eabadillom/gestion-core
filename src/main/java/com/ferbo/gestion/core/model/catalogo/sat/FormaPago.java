package com.ferbo.gestion.core.model.catalogo.sat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**En la versión anterior del sistema de inventarios, esta tabla se denominó "medio_pago", previo a la implementación
 * de la facturación electrónica del SAT. Una vez que se incorpora la facturación electrónica al sistema, se toma
 * esta tabla para almacenar la información de las "Formas de pago" reconocidas por el SAT. 
 */
@Entity
@Table(name = "medio_pago") //La tabla debería actualizarse a "forma_pago"
@NamedQuery(name = "FormaPago.findVigentes", query = "SELECT m FROM FormaPago m WHERE m.vigenciaInicio <= :fecha AND (m.vigenciaFin IS NULL OR m.vigenciaFin >= :fecha) ORDER BY m.descripcion")
public class FormaPago implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mp_id")
    private Integer id;
    
    @Column(name = "mp_forma_pago")
    @Size(min = 1, max = 5)
    private String clave = null;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "mp_descripcion")
    private String descripcion;

    @Basic(optional = false)
    @NotNull
    @Column(name = "mp_req_referencia")
    private Boolean requiereReferencia;

    @Column(name = "mp_fh_vigencia_ini")
    private LocalDate vigenciaInicio = null;

    @Column(name = "mp_fh_vigencia_fin")
    private LocalDate vigenciaFin = null;

    public FormaPago() {
    }

    public FormaPago(Integer id) {
        this.id = id;
    }

    public FormaPago(Integer id, String descripcion, boolean requiereReferencia) {
        this.id = id;
        this.descripcion = descripcion;
        this.requiereReferencia = requiereReferencia;
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
    
    public Boolean getRequiereReferencia() {
		return requiereReferencia;
	}

	public void setRequiereReferencia(Boolean requiereReferencia) {
		this.requiereReferencia = requiereReferencia;
	}

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public LocalDate getVigenciaInicio() {
        return vigenciaInicio;
    }

    public void setVigenciaInicio(LocalDate vigenciaInicio) {
        this.vigenciaInicio = vigenciaInicio;
    }

    public LocalDate getVigenciaFin() {
        return vigenciaFin;
    }

    public void setVigenciaFin(LocalDate vigenciaFin) {
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
        if (!(object instanceof FormaPago)) {
            return false;
        }
        FormaPago other = (FormaPago) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.MedioPago[ id=" + id + " ]";
    }

}
