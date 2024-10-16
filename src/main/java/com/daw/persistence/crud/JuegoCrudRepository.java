package com.daw.persistence.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daw.persistence.entities.Juego;
import com.daw.persistence.entities.enums.Tipo;

public interface JuegoCrudRepository extends CrudRepository<Juego, Integer> {

	List<Juego> findByPrecioBetween (double min, double max);
	List<Juego> findByTipo (Tipo tipo);
}
