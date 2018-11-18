package com.cenfotec.MagnaAlianza.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TFinca")
public class Finca {
	
	public Finca () { }

	public Finca(Long numeroFinca, Long tamanno, Long cedulaPropietario) {
		this.numeroFinca = numeroFinca;
		this.tamanno = tamanno;
		this.cedulaPropietario = cedulaPropietario;
	}

	@Id
	@Column(name="fincaId")
	private Long numeroFinca;
	
	@Column(name="tamanno")
	private Long tamanno;
	
	@Column(name="duenno")
	private Long cedulaPropietario;

	public Long getNumeroFinca() {
		return numeroFinca;
	}

	public void setNumeroFinca(Long numeroFinca) {
		this.numeroFinca = numeroFinca;
	}

	public Long getTamanno() {
		return tamanno;
	}

	public void setTamanno(Long tamanno) {
		this.tamanno = tamanno;
	}

	public Long getCedulaPropietario() {
		return cedulaPropietario;
	}

	public void setCedulaPropietario(Long cedulaPropietario) {
		this.cedulaPropietario = cedulaPropietario;
	}
	
	
}
