package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Aviso;
import java.util.List;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class AvisoDAO extends BaseDAO<Aviso, Integer> 
{
    private static Logger log = LogManager.getLogger(AvisoDAO.class);

    public AvisoDAO(TransactionManager transactManager) {
        super(Aviso.class, transactManager);
    }

    public List<Aviso> buscarPorCliente(Integer idCliente) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("Aviso.findByCliente", Aviso.class)
                .setParameter("idCliente", idCliente)
                .getResultList()
        );
    }

    public int conteoConstanciaDeDeposito(Aviso aviso) 
    {
        return transactManager.executeRead(em -> {
            Query query = em.createNativeQuery("SELECT COUNT(cdd.aviso_cve) FROM constancia_de_deposito cdd WHERE cdd.aviso_cve = :avisoCve");
            query.setParameter("avisoCve", aviso.getId());
            int count = Integer.parseInt(query.getSingleResult().toString());
            return count;
        });
    }

    public int conteoPrecioServicio(Aviso aviso) 
    {
        return transactManager.executeRead(em -> {
            Query query = em.createNativeQuery("SELECT COUNT(ps.aviso_cve) FROM precio_servicio ps  WHERE ps.aviso_cve = :avisoCve");
            query.setParameter("avisoCve", aviso.getId());
            int count = Integer.parseInt(query.getSingleResult().toString());
            return count;
        });
    }

}
