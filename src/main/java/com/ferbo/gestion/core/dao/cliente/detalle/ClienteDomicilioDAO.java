package com.ferbo.gestion.core.dao.cliente.detalle;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.cliente.Cliente;
import com.ferbo.gestion.core.model.cliente.detalle.ClienteDomicilio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ferbo.gestion.core.config.TransactionManager;

public class ClienteDomicilioDAO extends BaseDAO<ClienteDomicilio, Integer>
{
    private static Logger log = LogManager.getLogger(ClienteDomicilioDAO.class);

    public ClienteDomicilioDAO(TransactionManager transactManager) {
        super(ClienteDomicilio.class, transactManager);
    }

    public List<ClienteDomicilio> buscarDomicilioFiscalPorCliente(Integer idCliente, boolean isFullInfo) {
        return transactManager.executeRead(em -> {
            List<ClienteDomicilio> listado = em.createNamedQuery("ClienteDomicilio.findByClienteDomFiscal", ClienteDomicilio.class)
                .setParameter("idTipoDom", (short) 1)
                .setParameter("idCliente", idCliente)
                .getResultList();

            if (isFullInfo == false) {
                return listado;
            }

            for (ClienteDomicilio cd : listado) {
                log.debug("Domicilio cve: {}", cd.getDomicilio().getId());
                log.debug("PaisCve: {}", cd.getDomicilio().getAsentamiento().getAsentamientoPK().getCiudad().getCiudadPK().getMunicipio().getMunicipioPK().getEstado().getEstadoPK().getPais().getId());
            }

            return listado;
        });
    }

    public List<ClienteDomicilio> buscaPorCliente(Cliente c) {
        return transactManager.executeRead(em -> {
            List<ClienteDomicilio> listado = em.createNamedQuery("ClienteDomicilio.findByCliente", ClienteDomicilio.class)
                .setParameter("idCliente", c.getId())
                .getResultList();

            for (ClienteDomicilio cd : listado) {
                log.debug("Asentamiento: {}", cd.getDomicilio().getAsentamiento().toString());
                log.debug("Ciudad: {}", cd.getDomicilio().getAsentamiento().getAsentamientoPK().getCiudad().toString());
                log.debug("Municipios: {}", cd.getDomicilio().getAsentamiento().getAsentamientoPK().getCiudad().getCiudadPK().getMunicipio().toString());
                log.debug("Estado: {}", cd.getDomicilio().getAsentamiento().getAsentamientoPK().getCiudad().getCiudadPK().getMunicipio().getMunicipioPK().getEstado().getEstadoPK().toString());
                log.debug("Pais: {}", cd.getDomicilio().getAsentamiento().getAsentamientoPK().getCiudad().getCiudadPK().getMunicipio().getMunicipioPK().getEstado().getEstadoPK().getPais().toString());
            }

            return listado;
        });
    }
    
}
