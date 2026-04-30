package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Ingreso;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class IngresoDAO extends BaseDAO<Ingreso, Integer> 
{
    private static Logger log = LogManager.getLogger(IngresoDAO.class);

    public IngresoDAO(TransactionManager transactManager) {
        super(Ingreso.class, transactManager);
    }
    
    public List<Ingreso> buscarPorFechaCtePlanta(LocalDate fechaActualIni, LocalDate fechaActualFin, Integer idCliente, Integer idPlanta) 
    {
        return transactManager.executeRead(em -> {
            String query = "SELECT"
                    + "	i.id_ingreso, "
                    + "	i.folio, "
                    + "	i.fecha_hora, "
                    + "	i.id_cliente, "
                    + "	i.transportista, "
                    + "	i.placas, "
                    + "	i.observaciones, "
                    + "	i.id_contacto, "
                    + "	i.status  "
                    + "FROM ingreso i "
                    + "INNER JOIN ingreso_producto ip ON ip.id_ingreso = i.id_ingreso "
                    + "WHERE i.fecha_hora BETWEEN :fechaActualIni AND :fechaActualFin AND i.id_cliente = :idCliente AND ip.id_planta = :idPlanta "
                    + "GROUP BY i.id_ingreso, "
                    + "	i.folio, "
                    + "	i.fecha_hora, "
                    + "	i.id_cliente, "
                    + "	i.transportista,"
                    + "	i.placas, "
                    + "	i.observaciones, "
                    + "	i.id_contacto, "
                    + "	i.status ";

            Query sql = em.createNativeQuery(query, Ingreso.class)
                    .setParameter("fechaActualIni", fechaActualIni)
                    .setParameter("fechaActualFin", fechaActualFin)
                    .setParameter("idCliente", idCliente)
                    .setParameter("idPlanta", idPlanta);
                
            return sql.getResultList();
        });
    }

}
