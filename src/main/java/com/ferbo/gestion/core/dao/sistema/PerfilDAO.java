package com.ferbo.gestion.core.dao.sistema;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.sistema.Perfil;

public class PerfilDAO extends BaseDAO<Perfil, Integer> 
{
    private static Logger log = LogManager.getLogger(PerfilDAO.class);

    public PerfilDAO(TransactionManager transactManager) {
        super(Perfil.class, transactManager);
    }
    
    public List<Perfil> buscarTodos() {
        return transactManager.executeRead(em ->
            em.createNamedQuery("Perfil.findAll", Perfil.class).getResultList()
        );
    }
    
    public List<Perfil> getPerfil() {
        return transactManager.executeRead(em ->
            em.createQuery("SELECT u FROM Perfil u WHERE u.id IN (1, 2)")
                .getResultList()
        );
    }
    
}
