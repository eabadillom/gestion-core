package com.ferbo.gestion.core.model;

import java.time.LocalDate;
import java.util.Objects;

public class EnvioInventario {
	private final Integer id;
	private final Integer idCliente;
	private final Cliente cliente;
	private final LocalDate fechaEnvio;
	private final Boolean enviado;

	private EnvioInventario(Builder builder) {
		this.id = builder.id;
		this.idCliente = builder.idCliente;
		this.cliente = builder.cliente;
		this.fechaEnvio = builder.fechaEnvio;
		this.enviado = builder.enviado;
	}
	
	@Override
	public int hashCode() {
		if(this.id == null)
			System.identityHashCode(this);
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnvioInventario other = (EnvioInventario) obj;
		if(this.id == null || other.id == null)
			return Objects.equals(System.identityHashCode(this), System.identityHashCode(other));
		return Objects.equals(id, other.id);
	}
	public Integer getId() {
		return id;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public LocalDate getFechaEnvio() {
		return fechaEnvio;
	}
	
	public Boolean getEnviado() {
		return enviado;
	}
	
	@Override
	public String toString() {
		return "EnvioInventario [id=" + id + ", idCliente=" + idCliente + ", fechaEnvio=" + fechaEnvio + ", enviado="
				+ enviado + "]";
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static final class Builder {
		private Integer id = null;
		private Integer idCliente = null;
		private Cliente cliente = null;
		private LocalDate fechaEnvio = null;
		private Boolean enviado = null;

		private Builder() {
		}

		public Builder Id(Integer id) {
			this.id = id;
			return this;
		}

		public Builder IdCliente(Integer idCliente) {
			this.idCliente = idCliente;
			return this;
		}

		public Builder Cliente(Cliente cliente) {
			this.cliente = cliente;
			return this;
		}

		public Builder FechaEnvio(LocalDate fechaEnvio) {
			this.fechaEnvio = fechaEnvio;
			return this;
		}

		public Builder Enviado(Boolean enviado) {
			this.enviado = enviado;
			return this;
		}

		public EnvioInventario build() {
			return new EnvioInventario(this);
		}
	}
}
