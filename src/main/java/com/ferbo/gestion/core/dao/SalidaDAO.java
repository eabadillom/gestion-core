package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Salida;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SalidaDAO extends BaseDAO<Salida, Integer> 
{
    private static Logger log = LogManager.getLogger(SalidaDAO.class);

    public SalidaDAO(Class<Salida> modelClass) {
        super(modelClass);
    }
    
    public SalidaDAO(){
        super(Salida.class);
    }
    
    public List<Salida> findByCliente(Integer idCliente, String clave, LocalDate fechaSalida) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("Salida.findByCliente", Salida.class)
                .setParameter("idCliente", idCliente)
                .setParameter("clave", clave)
                .setParameter("fechaSalida", fechaSalida)
                .getResultList()
        );
    }
    
    public Salida findByFolioSalida(String folioSalida) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("Salida.findByFolioSalida", Salida.class)
                .setParameter("folioSalida", folioSalida)
                .getSingleResult()
        );
    }
    
}
