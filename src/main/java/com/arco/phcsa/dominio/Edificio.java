package com.arco.phcsa.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.log4j.Logger;

@Entity
@Table(name = "edificio")
public class Edificio {
	
	private static final Logger log = Logger.getLogger(Edificio.class.getCanonicalName());
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEdificio;
	
	@Column(name = "DIRECCION")
	private String direccion;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idUnidad")
	private List<Unidad> unidades;
	
	public Edificio() {
	}
	
	public Edificio(int id, String direccion) {
		idEdificio = id;
		this.direccion = direccion;
		unidades = new ArrayList<Unidad>();
	}
	
	public int getIdEdificio() {
		return idEdificio;
	}
	public void setIdEdificio(int idEdificio) {
		this.idEdificio = idEdificio;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDireccion() {
		return direccion;
	}
	
	public List<Unidad> getUnidades(){
		return unidades;
	}
	
	public void addUnidad(Unidad unidad){
		unidades.add(unidad);
	}
	
	public void setUnidades(List<Unidad> unidades) {
		this.unidades= unidades; 
	}
	
	public static List<Edificio> dameTodos(){
		log.debug("Retornando todos los edificios");
		List<Edificio> resultList = new ArrayList<Edificio>();
/*		Edificio edificioLarrea1354 = new Edificio(1, "Larrea 1354");
		Unidad larrea1354_5to68 = new Unidad(1, 1, "5to 68");
		edificioLarrea1354.addUnidad(larrea1354_5to68);
		
		resultList.add(edificioLarrea1354);
	    
		Edificio edificioNico = new Edificio(2,"Vidal 2419");
		
		edificioNico.addUnidad(new Unidad(2,1,"7mo E"));
		
		resultList.add(edificioNico);
		
		Edificio edificioMelli = new Edificio(3, "Marcelo T. de Alvear 1934");
		edificioMelli.addUnidad(new Unidad(3,1,"2do B"));*/
		
		return resultList;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "metodo To String";
	}

}

