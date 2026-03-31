package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.tools.JpaExecutor;
import com.ferbo.gestion.core.ui.RepEstadoCuenta;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RepEstadoCuentaDAO extends BaseDAO<RepEstadoCuenta, Integer> 
{
    private static Logger log = LogManager.getLogger(RepEstadoCuentaDAO.class);

    public RepEstadoCuentaDAO() {
        super(RepEstadoCuenta.class);
    }
    
    public List<RepEstadoCuenta> listaEstadoCuenta(LocalDate fecha, String emisor, LocalDate fechaFin) 
    {
        return JpaExecutor.executeRead(em -> {
            String sql = "SELECT "
                        + " fecha, "
                        + "sum(ventas) as ventas, "
                        + " sum(pagos) as pagos, "
                        + " saldo_inicial,"
                        + " estadoCuenta.emisor "
                        + " FROM "
                        + " (SELECT "
                        + " f.fecha, "
                        + " 'factura' as Tipo,"
                        + " f.total as ventas,"
                        + " 0 as pagos "
                        + " FROM factura f "
                        + " WHERE f.fecha BETWEEN :fechaIni AND :fechaFin AND emi_nombre =  :emisorN OR :emisorN IS NULL"
                        + " UNION ALL "
                        + "SELECT "
                        + "p.fecha, "
                        + "'pago' as Tipo,"
                        + "0 as ventas,"
                        + "p.monto as pagos "
                        + "FROM pago p "
                        + "RIGHT JOIN factura f ON p.factura = f.id "
                        + " WHERE p.fecha BETWEEN :fechaIni "
                        + "AND :fechaFin "
                        + "AND (f.emi_nombre = :emisorN   OR :emisorN IS NULL )"
                        + ") b "
                        + "JOIN ( SELECT SUM(saldo) as saldo_inicial, emisor "
                        + "FROM ( "
                        + " SELECT "
                        + " (factura.total - COALESCE(pago.monto, 0)) as saldo, "
                        + " factura.emi_nombre as emisor "
                        + " FROM factura "
                        + " LEFT JOIN pago ON factura.id  = pago.factura "
                        + "WHERE status IN ('1', '3', '4') "
                        + "AND emi_rfc IS NOT NULL "
                        + "AND (factura.emi_nombre =  :emisorN  OR :emisorN IS NULL )"
                        + "AND factura.fecha < :fechaIni "
                        + "GROUP BY  "
                        + "emisor,"
                        + "saldo "
                        + " ORDER BY "
                        + "emisor"
                        + ")saldoInicial "
                        + "GROUP by "
                        + "emisor"
                        + ")estadoCuenta "
                        + " GROUP BY "
                        + " fecha,saldo_inicial, "
                        + " emisor "
                        + "ORDER BY "
                        + "emisor, "
                        + "b.fecha ";
                List<Object[]> results = em.createNativeQuery(sql)
                        .setParameter("fechaIni", fecha)
                        .setParameter("emisorN", emisor)
                        .setParameter("fechaFin", fechaFin)
                        .getResultList();
                List<RepEstadoCuenta> listaEstadoCuenta = new ArrayList<RepEstadoCuenta>();
                for (Object[] o : results) {
                    RepEstadoCuenta rec = new RepEstadoCuenta();
                    int idx = 0;
                    rec.setFecha((LocalDate) o[idx++]);
                    rec.setVentas((BigDecimal) o[idx++]);
                    rec.setPagos((BigDecimal) o[idx++]);
                    rec.setSaldoInicial((BigDecimal) o[idx++]);
                    rec.setEmisor((String) o[idx++]);
                    listaEstadoCuenta.add(rec);
                }
            return listaEstadoCuenta;
        });
    }
    
}
