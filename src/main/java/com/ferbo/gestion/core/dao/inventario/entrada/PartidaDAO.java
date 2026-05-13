package com.ferbo.gestion.core.dao.inventario.entrada;

import com.ferbo.gestion.core.commons.dao.BaseDAO;

import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;
import com.ferbo.gestion.core.model.inventario.entrada.Partida;

public class PartidaDAO extends BaseDAO<Partida, Integer> 
{
    private static Logger log = LogManager.getLogger(Partida.class);

    public PartidaDAO(TransactionManager transactManager) {
        super(Partida.class, transactManager);
    }
    
    public Partida buscarPorIdConEntrada(Integer idPartida) 
    {
        return transactManager.executeRead(em -> {
            TypedQuery<Partida> query = em.createQuery(
                "SELECT p FROM Partida p "
                    + "INNER JOIN p.constanciaDeposito cd "
                    + "INNER JOIN p.camara cm "
                    + "INNER JOIN cm.planta pl "
                    + "INNER JOIN p.unidadProducto up "
                    + "INNER JOIN up.producto prd "
                    + "INNER JOIN up.unidadManejo um", Partida.class
            );

            query.setParameter("idPartida", idPartida);
            return query.getSingleResult();
        });
    }
    
}
