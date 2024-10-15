package com.daw.web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/{idJuego}")
	public ResponseEntity<Juego> findById (@PathVariable("idJuego") int idJuego){
		Optional<Juego> juego = this.juegoService.getJuego(idJuego);
		
		if(juego.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		else {
			//El .get() abre la caja y lo obtiene
			return ResponseEntity.ok(juego.get());
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Juego> create (@RequestBody Juego juego){
		return new ResponseEntity<Juego>(this.juegoService.create(juego), HttpStatus.CREATED);
	}
	
	@PutMapping("/{idJuego}")
	public ResponseEntity<Juego> update(@PathVariable("idJuego") int idJuego, @RequestBody Juego juego){
		//El primer idJuego es el que le estamos mandando por parámetro
		if(idJuego != juego.getId()) {
			return ResponseEntity.badRequest().build();
		}
		if(this.juegoService.getJuego(idJuego).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(this.juegoService.save(juego));
		
	}
	
	@DeleteMapping("/{idJuego}")
	public ResponseEntity<Juego> delete(@PathVariable("idJuego") int idJuego){
		if(this.juegoService.delete(idJuego)) {
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping("/precio")
	public ResponseEntity<List<Juego>> buscarPoPrecio(@RequestParam("min") double min,@RequestParam("max") double max){
		return ResponseEntity.ok(this.juegoService.getByPrecio(min, max));
	}
	
	
	
	
	
}
