package com.ferbo.gestion.core.dao.inventario.salida;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.inventario.entrada.ConstanciaDeposito;
import com.ferbo.gestion.core.model.inventario.entrada.Partida;
import com.ferbo.gestion.core.model.inventario.salida.DetalleConstanciaSalida;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class DetalleConstanciaSalidaDAO extends BaseDAO<DetalleConstanciaSalida, Integer>
{
    private static Logger log = LogManager.getLogger(DetalleConstanciaSalidaDAO.class);

    public DetalleConstanciaSalidaDAO(TransactionManager transactManager) {
        super(DetalleConstanciaSalida.class, transactManager);
    }
    
    public List<DetalleConstanciaSalida> buscarPorPartidaCve(Partida partida) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("DetalleConstanciaSalida.findByPartida", DetalleConstanciaSalida.class)
                .setParameter("idPartida", partida.getId())
                .getResultList()
        );
    }
    
    public List<DetalleConstanciaSalida> buscarPorParams(Partida p, ConstanciaDeposito cDepSel) 
    {
        return transactManager.executeRead(em -> 
            em.createNamedQuery("DetalleConstanciaSalida.findByParams", DetalleConstanciaSalida.class)
                .setParameter("idPartida", p.getId())
                .setParameter("folioEntrada", cDepSel.getFolioCliente())
                .setParameter("producto", p.getUnidadProducto().getProducto())
                .getResultList()
        );
    }
    
}
