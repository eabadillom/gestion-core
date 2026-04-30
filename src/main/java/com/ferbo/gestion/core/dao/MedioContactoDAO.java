package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.ClienteContacto;
import com.ferbo.gestion.core.model.MedioContacto;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MedioContactoDAO extends BaseDAO<MedioContacto, Integer> 
{
    private static Logger log = LogManager.getLogger(MedioContactoDAO.class);

    public MedioContactoDAO() {
        super(MedioContacto.class);
    }

    public List<MedioContacto> buscarPorIdContacto(ClienteContacto clienteContacto) 
    {
        Integer idContacto = clienteContacto.getContacto().getId();
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("MedioCnt.findByContacto", MedioContacto.class)
                .setParameter("idContacto", idContacto)
                .getResultList()
        );
    }

}
