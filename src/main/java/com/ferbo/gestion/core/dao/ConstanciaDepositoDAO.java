package com.ferbo.gestion.core.dao;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.ConstanciaDeposito;
import com.ferbo.gestion.core.tools.JpaExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConstanciaDepositoDAO extends BaseDAO <ConstanciaDeposito, Integer>
{
    private static Logger log = LogManager.getLogger(ConstanciaDepositoDAO.class);
    
    public ConstanciaDepositoDAO(){
        super(ConstanciaDeposito.class);
    }
    
    public ConstanciaDeposito buscarPorFolioCliente(String folioCliente) 
    {
        return JpaExecutor.executeRead(em -> {
            return em.createQuery("SELECT DISTINCT c \n" +
                    "FROM ConstanciaDeposito c \n" +
                    "INNER JOIN c.cliente cl \n" +
                    "INNER JOIN c.constanciaDepositoDetalleList cdd \n" +
                    "INNER JOIN c.aviso a \n" +
                    "INNER JOIN c.partidaList p \n" +
                    "INNER JOIN p.detallePartidaList dp \n" +
                    "INNER JOIN p.camara cm \n" +
                    "INNER JOIN cm.planta pl \n" +
                    "INNER JOIN p.unidadProducto up \n" +
                    "INNER JOIN p.unidadCobro uc \n" +
                    "INNER JOIN up.producto prd \n" +
                    "LEFT JOIN p.detalleConstanciaSalidaList dcs \n" +
                    "INNER JOIN dcs.constancia cs \n" +
                    "LEFT JOIN p.traspasoPartidaList tp \n" +
                    "LEFT JOIN tp.traspaso tr \n" +
                    "WHERE c.folioCliente = :folioCliente", ConstanciaDeposito.class)
                .setParameter("folioCliente", folioCliente)
                .getSingleResult();
        });
    }
    
}
