package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.ConstanciaTraspaso;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConstanciaTraspasoDAO extends BaseDAO<ConstanciaTraspaso, Integer>
{
    private static Logger log = LogManager.getLogger(ConstanciaTraspasoDAO.class);

    public ConstanciaTraspasoDAO() {
        super(ConstanciaTraspaso.class);
    }
    
    public List<ConstanciaTraspaso> buscarPorNumero(String numero) {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("ConstanciaTraspaso.findByNumero", ConstanciaTraspaso.class)
                .setParameter("numero", numero)
                .getResultList()
        );
    }

    public List<ConstanciaTraspaso> buscar(LocalDate fechaInicio, LocalDate fechaFin, Integer idCliente, String folioCliente) 
    {
        return JpaExecutor.executeRead(em -> {
            String folio = null;
            if (folioCliente != null && folioCliente.contains("%") == false) {
                folio = "%".concat(folioCliente).concat("%");
            }
            
            return em.createNativeQuery("SELECT * FROM (\n"
                + "	SELECT * FROM (\n"
                + "		SELECT * FROM constancia_traspaso ct \n"
                + "		WHERE (:idCliente IS NULL OR ct.cliente = :idCliente)\n"
                + "	) cdd2 WHERE ((cdd2.FECHA BETWEEN :fechaInicio AND :fechaFin) OR (:fechaInicio IS NULL OR :fechaFin IS NULL))\n"
                + ") cs3 WHERE (:folioCliente IS NULL OR cs3.NUMERO LIKE :folioCliente)", ConstanciaTraspaso.class)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .setParameter("idCliente", idCliente)
                .setParameter("folioCliente", folio)
                .getResultList();
        });
    }
    
}
