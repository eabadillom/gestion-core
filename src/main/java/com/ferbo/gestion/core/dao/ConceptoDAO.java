package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Concepto;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConceptoDAO extends BaseDAO<Concepto, String> 
{
    private static Logger log = LogManager.getLogger(ConceptoDAO.class);

    public ConceptoDAO() {
        super(Concepto.class);
    }
    
    public List<Concepto> buscarPorNombre(String nombre) 
    {
        return JpaExecutor.executeRead(em -> { 
            String prmNombre = new String(nombre);

            if (prmNombre.startsWith("%") == false) {
                prmNombre = "%".concat(prmNombre);
            }

            if (prmNombre.endsWith("%") == false) {
                prmNombre = prmNombre.concat("%");
            }
            
            return em.createNamedQuery("Concepto.likeNombre", Concepto.class)
                .setParameter("nombre", prmNombre)
                .getResultList();
        });
    }

    public List<Concepto> buscarPorClaveNombre(String clave, String nombre) 
    {
        return JpaExecutor.executeRead(em -> {
            String prmClave = new String(clave);
            if (prmClave.startsWith("%") == false) {
                prmClave = "%".concat(prmClave);
            }
            if (prmClave.endsWith("%") == false) {
                prmClave = prmClave.concat("%");
            }

            String prmNombre = new String(nombre);
            if (prmNombre.startsWith("%") == false) {
                prmNombre = "%".concat(prmNombre);
            }
            if (prmNombre.endsWith("%") == false) {
                prmNombre = prmNombre.concat("%");
            }
            
            return em.createNamedQuery("Concepto.likeClaveNombre", Concepto.class)
                .setParameter("clave", prmClave)
                .setParameter("nombre", prmNombre)
                .getResultList();
        });
    }
    
}
