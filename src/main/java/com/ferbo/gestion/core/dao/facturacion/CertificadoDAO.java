package com.ferbo.gestion.core.dao.facturacion;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.facturacion.Certificado;

public class CertificadoDAO extends BaseDAO<Certificado, Integer>
{
    private static Logger log = LogManager.getLogger(CertificadoDAO.class);

    public CertificadoDAO(TransactionManager transactManager) {
        super(Certificado.class, transactManager);
    }
    
    public Certificado buscarporFecha() {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("Certificado.findByFecha", Certificado.class)
                .getSingleResult()
        );
    }
    
    public List<Certificado> buscarporcdEmisor(Integer emisor) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("Certificado.findByemisor", Certificado.class)
                .setParameter("emisor", emisor)
                .getResultList()
        );
    }
    
}
