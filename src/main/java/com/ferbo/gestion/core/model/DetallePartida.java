package com.ferbo.gestion.core.model;

import java.math.BigDecimal;
<<<<<<< Updated upstream
import java.util.Date;

public class DetallePartida {
	private Integer idDetallePartida = null;
	private Integer idPartida = null;
	private Integer idTipoMovimiento = null;
	private Integer IdEstadoMovimiento = null;
	private Integer idDetalleAnterior = null;
	private Integer idPartidaAnterior = null;
	private Integer idDetallePadre = null;
	private Integer idPartidaPadre = null;
	private Integer cantidad = null;
	private Integer idUnidadMedida = null;
	private BigDecimal peso = null;
	private String codigo = null;
	private String lote = null;
	private Date caducidad = null;
	private String po = null;
	private String mp = null;
	private String pedimento = null;
	private String sap = null;
	private String tarimas = null;
	
	public Integer getIdDetallePartida() {
		return idDetallePartida;
	}
	public void setIdDetallePartida(Integer idDetallePartida) {
		this.idDetallePartida = idDetallePartida;
	}
	public Integer getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(Integer idPartida) {
		this.idPartida = idPartida;
	}
	public Integer getIdTipoMovimiento() {
		return idTipoMovimiento;
	}
	public void setIdTipoMovimiento(Integer idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
	}
	public Integer getIdEstadoMovimiento() {
		return IdEstadoMovimiento;
	}
	public void setIdEstadoMovimiento(Integer idEstadoMovimiento) {
		IdEstadoMovimiento = idEstadoMovimiento;
	}
	public Integer getIdDetalleAnterior() {
		return idDetalleAnterior;
	}
	public void setIdDetalleAnterior(Integer idDetalleAnterior) {
		this.idDetalleAnterior = idDetalleAnterior;
	}
	public Integer getIdPartidaAnterior() {
		return idPartidaAnterior;
	}
	public void setIdPartidaAnterior(Integer idPartidaAnterior) {
		this.idPartidaAnterior = idPartidaAnterior;
	}
	public Integer getIdDetallePadre() {
		return idDetallePadre;
	}
	public void setIdDetallePadre(Integer idDetallePadre) {
		this.idDetallePadre = idDetallePadre;
	}
	public Integer getIdPartidaPadre() {
		return idPartidaPadre;
	}
	public void setIdPartidaPadre(Integer idPartidaPadre) {
		this.idPartidaPadre = idPartidaPadre;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getIdUnidadMedida() {
		return idUnidadMedida;
	}
	public void setIdUnidadMedida(Integer idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}
	public BigDecimal getPeso() {
		return peso;
	}
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public Date getCaducidad() {
		return caducidad;
	}
	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}
	public String getPo() {
		return po;
	}
	public void setPo(String po) {
		this.po = po;
	}
	public String getMp() {
		return mp;
	}
	public void setMp(String mp) {
		this.mp = mp;
	}
	public String getPedimento() {
		return pedimento;
	}
	public void setPedimento(String pedimento) {
		this.pedimento = pedimento;
	}
	public String getSap() {
		return sap;
	}
	public void setSap(String sap) {
		this.sap = sap;
	}
	public String getTarimas() {
		return tarimas;
	}
	public void setTarimas(String tarimas) {
		this.tarimas = tarimas;
	}
	
=======
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Datos Informativos de la Mercancía
 * Cada producto registrado en el sistema cuenta con un conjunto de campos que permiten su identificación, trazabilidad y control legal, los cuales se pueden agrupar en tres categorías:
 * 1. Identificación del Producto
 * 
 * Código: Clave interna asignada por el almacén para identificar el producto dentro de su propio sistema.
 * SAP: Clave con la que el cliente identifica ese mismo producto en su sistema ERP (SAP). Se captura de forma manual, ya que el sistema no cuenta con integración directa con SAP.
 * 
 * 2. Trazabilidad Logística
 * 
 * PO (Purchase Order): Orden de compra que el cliente generó para adquirir la mercancía con su proveedor en el extranjero. Representa el origen de la operación.
 * Contenedor: Unidad de transporte en la que llegó la mercancía al país.
 * Tarima: Pallet físico sobre el que se encuentra almacenada la mercancía dentro de la bodega.
 * Lote: Agrupación interna del producto para su control y seguimiento.
 * Caducidad: Fecha de vencimiento o vida útil del producto.
 * 
 * 3. Control Aduanal
 * 
 * MP (Mercancía de Procedencia Extranjera): Indicador que señala que la mercancía fue importada, lo cual implica obligaciones legales tanto para el cliente como para el almacén.
 * Pedimento: Documento oficial emitido por el SAT a través de un Agente Aduanal, que certifica la entrada legal de la mercancía a México. Es el documento más importante desde el punto de vista legal, ya que ampara la mercancía ante cualquier revisión de autoridades aduaneras.
 * 
 * 
 * Flujo de la Mercancía
 * Estos campos en conjunto narran la historia completa de cada producto:
 * PO → Contenedor → Pedimento → Almacén (Código / SAP) → Tarima → Lote / Caducidad
 * Desde que el cliente la ordenó a su proveedor, hasta que está físicamente resguardada en la bodega, debidamente documentada y localizable.
 * 
 */
@Entity
@Table(name = "detalle_partida")
@NamedQuery(name = "DetallePartida.findByIdPartida", query = "SELECT d FROM DetallePartida d WHERE d.key.partida.id = :idPartida")
public class DetallePartida implements Serializable, Cloneable {

