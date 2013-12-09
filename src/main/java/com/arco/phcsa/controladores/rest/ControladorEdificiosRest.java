package com.arco.phcsa.controladores.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arco.phcsa.dominio.Edificio;
import com.arco.phcsa.servicios.ServicioEdificio;

@Controller
@RequestMapping("edificios")
public class ControladorEdificiosRest {
	
	@Autowired
	private ServicioEdificio edificioServicio;
	
	private static final Logger log = Logger.getLogger(ControladorEdificiosRest.class);
	
	
	public ControladorEdificiosRest() {
		// TODO Auto-generated constructor stub
	}
	
	//se invoca /edificios/get?id=1
	@RequestMapping(value="get", params="id")
	@ResponseBody
	public Edificio getEdificioById(@RequestParam Integer id) {
		log.info("entro en el GetEdificioByID");
		Edificio edificio = new Edificio(id, "Larrea 1354 - " + id.toString());
		edificioServicio.create(edificio);
		
		log.info("busca el edificio");
		return edificioServicio.findById(id);
	}
	
	@RequestMapping("getAll")
	@ResponseBody
	public List<Edificio> getEdificios() {
		log.info("entro en el getEdificios");
		List<Edificio> list = new ArrayList<Edificio>();
		list.add( new Edificio(1,"Larrea 1354"));
		list.add( new Edificio(2,"Vidal 1345"));
		list.add( new Edificio(3,"Marcelo T. Alvear 354"));
		list.add( new Edificio(4,"Rivadavia 1354"));
		return list;
	}
	
	
	

}
