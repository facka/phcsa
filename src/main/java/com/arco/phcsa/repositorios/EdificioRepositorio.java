package com.arco.phcsa.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arco.phcsa.dominio.Edificio;

public interface EdificioRepositorio extends JpaRepository<Edificio, Integer> {

	List<Edificio> findByDireccionLike(String direccion);

}
