package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Usuario;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsuarioDAO extends BaseDAO<Usuario, Integer>
{
    private static Logger log = LogManager.getLogger(UsuarioDAO.class);

    public UsuarioDAO() {
        super(Usuario.class);
    }
    
    public Usuario buscarPorUsuario(String username) {
        return JpaExecutor.executeRead(em ->
            em.createNamedQuery("Usuario.findByUsuario", Usuario.class)
                .setParameter("usuario", username)
                .getSingleResult()
        );
    }
    
    public List<Usuario> obtenerTodos() 
    {
        return JpaExecutor.executeRead(em ->
            em.createNamedQuery("Usuario.findAll", Usuario.class)
                .getResultList()
        );
    }
    
    public List<Usuario> buscarPorPerfil(Integer idPerfil) {
        return JpaExecutor.executeRead(em ->
            em.createNamedQuery("Usuario.findByPerfil", Usuario.class)
                .setParameter("perfil", idPerfil)
                .getResultList()
        );
    }
    
}
