package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.ConstanciaSalida;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class ConstanciaSalidaDAO extends BaseDAO <ConstanciaSalida, Integer>
{
    private static Logger log = LogManager.getLogger(ConstanciaDepositoDAO.class);
    
    public ConstanciaSalidaDAO(TransactionManager transactManager){
        super(ConstanciaSalida.class, transactManager);
    }
    
    public List<ConstanciaSalida> obtenerPorFolioDeposito(Integer folio)
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("ConstanciaSalida.findByFolioDeposito", ConstanciaSalida.class)
                .setParameter("folio", folio)
                .getResultList()
        );
    }
    
}
