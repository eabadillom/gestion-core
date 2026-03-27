package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.ConstanciaDeposito;
import com.ferbo.gestion.core.model.DetalleConstanciaSalida;
import com.ferbo.gestion.core.model.Partida;
import com.ferbo.gestion.core.tools.JpaExecutor;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DetalleConstanciaSalidaDAO extends BaseDAO<DetalleConstanciaSalida, Integer>
{
    private static Logger log = LogManager.getLogger(DetalleConstanciaSalidaDAO.class);

    public DetalleConstanciaSalidaDAO() {
        super(DetalleConstanciaSalida.class);
    }
    
    public List<DetalleConstanciaSalida> buscarPorPartidaCve(Partida partida) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("DetalleConstanciaSalida.findByPartida", DetalleConstanciaSalida.class)
                .setParameter("idPartida", partida.getId())
                .getResultList()
        );
    }
    
    public List<DetalleConstanciaSalida> buscarPorParams(Partida p, ConstanciaDeposito cDepSel) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("DetalleConstanciaSalida.findByParams", DetalleConstanciaSalida.class)
                .setParameter("idPartida", p.getId())
                .setParameter("folioEntrada", cDepSel.getFolioCliente())
                .setParameter("producto", p.getUnidadProducto().getProducto())
                .getResultList()
        );
    }
    
}
