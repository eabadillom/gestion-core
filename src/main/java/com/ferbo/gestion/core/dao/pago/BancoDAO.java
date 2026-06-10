package com.ferbo.gestion.core.dao.pago;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.pago.Banco;

public class BancoDAO extends BaseDAO<Banco, Integer> 
{
    private static Logger log = LogManager.getLogger(BancoDAO.class);

    public BancoDAO(TransactionManager transactManager) {
        super(Banco.class, transactManager);
    }

    public List<Banco> buscarTodos() 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("Bancos.findAll", Banco.class)
                .getResultList()
        );
    }

}
