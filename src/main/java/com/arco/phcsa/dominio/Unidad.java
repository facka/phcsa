package com.arco.phcsa.dominio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@Table(name = "unidad")
public class Unidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	long idUnidad;
	
	@Column(name = "NUMERO")
	int numero;
	
	@Column(name = "DIRECCION_EXTENDIDA")
	String direccionExtendida;
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idEdificio")
	@JsonBackReference
	Edificio edificio;
	
	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	public Unidad () {
		
	}
	
	public Unidad(long id, int numero, String direccionExtendida) {
		idUnidad = id;
		this.numero = numero;
		this.direccionExtendida = direccionExtendida;
	}
	
	public long getIdUnidad() {
		return idUnidad;
	}
	public void setIdUnidad(long idUnidad) {
		this.idUnidad = idUnidad;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDireccionExtendida() {
		return direccionExtendida;
	}
	public void setDireccionExtendida(String direccionExtendida) {
		this.direccionExtendida = direccionExtendida;
	}

}
