package com.arco.phcsa.servicios;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arco.phcsa.dominio.Edificio;
import com.arco.phcsa.repositorios.EdificioRepositorio;

@Service
public class ServicioEdificiosImpl implements ServicioEdificio {

	@Resource
	private EdificioRepositorio edificioRepositorio;

	@Override
	@Transactional
	public List<Edificio> ListarTodos() {
		return edificioRepositorio.findAll();
	}

	public void crearEdificio() {
		Edificio edificio = new Edificio(1, "Larrea 1354");
		create(edificio);
		edificio = new Edificio(2, "Marcelo T. De Alvear 1934");
	}

	@Override
	@Transactional
	public Edificio create(Edificio edificio) {
		Edificio creatededificio = edificio;
		return edificioRepositorio.save(creatededificio);
	}

	@Override
	@Transactional
	public Edificio delete(int id) {
		Edificio deletedEdificio = edificioRepositorio.findOne(id);

		if (deletedEdificio != null)
			edificioRepositorio.delete(deletedEdificio);
		return deletedEdificio;
	}

	@Override
	@Transactional
	public Edificio update(Edificio edificio) {
		Edificio updatedEdificio = edificioRepositorio.findOne(edificio
				.getIdEdificio());

		if (updatedEdificio != null) {
			updatedEdificio.setDireccion(edificio.getDireccion());
			updatedEdificio.setUnidades(edificio.getUnidades());
		}
		return updatedEdificio;
	}

	@Override
	@Transactional
	public Edificio findById(int id) {
		return edificioRepositorio.findOne(id);
	}

}
