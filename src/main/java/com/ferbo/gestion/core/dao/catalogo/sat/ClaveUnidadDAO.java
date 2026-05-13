package com.ferbo.gestion.core.dao.catalogo.sat;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.catalogo.sat.ClaveUnidad;

public class ClaveUnidadDAO extends BaseDAO<ClaveUnidad,String>
{
    private static Logger log = LogManager.getLogger(ClaveUnidadDAO.class);

    public ClaveUnidadDAO(TransactionManager transactManager) {
        super(ClaveUnidad.class, transactManager);
    }
    
    public List<ClaveUnidad> buscarPorClaveNombre(String clave, String nombre) 
    {
        return transactManager.executeRead(em ->{
            String prmClave = new String(clave);
        
            if (prmClave.startsWith("%") == false) 
                prmClave = "%".concat(prmClave);

            if (prmClave.endsWith("%") == false) 
                prmClave = prmClave.concat("%");

            String prmNombre = new String(nombre);

            if (prmNombre.startsWith("%") == false) 
                prmNombre = "%".concat(prmNombre);

            if (prmNombre.endsWith("%") == false)
                prmNombre = prmNombre.concat("%");
            
            return em.createNamedQuery("ClaveUnidad.likeClaveNombre", ClaveUnidad.class)
                .setParameter("clave", prmClave)
                .setParameter("nombre", prmNombre)
                .getResultList();
        });
    }

}
