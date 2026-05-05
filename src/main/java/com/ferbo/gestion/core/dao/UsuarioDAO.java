package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Usuario;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class UsuarioDAO extends BaseDAO<Usuario, Integer>
{
    private static Logger log = LogManager.getLogger(UsuarioDAO.class);

    public UsuarioDAO(TransactionManager transactManager) {
        super(Usuario.class, transactManager);
    }
    
    public Usuario buscarPorUsuario(String username) {
        return transactManager.executeRead(em ->
            em.createNamedQuery("Usuario.findByUsuario", Usuario.class)
                .setParameter("usuario", username)
                .getSingleResult()
        );
    }
    
    public List<Usuario> obtenerTodos() 
    {
        return transactManager.executeRead(em ->
            em.createNamedQuery("Usuario.findAll", Usuario.class)
                .getResultList()
        );
    }
    
    public List<Usuario> buscarPorPerfil(Integer idPerfil) {
        return transactManager.executeRead(em ->
            em.createNamedQuery("Usuario.findByPerfil", Usuario.class)
                .setParameter("perfil", idPerfil)
                .getResultList()
        );
    }
    
}
