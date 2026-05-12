package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cfdi")
public class Cfdi implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cfdi_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_factura", referencedColumnName = "id")
    private Factura factura;

    @Column(name = "cfdi_uuid")
    @Basic(optional = false)
    @Size(max = 36)
    private String uuid;

    @Column(name = "cfdi_fecha")
    @Basic(optional = false)
    private LocalDateTime fecha;

    @Column(name = "cfdi_cert_sat")
    @Basic(optional = false)
    @Size(max = 20)
    private String certificadoSAT;

    public Cfdi() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getCertificadoSAT() {
        return certificadoSAT;
    }

    public void setCertificadoSAT(String certificadoSAT) {
        this.certificadoSAT = certificadoSAT;
    }

    public static Builder builder() {
        return new Builder();
    }

    private Cfdi(Builder builder) {
        this.id = builder.id;
        this.factura = builder.factura;
        this.uuid = builder.uuid;
        this.fecha = builder.fecha;
        this.certificadoSAT = builder.certificadoSAT;
    }

    public static final class Builder {

        private Integer id;
        private Factura factura;
        private String uuid;
        private LocalDateTime fecha;
        private String certificadoSAT;

        private Builder() {
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder factura(Factura factura) {
            this.factura = factura;
            return this;
        }

        public Builder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder fecha(LocalDateTime fecha) {
            this.fecha = fecha;
            return this;
        }

        public Builder certificadoSAT(String certificadoSAT) {
            this.certificadoSAT = certificadoSAT;
            return this;
        }

        public Cfdi build() {
            return new Cfdi(this);
        }
    }
    
    @Override
    public int hashCode() {
        if (this.id == null) {
            return System.identityHashCode(this);
        }
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Cfdi other = (Cfdi) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Cfdi[id=" + id + ", uuid=" + uuid + ", fecha=" + fecha + ", certificadoSAT=" + certificadoSAT + "]";
    }
    
}
