package com.daw.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.persistence.entities.Juego;
import com.daw.services.JuegoService;

@RestController
@RequestMapping("/juegos")
public class JuegoController {
	
	@Autowired
	private JuegoService juegoService;

	@GetMapping
	public ResponseEntity<List<Juego>> list(){
		return ResponseEntity.ok(this.juegoService.getAll());
	}
}
