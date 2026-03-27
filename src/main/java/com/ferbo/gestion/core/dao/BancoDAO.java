package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Banco;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BancoDAO extends BaseDAO<Banco, Integer> 
{
    private static Logger log = LogManager.getLogger(BancoDAO.class);

    public BancoDAO() {
        super(Banco.class);
    }

    public List<Banco> buscarTodos() 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("Bancos.findAll", Banco.class)
                .getResultList()
        );
    }

}
