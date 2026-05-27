package com.ferbo.gestion.core.model.egresos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.NamedQueries;

import com.ferbo.gestion.core.model.catalogo.egresos.CategoriaEgreso;
import com.ferbo.gestion.core.model.catalogo.egresos.StatusEgreso;
import com.ferbo.gestion.core.model.catalogo.sat.FormaPago;
import com.ferbo.gestion.core.model.catalogo.sat.MetodoPago;
import com.ferbo.gestion.core.model.facturacion.Emisor;

@Entity
@Table(name = "egreso")
@NamedQueries({
    @NamedQuery(name = "Egreso.findAll", query = "SELECT e FROM Egreso e ORDER BY e.fecha DESC"),

    @NamedQuery(name = "Egreso.findByFechaBetween", query = "SELECT e FROM Egreso e WHERE e.fecha BETWEEN :inicio AND :fin ORDER BY e.fecha DESC"),

    @NamedQuery(name = "Egreso.findByCategoria", query = "SELECT e FROM Egreso e WHERE e.categoria = :categoria ORDER BY e.fecha DESC"),

    @NamedQuery(name = "Egreso.findByStatus", query = "SELECT e FROM Egreso e WHERE e.status = :status ORDER BY e.fecha DESC"),

    @NamedQuery(name = "Egreso.searchByConcepto", query = "SELECT e FROM Egreso e WHERE LOWER(e.concepto) LIKE LOWER(CONCAT('%', :concepto, '%')) ORDER BY e.fecha DESC"),

    @NamedQuery(name = "Egreso.searchByEmisor", query = "SELECT e FROM Egreso e WHERE e.emisor = :emisor ORDER BY e.fecha DESC"),

    @NamedQuery(name = "Egreso.findWithFilters", query = "SELECT e FROM Egreso e "
            + "WHERE (:inicio IS NULL OR e.fecha >= :inicio) "
            + "AND (:fin IS NULL OR e.fecha <= :fin) "
            + "AND (:categoria IS NULL OR e.categoria = :categoria) "
            + "AND (:emisor IS NULL OR e.emisor = :emisor)"
            + "AND (:status IS NULL OR e.status = :status) "
            + "AND (:concepto IS NULL OR LOWER(e.concepto) LIKE LOWER(CONCAT('%', :concepto, '%'))) "
            + "ORDER BY e.fecha DESC")
})
public class Egreso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_egre")
    private Long id;

    @Column(name = "fh_egre", nullable =  false)
    private LocalDateTime fecha;

    @Column(name = "to_egre", nullable = false, precision = 12, scale = 2)
    private BigDecimal monto;

    @Column(name = "tx_conc", nullable = false, length = 150)
    private String concepto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_cate_egre", referencedColumnName = "cd_cate_egre", nullable = false)
    private CategoriaEgreso categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_status_egre", referencedColumnName = "cd_status_egre", nullable = false)
    private StatusEgreso status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_metodo_pago", referencedColumnName = "cd_metodo_pago", nullable = false)
    private MetodoPago metodoPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mp_id", referencedColumnName = "mp_id", nullable = false)
    private FormaPago formaPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_emisor", referencedColumnName = "cd_emsior", nullable = false)
    private Emisor emisor;

    @OneToOne(mappedBy = "egreso")
    private CancelaEgreso cancelaEgreso;

    @Column(name = "tx_refe", nullable = false, length = 150)
    private String referencia;

    @Column(name = "tm_creacion", nullable = false, updatable =  false)
    private LocalDateTime fechaCreacion;

    @Column(name = "tm_modificacion")
    private LocalDateTime fechaModificacion;

    public Egreso() {

    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public CategoriaEgreso getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEgreso categoria) {
        this.categoria = categoria;
    }

    public StatusEgreso getStatus() {
        return status;
    }

    public void setStatus(StatusEgreso status) {
        this.status = status;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Emisor getEmisor() {
        return emisor;
    }

    public void setEmisor(Emisor emisor) {
        this.emisor = emisor;
    }

    public CancelaEgreso getCancelaEgreso() {
        return cancelaEgreso;
    }

    public void setCancelaEgreso(CancelaEgreso cancelaEgreso) {
        this.cancelaEgreso = cancelaEgreso;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.fechaCreacion = now;
        this.fechaModificacion = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.fechaModificacion = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Egreso)) {
            return false;
        }

        Egreso that = (Egreso) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : System.identityHashCode(this);
    }

    @Override
    public String toString() {
        return "Egreso [id=" + id + ", fecha=" + fecha + ", monto=" + monto + ", concepto=" + concepto + ", referencia="
                + referencia + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + "]";
    }

}
