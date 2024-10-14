package com.daw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.persistence.crud.JuegoCrudRepository;
import com.daw.persistence.entities.Juego;

@Service
public class JuegoService  {
	
	@Autowired
	private JuegoCrudRepository juegoCrudRepository;
	
	
	public List<Juego> getAll(){
		return (List<Juego>) this.juegoCrudRepository.findAll();
	}
	
}
