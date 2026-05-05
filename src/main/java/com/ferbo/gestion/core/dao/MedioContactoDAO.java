package com.ferbo.gestion.core.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.ClienteContacto;
import com.ferbo.gestion.core.model.MedioContacto;

public class MedioContactoDAO extends BaseDAO<MedioContacto, Integer> 
{
    private static Logger log = LogManager.getLogger(MedioContactoDAO.class);

    public MedioContactoDAO(TransactionManager transactManager) {
        super(MedioContacto.class, transactManager);
    }

    public List<MedioContacto> buscarPorIdContacto(ClienteContacto clienteContacto) 
    {
        Integer idContacto = clienteContacto.getContacto().getId();
        return transactManager.executeRead(em -> 
            em.createNamedQuery("MedioCnt.findByContacto", MedioContacto.class)
                .setParameter("idContacto", idContacto)
                .getResultList()
        );
    }

}