    private static final long serialVersionUID = 3123001101308610325L;

	@EmbeddedId
    private DetallePartidaPK key;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumns({
        @JoinColumn(name = "det_anterior",      referencedColumnName = "DET_PART_CVE"),
        @JoinColumn(name = "det_part_anterior", referencedColumnName = "PARTIDA_CVE")})
    private DetallePartida detalleAnterior;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumns({
    	@JoinColumn(name = "det_padre",      referencedColumnName = "DET_PART_CVE"),
    	@JoinColumn(name = "det_part_padre", referencedColumnName = "PARTIDA_CVE")
    })
    private DetallePartida detallePadre;
    
    @Column(name = "cantidad_u_manejo")
    private Integer cantidad;

    @Column(name = "cantidad_u_medida")
    private BigDecimal peso;

    @Size(max = 12)
    @Column(name = "dtp_codigo")
    private String codigo;

    @Size(max = 20)
    @Column(name = "dtp_lote")
    private String lote;

    @Column(name = "dtp_caducidad")
    private LocalDate caducidad;

    @Size(max = 12)
    @Column(name = "dtp_PO")
    private String po;

    @Size(max = 20)
    @Column(name = "dtp_MP")
    private String mp;

    @Size(max = 13)
    @Column(name = "dtp_pedimento")
    private String pedimento;

    @Size(max = 20)
    @Column(name = "dtp_SAP")
    private String sap;

    @Size(max = 15)
    @Column(name = "dtp_tarimas")
    private String tarimas;

    @JoinColumn(name = "tipo_mov_cve", referencedColumnName = "CLAVE")
    @ManyToOne(cascade = CascadeType.DETACH)
    private TipoMovimiento tipoMovimiento;

    @JoinColumn(name = "u_medida_cve", referencedColumnName = "UNIDAD_DE_MANEJO_CVE")
    @ManyToOne
    private UnidadManejo unidad;

    @JoinColumn(name = "edo_inv_cve", referencedColumnName = "edo_inv_cve")
    @ManyToOne(cascade = CascadeType.DETACH)
    private EstadoInventario estadoInventario;

    public DetallePartida() {
    }

    public DetallePartida(DetallePartidaPK primaryKey) {
        this.key = primaryKey;
    }

    public DetallePartida(int idDetallePartida, Partida idPartida) {
        this.key = new DetallePartidaPK(idDetallePartida, idPartida);
    }

    public DetallePartidaPK getKey() {
        return key;
    }

    public void setKey(DetallePartidaPK primaryKey) {
        this.key = primaryKey;
    }

    public DetallePartida getDetallePadre() {
    	return this.detallePadre;
    }
    
    public void setDetallePadre(DetallePartida detallePadre) {
    	this.detallePadre = detallePadre;
    }
    
    public DetallePartida getDetalleAnterior() {
        return detalleAnterior;
    }

    public void setDetalleAnterior(DetallePartida detalleAnterior) {
        this.detalleAnterior = detalleAnterior;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public LocalDate getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(LocalDate caducidad) {
        this.caducidad = caducidad;
    }

    public String getPO() {
        return po;
    }

    public void setPO(String po) {
        this.po = po;
    }

    public String getMP() {
        return mp;
    }

    public void setMP(String mp) {
        this.mp = mp;
    }

    public String getPedimento() {
        return pedimento;
    }

    public void setPedimento(String pedimento) {
        this.pedimento = pedimento;
    }

    public String getSAP() {
        return sap;
    }

    public void setSAP(String dtpSAP) {
        this.sap = dtpSAP;
    }

    public String getTarimas() {
        return tarimas;
    }

    public void setTarimas(String dtpTarimas) {
        this.tarimas = dtpTarimas;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public UnidadManejo getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadManejo unidadMedida) {
        this.unidad = unidadMedida;
    }

    public EstadoInventario getEdoInventario() {
        return estadoInventario;
    }

    public void setEdoInventario(EstadoInventario edoInventario) {
        this.estadoInventario = edoInventario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (key != null ? key.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DetallePartida)) {
            return false;
        }
        DetallePartida other = (DetallePartida) object;
        if ((this.key == null && other.key != null) || (this.key != null && !this.key.equals(other.key))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.DetallePartida[ detallePartidaPK=" + key + " ]";
    }

    @Override
    public DetallePartida clone() throws CloneNotSupportedException {
        DetallePartida dp = null;

        dp = new DetallePartida();
        dp.setKey(new DetallePartidaPK());
        dp.setCantidad(this.cantidad == null ? null : new Integer(this.cantidad));
        dp.setPeso(this.peso);
        dp.setCodigo(this.codigo);
        dp.setLote(this.lote);
        dp.setCaducidad(this.caducidad == null ? null : this.caducidad);
        dp.setPO(this.getPO());
        dp.setMP(this.mp);
        dp.setPedimento(this.pedimento);
        dp.setSAP(this.sap);
        dp.setTarimas(this.tarimas);
        dp.setDetalleAnterior(this.detalleAnterior);
        if (this.getTipoMovimiento() != null) {
            dp.setTipoMovimiento(this.tipoMovimiento);
        }

        if (this.unidad != null) {
            dp.setUnidad(this.unidad);
        }

        if (this.estadoInventario != null) {
            dp.setEdoInventario(this.estadoInventario);
        }

        return dp;
    }
    
>>>>>>> Stashed changes
}
