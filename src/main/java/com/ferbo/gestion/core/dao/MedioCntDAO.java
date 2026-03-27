package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.ClienteContacto;
import com.ferbo.gestion.core.model.MedioCnt;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MedioCntDAO extends BaseDAO<MedioCnt, Integer> 
{
    private static Logger log = LogManager.getLogger(MedioCntDAO.class);

    public MedioCntDAO() {
        super(MedioCnt.class);
    }

    public List<MedioCnt> buscarPorIdContacto(ClienteContacto clienteContacto) 
    {
        Integer idContacto = clienteContacto.getContacto().getId();
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("MedioCnt.findByContacto", MedioCnt.class)
                .setParameter("idContacto", idContacto)
                .getResultList()
        );
    }

}
