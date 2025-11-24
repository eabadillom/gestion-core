package com.ferbo.gestion.model;

public class Cliente {
	private Integer idCliente = null;
	private String nombre = null;
	private String alias = null;
	private String rfc = null;
	private String numero = null;
	private String mail = null;
	private boolean habilitado = false;
	private String codigoUnico = null;
	private String tipoPersona = null;
	private String idRegimenFiscal = null;
	private String idUsoCFDI = null;
	private String idMetodoPago = null;
	private String idFormaPago = null;
	private String regimenCapital = null;
	@Deprecated
	private String uuid = null;

	private Cliente(Builder builder) {
		this.idCliente = builder.idCliente;
		this.nombre = builder.nombre;
		this.alias = builder.alias;
		this.rfc = builder.rfc;
		this.numero = builder.numero;
		this.mail = builder.mail;
		this.habilitado = builder.habilitado;
		this.codigoUnico = builder.codigoUnico;
		this.tipoPersona = builder.tipoPersona;
		this.idRegimenFiscal = builder.idRegimenFiscal;
		this.idUsoCFDI = builder.idUsoCFDI;
		this.idMetodoPago = builder.idMetodoPago;
		this.idFormaPago = builder.idFormaPago;
		this.regimenCapital = builder.regimenCapital;
		this.uuid = builder.uuid;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	public String getCodigoUnico() {
		return codigoUnico;
	}
	public void setCodigoUnico(String codigoUnico) {
		this.codigoUnico = codigoUnico;
	}
	public String getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	public String getIdRegimenFiscal() {
		return idRegimenFiscal;
	}
	public void setIdRegimenFiscal(String idRegimenFiscal) {
		this.idRegimenFiscal = idRegimenFiscal;
	}
	public String getIdUsoCFDI() {
		return idUsoCFDI;
	}
	public void setIdUsoCFDI(String idUsoCFDI) {
		this.idUsoCFDI = idUsoCFDI;
	}
	public String getIdMetodoPago() {
		return idMetodoPago;
	}
	public void setIdMetodoPago(String idMetodoPago) {
		this.idMetodoPago = idMetodoPago;
	}
	public String getIdFormaPago() {
		return idFormaPago;
	}
	public void setIdFormaPago(String idFormaPago) {
		this.idFormaPago = idFormaPago;
	}
	public String getRegimenCapital() {
		return regimenCapital;
	}
	public void setRegimenCapital(String regimenCapital) {
		this.regimenCapital = regimenCapital;
	}
	@Deprecated
	public String getUuid() {
		return uuid;
	}
	@Deprecated
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public static Builder builder() {
		return new Builder();
	}
	public static final class Builder {
		private Integer idCliente = null;
		private String nombre = null;
		private String alias = null;
		private String rfc = null;
		private String numero = null;
		private String mail = null;
		private boolean habilitado = false;
		private String codigoUnico = null;
		private String tipoPersona = null;
		private String idRegimenFiscal = null;
		private String idUsoCFDI = null;
		private String idMetodoPago = null;
		private String idFormaPago = null;
		private String regimenCapital = null;
		@Deprecated
		private String uuid = null;

		private Builder() {
		}

		public Builder IdCliente(Integer idCliente) {
			this.idCliente = idCliente;
			return this;
		}

		public Builder Nombre(String nombre) {
			this.nombre = nombre;
			return this;
		}
		
		public Builder Alias(String alias) {
			this.alias = alias;
			return this;
		}

		public Builder Rfc(String rfc) {
			this.rfc = rfc;
			return this;
		}

		public Builder Numero(String numero) {
			this.numero = numero;
			return this;
		}

		public Builder Mail(String mail) {
			this.mail = mail;
			return this;
		}

		public Builder Habilitado(boolean habilitado) {
			this.habilitado = habilitado;
			return this;
		}

		public Builder CodigoUnico(String codigoUnico) {
			this.codigoUnico = codigoUnico;
			return this;
		}

		public Builder TipoPersona(String tipoPersona) {
			this.tipoPersona = tipoPersona;
			return this;
		}

		public Builder IdRegimenFiscal(String idRegimenFiscal) {
			this.idRegimenFiscal = idRegimenFiscal;
			return this;
		}

		public Builder IdUsoCFDI(String idUsoCFDI) {
			this.idUsoCFDI = idUsoCFDI;
			return this;
		}

		public Builder IdMetodoPago(String idMetodoPago) {
			this.idMetodoPago = idMetodoPago;
			return this;
		}

		public Builder IdFormaPago(String idFormaPago) {
			this.idFormaPago = idFormaPago;
			return this;
		}

		public Builder RegimenCapital(String regimenCapital) {
			this.regimenCapital = regimenCapital;
			return this;
		}

		@Deprecated
		public Builder Uuid(String uuid) {
			this.uuid = uuid;
			return this;
		}

		public Cliente build() {
			return new Cliente(this);
		}
	}
}
