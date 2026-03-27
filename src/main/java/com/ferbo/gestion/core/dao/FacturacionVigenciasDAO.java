package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.ConstanciaDeposito;
import com.ferbo.gestion.core.model.ConstanciaDepositoDetalle;
import com.ferbo.gestion.core.model.ConstanciaFactura;
import com.ferbo.gestion.core.model.ConstanciaSalida;
import com.ferbo.gestion.core.model.DetalleConstanciaSalida;
import com.ferbo.gestion.core.model.Partida;
import com.ferbo.gestion.core.tools.DateUtils;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FacturacionVigenciasDAO extends BaseDAO<ConstanciaFactura, Integer> 
{
    private static Logger log = LogManager.getLogger(FacturacionVigenciasDAO.class);

    public FacturacionVigenciasDAO() {
        super(ConstanciaFactura.class);
    }

    public List<ConstanciaFactura> buscarNoFacturados(Integer idCliente, LocalDate fechaCorte, Integer idPlanta) 
    {
        return JpaExecutor.executeRead(em -> {
            List<ConstanciaFactura> list = new ArrayList<>();
            
            String sql = "select distinct\n"
                    + "	cdd.FOLIO, cdd.CTE_CVE, cdd.FECHA_INGRESO, cdd.NOMBRE_TRANSPORTISTA, cdd.PLACAS_TRANSPORTE, cdd.OBSERVACIONES, cdd.folio_cliente, cdd.valor_declarado, cdd.status, cdd.aviso_cve, cdd.temperatura\n"
                    + "from constancia_de_deposito cdd \n"
                    + "inner join (\n"
                    + "	select\n"
                    + "		folio, folio_cliente, vigencia_inicio, vigencia_fin, partida_cve, cantidad, peso\n"
                    + "	from (\n"
                    + "		select\n"
                    + "			folio, folio_cliente, vigencia_inicio, vigencia_fin, partida_cve,\n"
                    + "			(cantidad_total - sum(cantidad)) as cantidad,\n"
                    + "			(peso_total - sum(peso)) as peso\n"
                    + "		from (\n"
                    + "			select\n"
                    + "				cdd.folio,\n"
                    + "				cdd.folio_cliente,\n"
                    + "				cf.vigencia_inicio,\n"
                    + "				cf.vigencia_fin,\n"
                    + "				p.partida_cve,\n"
                    + "				p.cantidad_total,\n"
                    + "				p.peso_total,\n"
                    + "				sal.fecha,\n"
                    + "				coalesce(sal.cantidad, 0) as cantidad,\n"
                    + "				coalesce(sal.peso, 0) as peso\n"
                    + "			from constancia_de_deposito cdd\n"
                    + "			inner join (\n"
                    + "				select inCF.folio, max(inCF.vigencia_inicio) as vigencia_inicio, max(inCF.vigencia_fin) as vigencia_fin\n"
                    + "				from constancia_factura inCF\n"
                    + "				inner join factura inF on inCF.factura = inF.id\n"
                    + "				where inF.status not in (0,2)\n"
                    + "				and inCF.vigencia_fin < :fechaCorte\n"
                    + "				/*and inCF.folio_cliente = :folioCliente*/\n"
                    + "				group by inCF.folio\n"
                    + "			) cf on cdd.folio = cf.folio\n"
                    + "			inner join partida p on cdd.folio = p.folio\n"
                    + "			inner join camara cam on p.camara_cve = cam.camara_cve\n"
                    + "			inner join planta plt on cam.planta_cve = plt.planta_cve\n"
                    + "			left outer join (\n"
                    + "				select dcs.PARTIDA_CVE, dcs.CANTIDAD, dcs.PESO, cs.fecha\n"
                    + "				from detalle_constancia_salida dcs\n"
                    + "				inner join constancia_salida cs on dcs.constancia_cve = cs.id\n"
                    + "				where cs.status = 1\n"
                    + "			) sal on sal.partida_cve = p.partida_cve and sal.fecha <= cf.vigencia_fin\n"
                    + "			where cdd.status = 1 and cdd.cte_cve = :cteCve\n"
                    + "			and plt.planta_cve = :plantaCve\n"
                    + "		) pInv\n"
                    + "		group by folio, vigencia_inicio, vigencia_fin, partida_cve, cantidad_total, peso_total\n"
                    + "	) pInv\n"
                    + "	where pInv.cantidad > 0\n"
                    + ") inv on cdd.folio = inv.folio";

            Query query = em.createNativeQuery(sql, ConstanciaDeposito.class)
                    .setParameter("cteCve", idCliente)
                    .setParameter("fechaCorte", fechaCorte)
                    .setParameter("plantaCve", idPlanta);
            List<ConstanciaDeposito> listaConstancias = query.getResultList();

            for (ConstanciaDeposito constancia : listaConstancias) {
                log.debug("Constancia de deposito: {}", constancia.getFolioCliente());
                List<ConstanciaFactura> listaTmpConstancias = constancia.getConstanciaFacturaList();
                List<ConstanciaDepositoDetalle> allConstanciaDepositoDetalle = constancia.getConstanciaDepositoDetalleList();
                log.debug("Lista constanciaDepositoDetalle.size() = {}", allConstanciaDepositoDetalle.size());
                List<ConstanciaFactura> lConstanciaFactura = listaTmpConstancias.stream()
                        .filter(c
                                -> (c.getFactura().getStatus().getId() == 1) //Status Por cobrar
                        || (c.getFactura().getStatus().getId() == 3) //Status Pagada
                        || (c.getFactura().getStatus().getId() == 4)) //Status Pago parcial
                        .collect(Collectors.toList());

                if (lConstanciaFactura.size() <= 0) {
                    continue;
                }

                ConstanciaFactura cf = this.getConstanciaFactura(constancia, fechaCorte);

                final LocalDate vigenciaIni = cf.getVigenciaInicio();
                final LocalDate vigenciaFin = cf.getVigenciaFin();

                List<ConstanciaFactura> lCFFacturadas = lConstanciaFactura.stream()
                        .filter(c -> (c.getVigenciaInicio().equals(vigenciaIni) || c.getVigenciaFin().equals(vigenciaFin)))
                        .collect(Collectors.toList());

                log.debug("Constancias facturadas: {}", lCFFacturadas.size());
                if (lCFFacturadas.size() > 0) {
                    continue;
                }

                log.info("folio: {}, vigencia ini: {}, vigencia fin: {}", cf.getFolioCliente(), cf.getVigenciaInicio(), cf.getVigenciaFin());

                for (Partida p : constancia.getPartidaList()) {
                    BigDecimal cantidadT = new BigDecimal(p.getCantidadTotal());
                    BigDecimal pesoTotal = p.getPesoTotal();
                    BigDecimal cajasTarima = null;//cajas x Tarima
                    BigDecimal noTarimas = new BigDecimal(0);//noTarimas
                    BigDecimal tarimas = p.getNoTarimas();//cantidad_total
                    BigDecimal salidaCantidad = new BigDecimal(0), salidaPeso = new BigDecimal(0);

                    if (tarimas != null) {
                        cajasTarima = cantidadT.divide(tarimas, 2, BigDecimal.ROUND_HALF_UP);
                        log.debug("caja x tarima " + cajasTarima);
                    }

                    List<DetalleConstanciaSalida> salidasList = p.getDetalleConstanciaSalidaList();

                    for (DetalleConstanciaSalida dcs : salidasList) {

                        ConstanciaSalida constanciaSalida = new ConstanciaSalida();
                        constanciaSalida = dcs.getConstancia();//OBTENGO OBJETO SIMPLE

                        if (constanciaSalida.getStatus().getId() == 2) {
                            continue;
                        }

                        log.debug("Fecha salida:   {}  timestamp: {}", constanciaSalida.getFecha(), constanciaSalida.getFecha());
                        log.debug("Fecha vigencia: {}  timestamp: {}", cf.getVigenciaInicio(), cf.getVigenciaInicio());
                        log.debug("salida.compareTo(vigenciaIni) < 0: {}, salida.compareTo(vigenciaIni) = 0: {}, salida.compareTo(vigenciaIni) > 0: {}",
                                (constanciaSalida.getFecha().compareTo(cf.getVigenciaInicio()) < 0),
                                (constanciaSalida.getFecha().compareTo(cf.getVigenciaInicio()) == 0),
                                (constanciaSalida.getFecha().compareTo(cf.getVigenciaInicio()) > 0)
                        );

                        if (constanciaSalida.getFecha().compareTo(cf.getVigenciaInicio()) >= 0) {
                            continue;
                        }

                        BigDecimal cantidad = new BigDecimal(dcs.getCantidad());
                        BigDecimal peso = dcs.getPeso();

                        salidaCantidad = salidaCantidad.add(cantidad);//suma total de cantidad salida
                        salidaPeso = salidaPeso.add(peso);//suma total de peso salida 

                        log.debug("Fecha: " + constanciaSalida.getFecha());
                    }

                    cantidadT = cantidadT.subtract(salidaCantidad);
                    pesoTotal = pesoTotal.subtract(salidaPeso);
                    if (salidasList == null || salidasList.size() <= 0) {
                        noTarimas = p.getNoTarimas();
                    } else if (salidasList != null && salidasList.size() > 0 && tarimas != null) {
                        noTarimas = cantidadT.divide(cajasTarima, 0, RoundingMode.UP);
                    } else if (salidasList != null && salidasList.size() > 0 && tarimas == null) {
                        //TODO
                        log.info("FALTA CALCULO DE TARIMAS POR REGISTRO DE TARIMA...");
                    }

                    p.setCantidadTotal(cantidadT.intValue());
                    p.setPesoTotal(pesoTotal);
                    p.setNoTarimas(noTarimas);

                    log.debug("Folio: {}, Saldo: cantidad = {}, peso = {}, tarimas = {}", constancia.getFolioCliente(), cantidadT, pesoTotal, noTarimas);
                }
                list.add(cf);

                constancia.setConstanciaFacturaList(new ArrayList<>());
                constancia.setConstanciaFacturaList(list);

            }
            return list;
        });
    }

    private ConstanciaFactura getConstanciaFactura(ConstanciaDeposito constancia, LocalDate fechaCorte)
    {
        ConstanciaFactura cf = null;
        int vigencia = -1;
        LocalDate vigenciaInicio = null;
        LocalDate vigenciaFin = null;
        int tmpIni = 0;
        int tmpFin = 0;

        log.debug("Constancia: {}", constancia.getFolioCliente());

        vigencia = constancia.getAviso().getVigencia();
        vigenciaInicio = constancia.getFechaIngreso();
        vigenciaFin = DateUtils.fechaVencimiento(vigenciaInicio, vigencia, false);
        
        log.debug(String.format("Calculando vigencia: inicio: %s, fin: %s", vigenciaInicio.format(DateTimeFormatter.ISO_LOCAL_DATE), vigenciaFin.format(DateTimeFormatter.ISO_LOCAL_DATE)));

        if (fechaCorte.compareTo(vigenciaInicio) < 0) {
            return null;
        }

        while (vigenciaInicio.compareTo(fechaCorte) <= 0) {

            tmpIni = vigenciaInicio.compareTo(fechaCorte);
            tmpFin = vigenciaFin.compareTo(fechaCorte);

            if (tmpIni <= 0 && tmpFin >= 0) {
                break;
            }
            vigenciaInicio = vigenciaFin.plusDays(1);
            vigenciaFin = DateUtils.fechaVencimiento(vigenciaInicio, vigencia, false);
            log.debug("Constancia: {} - Vigencia: {} - {}", constancia.getFolioCliente(), vigenciaInicio, vigenciaFin);
        }

        cf = new ConstanciaFactura();
        cf.setConstanciaDeposito(constancia);
        cf.setFolioCliente(constancia.getFolioCliente());
        cf.setVigenciaInicio(vigenciaInicio);
        cf.setVigenciaFin(vigenciaFin);

        return cf;
    }

}
