package com.ferbo.gestion.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferbo.gestion.dao.ClienteContactoDAO;
import com.ferbo.gestion.dao.ContactoDAO;
import com.ferbo.gestion.dao.MailDAO;
import com.ferbo.gestion.dao.MedioContactoDAO;
import com.ferbo.gestion.dao.TelefonoDAO;
import com.ferbo.gestion.model.ClienteContacto;
import com.ferbo.gestion.model.Contacto;
import com.ferbo.gestion.model.Mail;
import com.ferbo.gestion.model.MedioContacto;
import com.ferbo.gestion.model.Telefono;
import com.ferbo.gestion.tools.DBManager;

public class ContactosBL {
	private static Logger log = LogManager.getLogger(ContactosBL.class);
	private ClienteContactoDAO ccDAO = null;
	private ContactoDAO contactoDAO = null;
	private MedioContactoDAO medioContactoDAO = null;
	private MailDAO mailDAO = null;
	private TelefonoDAO telefonoDAO = null;
	
	private Integer idCliente = null;
	
	public ContactosBL(Integer idCliente) {
		this.idCliente = idCliente;
		this.ccDAO = new ClienteContactoDAO();
		this.contactoDAO = new ContactoDAO();
		this.medioContactoDAO = new MedioContactoDAO();
		this.mailDAO = new MailDAO();
		this.telefonoDAO = new TelefonoDAO();
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	/**Obtiene el listado de contactos del cliente indicado por idCliente.
	 * @param conn Conexión a la base de datos.
	 * @param idCliente Id del cliente (cte_cve)
	 * @return
	 * @throws SQLException
	 */
	public List<ClienteContacto> getClienteContactos(Connection conn, Integer idCliente) throws SQLException {
		List<ClienteContacto> clienteContactos = null;
		clienteContactos = ccDAO.get(conn, idCliente);
		
		for(ClienteContacto clienteContacto : clienteContactos) {
			Contacto contacto = this.getContacto(conn, clienteContacto.getIdContacto());
			clienteContacto.setContacto(contacto);
		}
		
		return clienteContactos;
	}
	
	/**Obtiene el ccontacto del cliente especificado por idContacto.
	 * El cliente se indica desde el constructor de esta clase con idCliente.
	 * @param conn
	 * @param idContacto
	 * @return
	 * @throws SQLException
	 */
	public ClienteContacto getClienteContacto(Connection conn, Integer idContacto) throws SQLException {
		ClienteContacto clienteContacto = null;
		clienteContacto = ccDAO.get(conn, idCliente, idContacto);
		Contacto contacto = this.getContacto(idContacto);
		clienteContacto.setContacto(contacto);
		return clienteContacto;
	}
	
	public Contacto getContacto(Integer idContacto) throws SQLException {
		Contacto contacto = null;
		Connection conn = null;
		
		try {
			conn = DBManager.getConnection();
			contacto = this.getContacto(conn, idContacto);
		} catch(Exception ex) {
			log.error("Problema para obtener los datos del contacto...", ex);
		} finally {
			DBManager.close(conn);
		}
		
		return contacto;
	}
	
	public Contacto getContacto(Connection conn, Integer idContacto) throws SQLException {
		Contacto contacto = null;
		List<MedioContacto> mediosContacto = null;
		contacto = contactoDAO.get(conn, idContacto);
		mediosContacto = medioContactoDAO.get(conn, idContacto);
		for(MedioContacto medio : mediosContacto) {
			Mail mail = mailDAO.get(conn, medio.getIdMail());
			Telefono telefono = telefonoDAO.get(conn, medio.getIdTelefono());
			medio.setMail(mail);
			medio.setTelefono(telefono);
		}
		contacto.setMediosContacto(mediosContacto);
		return contacto;
	}
	
	public List<MedioContacto> getMediosContacto(Connection conn, Integer idContacto) throws SQLException {
		List<MedioContacto> medios = null;
		medios = medioContactoDAO.get(conn, idContacto);
		return medios;
	}
}
