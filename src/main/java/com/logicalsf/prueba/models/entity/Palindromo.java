package com.logicalsf.prueba.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "palindromos")
public class Palindromo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cadena;
	
	private String invertido;
	
	private boolean isPalindromo;
	
	@Column(name = "creado_en")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creadoEn;
	
	
	@PrePersist
	private void prePersist() {
		this.creadoEn = new Date();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public String getInvertido() {
		return invertido;
	}

	public void setInvertido(String invertido) {
		this.invertido = invertido;
	}

	public Date getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(Date creadaEn) {
		this.creadoEn = creadaEn;
	}

	public boolean isPalindromo() {
		return isPalindromo;
	}

	public void setPalindromo(boolean isPalindromo) {
		this.isPalindromo = isPalindromo;
	}
	
	
	
	
	
}
