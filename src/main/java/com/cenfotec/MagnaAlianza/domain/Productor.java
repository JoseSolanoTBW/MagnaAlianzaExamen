package com.cenfotec.MagnaAlianza.domain;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TProductor")
public class Productor {
	
	public Productor() {}
	
		
	public Productor(Long cedula, String nombre, String direccionNominal, String direccionPolitica, String empresa) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.direccionNominal = direccionNominal;
		this.direccionPolitica = direccionPolitica;
		this.empresa = empresa;
	}

	@Id
	private Long cedula;
	
	@Column(name="nombre")
	private String nombre;

	@Column(name="direccion_nominal")
	private String direccionNominal;
	
	@Column(name="direccion_politica")
	private String direccionPolitica;
	
	@Column(name="empresa")
	private String empresa;

	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccionNominal() {
		return direccionNominal;
	}

	public void setDireccionNominal(String direccionNominal) {
		this.direccionNominal = direccionNominal;
	}

	public String getDireccionPolitica() {
		return direccionPolitica;
	}

	public void setDireccionPolitica(String direccionPolitica) {
		this.direccionPolitica = direccionPolitica;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	
	
}
