package com.ferbo.gestion.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "aviso")
@NamedQueries({
        @NamedQuery(name = "Aviso.findAll", query = "SELECT a FROM Aviso a"),
        @NamedQuery(name = "Aviso.findById", query = "SELECT a FROM Aviso a WHERE a.id = :idAviso"),
        @NamedQuery(name = "Aviso.findByPo", query = "SELECT a FROM Aviso a WHERE a.po = :po"),
        @NamedQuery(name = "Aviso.findByPedimento", query = "SELECT a FROM Aviso a WHERE a.pedimento = :pedimento"),
        @NamedQuery(name = "Aviso.findBySap", query = "SELECT a FROM Aviso a WHERE a.sap = :sap"),
        @NamedQuery(name = "Aviso.findByLote", query = "SELECT a FROM Aviso a WHERE a.lote = :lote"),
        @NamedQuery(name = "Aviso.findByCaducidad", query = "SELECT a FROM Aviso a WHERE a.caducidad = :caducidad"),
        @NamedQuery(name = "Aviso.findByTarima", query = "SELECT a FROM Aviso a WHERE a.tarima = :tarima"),
        @NamedQuery(name = "Aviso.findByOtro", query = "SELECT a FROM Aviso a WHERE a.otro = :otro"),
        @NamedQuery(name = "Aviso.findByTemp", query = "SELECT a FROM Aviso a WHERE a.temp = :temp"),
        @NamedQuery(name = "Aviso.findByoFecha", query = "SELECT a FROM Aviso a WHERE a.fecha = :fecha"),
        @NamedQuery(name = "Aviso.findByObservaciones", query = "SELECT a FROM Aviso a WHERE a.observaciones = :observaciones"),
        @NamedQuery(name = "Aviso.findByVigencia", query = "SELECT a FROM Aviso a WHERE a.vigencia = :vigencia"),
        @NamedQuery(name = "Aviso.findByValSeg", query = "SELECT a FROM Aviso a WHERE a.valSeg = :valSeg"),
        @NamedQuery(name = "Aviso.findByPlazo", query = "SELECT a FROM Aviso a WHERE a.plazo = :plazo"),
        @NamedQuery(name = "Aviso.findByTpFacturacion", query = "SELECT a FROM Aviso a WHERE a.tpFacturacion = :tpFacturacion"),
        @NamedQuery(name = "Aviso.findByCliente", query = "SELECT a FROM Aviso a WHERE a.cliente.id = :idCliente")
})
public class Aviso implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aviso_cve")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "aviso_po")
    private boolean po;

    @Basic(optional = false)
    @NotNull
    @Column(name = "aviso_codigo")
    private boolean codigo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "aviso_pedimento")
    private boolean pedimento;

    @Basic(optional = false)
    @NotNull
    @Column(name = "aviso_sap")
    private boolean sap;

    @Basic(optional = false)
    @NotNull
    @Column(name = "aviso_lote")
    private boolean lote;

    @Basic(optional = false)
    @NotNull
    @Column(name = "aviso_caducidad")
    private boolean caducidad;

    @Basic(optional = false)
    @NotNull
    @Column(name = "aviso_tarima")
    private boolean tarima;

    @Basic(optional = false)
    @NotNull
    @Column(name = "aviso_otro")
    private boolean otro;

    @Size(max = 50)
    @Column(name = "aviso_temp")
    private String temp;

    @Basic(optional = false)
    @NotNull
    @Column(name = "aviso_fecha")
    private LocalDate fecha;

    @Size(max = 255)
    @Column(name = "aviso_observaciones")
    private String observaciones;

    @Basic(optional = false)
    @NotNull
    @Column(name = "aviso_vigencia")
    private int vigencia;

    @Column(name = "aviso_val_seg")
    @Basic(optional = true)
    private BigDecimal valSeg;

    @Basic(optional = false)
    @NotNull
    @Column(name = "aviso_plazo")
    private int plazo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "aviso_tp_facturacion")
    private String tpFacturacion;

    @JoinColumn(name = "cte_cve", referencedColumnName = "CTE_CVE")
    @ManyToOne
    private Cliente cliente;

    @JoinColumn(name = "planta_cve", referencedColumnName = "PLANTA_CVE")
    @ManyToOne
    @Basic(optional = true)
    private Planta planta;

    @ManyToOne
    @JoinColumn(name = "categoria_cve", referencedColumnName = "categoria_cve")
    @Basic(optional = true)
    private Categoria categoria;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aviso", orphanRemoval = true)
    private List<PrecioServicio> precioServicioList;
    
    public Aviso() {
    }

    public Aviso(Integer id) {
        this.id = id;
    }

    public Aviso(Integer id, boolean po, boolean pedimento, boolean sap, boolean lote,
            boolean caducidad, boolean tarima, boolean otro, LocalDate fecha, int vigencia,
            int plazo, String tpFacturacion) {
        this.id = id;
        this.po = po;
        this.pedimento = pedimento;
        this.sap = sap;
        this.lote = lote;
        this.caducidad = caducidad;
        this.tarima = tarima;
        this.otro = otro;
        this.fecha = fecha;
        this.vigencia = vigencia;
        this.plazo = plazo;
        this.tpFacturacion = tpFacturacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isPo() {
        return po;
    }

    public void setPo(boolean po) {
        this.po = po;
    }

    public boolean isCodigo() {
        return codigo;
    }

    public void setCodigo(boolean codigo) {
        this.codigo = codigo;
    }

    public boolean isPedimento() {
        return pedimento;
    }

    public void setPedimento(boolean pedimento) {
        this.pedimento = pedimento;
    }

    public boolean isSap() {
        return sap;
    }

    public void setSap(boolean sap) {
        this.sap = sap;
    }

    public boolean isLote() {
        return lote;
    }

    public void setLote(boolean lote) {
        this.lote = lote;
    }

    public boolean isCaducidad() {
        return caducidad;
    }

    public void setCaducidad(boolean caducidad) {
        this.caducidad = caducidad;
    }

    public boolean isTarima() {
        return tarima;
    }

    public void setTarima(boolean tarima) {
        this.tarima = tarima;
    }

    public boolean isOtro() {
        return otro;
    }

    public void setOtro(boolean otro) {
        this.otro = otro;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    public BigDecimal getValSeg() {
        return valSeg;
    }

    public void setValSeg(BigDecimal valSeg) {
        this.valSeg = valSeg;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public String getTpFacturacion() {
        return tpFacturacion;
    }

    public void setTpFacturacion(String tpFacturacion) {
        this.tpFacturacion = tpFacturacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlantaCve(Planta planta) {
        this.planta = planta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoriaCve(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<PrecioServicio> getPrecioServicioList() {
        return precioServicioList;
    }

    public void setPrecioServicioList(List<PrecioServicio> precioServicioList) {
        this.precioServicioList = precioServicioList;
    }

    public void add(PrecioServicio ps) {
        precioServicioList.add(ps);
        ps.setAviso(this);
        ps.setCliente(this.cliente);
    }

    public void remove(PrecioServicio ps) {
        precioServicioList.remove(ps);
        ps.setAviso(null);
        ps.setCliente(null);
        ps.setServicio(null);
        ps.setUnidad(null);
    }
    
    @Override
    public int hashCode() {
    	if(this.id == null)
    		return System.identityHashCode(this);
    	return Objects.hashCode(this.id);
    }

    @Override
    public boolean equals(Object o) {
    	if (this == o)
    		return true;
    	if (!(o instanceof Aviso))
    		return false;
    	Aviso other = (Aviso) o;
    	
    	if (this.id != null && other.id != null) {
    		return Objects.equals(this.id, other.id);
    	} else {
    		return this == other;
    	}
    }

    @Override
    public String toString() {
        return "com.ferbo.gestion.core.model.Aviso[ avisoCve=" + id + " ]";
    }
    
}

