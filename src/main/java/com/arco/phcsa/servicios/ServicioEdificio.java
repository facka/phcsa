package com.arco.phcsa.servicios;

import java.util.List;

import com.arco.phcsa.dominio.Edificio;

public interface ServicioEdificio {
	
	public Edificio create(Edificio edificio);
	public Edificio delete(int id);
	public List<Edificio> listarTodos();
	public Edificio update(Edificio Edificio);
	public Edificio findById(int id);

}
