package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.ClienteContacto;
import com.ferbo.gestion.core.model.MedioCnt;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class MedioCntDAO extends BaseDAO<MedioCnt, Integer> 
{
    private static Logger log = LogManager.getLogger(MedioCntDAO.class);

    public MedioCntDAO(TransactionManager transactManager) {
        super(MedioCnt.class, transactManager);
    }

    public List<MedioCnt> buscarPorIdContacto(ClienteContacto clienteContacto) 
    {
        Integer idContacto = clienteContacto.getContacto().getId();
        return transactManager.executeRead(em -> 
            em.createNamedQuery("MedioCnt.findByContacto", MedioCnt.class)
                .setParameter("idContacto", idContacto)
                .getResultList()
        );
    }

}
