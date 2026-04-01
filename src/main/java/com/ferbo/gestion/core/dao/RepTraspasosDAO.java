package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.tools.JpaExecutor;
import com.ferbo.gestion.core.ui.RepTraspasos;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RepTraspasosDAO extends BaseDAO<RepTraspasos, Integer> 
{
    private static Logger log = LogManager.getLogger(RepTraspasosDAO.class);

    public RepTraspasosDAO() {
        super(RepTraspasos.class);
    }
    
    public List<RepTraspasos> buscar(LocalDate fechaIni, LocalDate fechaFin, Integer idCliente) 
    {
        return JpaExecutor.executeRead(em -> {
            String sql = "SELECT "
                    + "	c.numero_cte, "
                    + "	c.cte_nombre, "
                    + "	ct.numero, "
                    + "	ct.fecha, "
                    + "	ct.observacion, "
                    + "	tp.constancia, "
                    + "	tp.origen, "
                    + "	tp.destino, "
                    + "	tp.cantidad, "
                    + "	tp.descripcion, "
                    + "	p.folio, "
                    + "	prd.producto_ds, "
                    + "	um.unidad_de_manejo_ds "
                    + "FROM constancia_traspaso ct "
                    + "INNER JOIN traspaso_partida tp ON ct.id = tp.traspaso "
                    + "INNER JOIN partida p ON tp.partida = p.PARTIDA_CVE "
                    + "INNER JOIN unidad_de_producto up ON p.UNIDAD_DE_PRODUCTO_CVE = up.UNIDAD_DE_PRODUCTO_CVE "
                    + "INNER JOIN unidad_de_manejo um ON up.UNIDAD_DE_MANEJO_CVE = um.UNIDAD_DE_MANEJO_CVE "
                    + "INNER JOIN producto prd ON up.PRODUCTO_CVE = prd.PRODUCTO_CVE "
                    + "INNER JOIN cliente c ON ct.cliente = c.cte_cve "
                    + "WHERE (ct.fecha BETWEEN :fechaIni AND :fechaFin) "
                    + "AND (ct.cliente = :idCliente OR :idCliente IS NULL) "
                    + "ORDER BY c.cte_nombre ASC, ct.fecha ASC,	ct.numero ASC, p.folio ASC ";

            List<Object[]> results = em.createNativeQuery(sql)
                    .setParameter("fechaIni", fechaIni)
                    .setParameter("fechaFin", fechaFin)
                    .setParameter("idCliente", idCliente)
                    .getResultList();

            List<RepTraspasos> resultList = new ArrayList<RepTraspasos>();
            for (Object[] o : results) {
                RepTraspasos r = new RepTraspasos();
                int idx = 0;

                r.setNumeroCliente((String) o[idx++]);
                r.setNombreCliente((String) o[idx++]);
                r.setNumero((String) o[idx++]);
                r.setFecha((LocalDate) o[idx++]);
                r.setObservacion((String) o[idx++]);
                r.setConstancia((String) o[idx++]);
                r.setOrigen((String) o[idx++]);
                r.setDestino((String) o[idx++]);
                r.setCantidad((BigDecimal) o[idx++]);
                r.setDescripcion((String) o[idx++]);
                r.setFolio((Integer) o[idx++]);
                r.setProductoDescripcion((String) o[idx++]);
                r.setUnidadDeManejo((String) o[idx++]);

                resultList.add(r);
            }

            return resultList;
        });
    }

}
