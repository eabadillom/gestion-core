package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.ui.OcupacionCamara;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class RepOcupacionCamaraDAO extends BaseDAO<OcupacionCamara, Integer> 
{
    private static Logger log = LogManager.getLogger(RepOcupacionCamaraDAO.class);

    public RepOcupacionCamaraDAO(TransactionManager transactManager) {
        super(OcupacionCamara.class, transactManager);
    }
    
    public List<OcupacionCamara> ocupacionCamara(LocalDate fecha, Integer idCliente, Integer idPlanta, Integer idCamara) 
    {
        return transactManager.executeRead(em -> {
            String sql = "select "
                    + "*, "
                    + "(I.total_pos - I.tarima) AS posiciones_Disponibles "
                    + "from "
                    + "( "
                    + "select "
                    + "cam.CAMARA_CVE AS camara_cve, "
                    + "cam.CAMARA_ABREV AS camara_abrev, "
                    + "cam.CAMARA_DS AS camara_ds, "
                    + "plt.PLANTA_DS AS planta_ds, "
                    + "SUM(CEILING((parEnt.cantidad_total - COALESCE(salidas.cantidad, 0)) * parEnt.no_tarimas / parEnt.CANTIDAD_TOTAL )) as tarima, "
                    + "cam.total_posiciones AS total_pos "
                    + "from "
                    + "partida parEnt "
                    + "inner join ( "
                    + "select * "
                    + "from "
                    + "constancia_de_deposito cdd "
                    + "WHERE (cdd.cte_cve = :idCliente OR :idCliente IS NULL) AND cdd.fecha_ingreso <= :Fecha "
                    + ") cddEnt on parEnt.folio = cddEnt.folio "
                    + "inner join unidad_de_producto udp on udp.unidad_de_producto_cve = parEnt.unidad_de_producto_cve "
                    + "inner join producto prd on prd.producto_cve = udp.producto_cve "
                    + "inner join unidad_de_manejo udm on udm.unidad_de_manejo_cve = udp.unidad_de_manejo_cve "
                    + "inner join camara cam on cam.camara_cve = parEnt.camara_cve "
                    + "inner join planta plt on plt.planta_cve = cam.planta_cve "
                    + "inner join cliente cli on cli.cte_cve = cddEnt.cte_cve "
                    + "left outer join posicion_partida pp on parEnt.partida_cve = pp.ID_PARTIDA "
                    + "left outer join posicion pos on pp.ID_POSICION = pos.id_posicion "
                    + "left outer join ( "
                    + "select "
                    + "dcs.partida_cve, sum(COALESCE(dcs.peso, 0)) as peso, sum(COALESCE(dcs.cantidad, 0)) as cantidad "
                    + "from "
                    + "constancia_salida cSal "
                    + "inner join detalle_constancia_salida dcs on dcs.constancia_cve = cSal.id "
                    + "WHERE cSal.status = 1 AND cSal.fecha <= :Fecha "
                    + "group by dcs.PARTIDA_CVE "
                    + ") salidas ON parEnt.partida_cve = salidas.partida_cve "
                    + "WHERE cddEnt.status <> 4 AND (cam.camara_cve = :idCamara OR :idCamara IS NULL ) "
                    + "AND (plt.planta_cve = :idPlanta OR :idPlanta IS NULL ) "
                    + "GROUP BY camara_cve, camara_ds, camara_abrev, planta_ds "
                    + "ORDER BY camara_cve "
                    + ") I "
                    + "WHERE tarima > 0 "
                    + "GROUP BY I.camara_cve, I.camara_ds, I.camara_abrev, I.planta_ds";

            Query query = em.createNativeQuery(sql)
                    .setParameter("Fecha", fecha)
                    .setParameter("idCliente", idCliente)
                    .setParameter("idCamara", idCamara)
                    .setParameter("idPlanta", idPlanta);

            List<Object[]> listaObjetos = query.getResultList();
            List<OcupacionCamara> listaOcupacionCamara = new ArrayList<OcupacionCamara>();
            
            for (Object[] o : listaObjetos) {
                OcupacionCamara oc = new OcupacionCamara();
                int id = 0;

                oc.setCamara_cve((Integer) o[id++]);
                oc.setCamara_abrev((String) o[id++]);
                oc.setCamara_ds((String) o[id++]);
                oc.setPlanta_ds((String) o[id++]);
                oc.setTarima((BigDecimal) o[id++]);//setear al objeto total posiciones y posiciones disponibles
                oc.setTotal_pos((Integer) o[id++]);
                oc.setPosiciones_Disponibles((BigDecimal) o[id++]);

                listaOcupacionCamara.add(oc);
            }

            return listaOcupacionCamara;
        });
    }
    
}
