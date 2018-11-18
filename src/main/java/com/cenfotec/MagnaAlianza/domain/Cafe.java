package com.cenfotec.MagnaAlianza.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TCafe")
public class Cafe {
	
	public Cafe () {}
	
	public Cafe( Long numeroFinca, String tipo, Long cedulaPropietario) {
		this.numeroFinca = numeroFinca;
		this.tipo = tipo;
		this.cedulaPropietario = cedulaPropietario;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;
	
	@Column(name="fincaId")
	private Long numeroFinca;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="duenno")
	private Long cedulaPropietario;
	
	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Long getNumeroFinca() {
		return numeroFinca;
	}

	public void setNumeroFinca(Long numeroFinca) {
		this.numeroFinca = numeroFinca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getCedulaPropietario() {
		return cedulaPropietario;
	}

	public void setCedulaPropietario(Long cedulaPropietario) {
		this.cedulaPropietario = cedulaPropietario;
	}
}
