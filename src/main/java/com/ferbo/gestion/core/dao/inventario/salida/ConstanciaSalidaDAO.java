package com.ferbo.gestion.core.dao.inventario.salida;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.dao.inventario.entrada.ConstanciaDepositoDAO;
import com.ferbo.gestion.core.model.inventario.salida.ConstanciaSalida;

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
