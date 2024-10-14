package com.daw.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.daw.persistence.entities.Juego;

public interface JuegoCrudRepository extends CrudRepository<Juego, Integer> {

	
}
