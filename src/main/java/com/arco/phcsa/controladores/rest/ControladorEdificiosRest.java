package com.arco.phcsa.controladores.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.arco.phcsa.dominio.Edificio;
import com.arco.phcsa.dominio.Unidad;
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
	
	//se invoca /edificios/{id}
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody 
	public Edificio getEdificioById(@PathVariable String id) {
		log.info("entro en el GetEdificioByID");
		//Edificio edificio = new Edificio(id, "Larrea 1354 - " + id.toString());
		//edificioServicio.create(edificio);
		
		log.info("busca el edificio");
		return edificioServicio.findById(Integer.parseInt(id));
	}
	
	//se invoca /edificios/{id}
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void updateEdificioById(@PathVariable String id, @RequestBody Edificio edificioToUpdate) {
		log.info("entro en el updateEdificioByID");
		Edificio edificio = edificioServicio.findById(Integer.parseInt(id));
		if (edificioToUpdate.getDireccion() != null) {
			edificio.setDireccion(edificioToUpdate.getDireccion());
		}
		edificioServicio.update(edificio);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	@ResponseBody
	public void createEdificio(@RequestBody Edificio edificio) {
		log.info("entro en el getEdificios");
		if (edificio.getUnidades() == null)
			edificio.setUnidades(new ArrayList<Unidad>());
		edificioServicio.create(edificio);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Edificio> getEdificios(@RequestParam(value="query", required= false) String query) {
		log.info("entro en el getEdificios");
		if (query == null)
			return edificioServicio.listarTodos();
		else
			return edificioServicio.findByDireccionLike(query);
	}
	

	//se invoca /edificios/{id}
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void updateEdificioById(@PathVariable String id) {
		log.info("entro en el updateEdificioByID");
		Edificio edificio = edificioServicio.findById(Integer.parseInt(id));
		if (edificio.getUnidades().isEmpty())
			edificioServicio.delete(Integer.parseInt(id));
		else {
			//TODO fcrego: el servicio debe lanzar una excepcion de integridad al intentar eliminar un edificio con unidades.
			log.debug("No se puede borrar un edificio que tiene unidades.");
		}
		
	}
	

}
