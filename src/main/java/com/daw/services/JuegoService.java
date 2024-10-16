package com.daw.services;

import java.util.List;
import java.util.Optional;

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
	
	//Si tenemos la posibilidad de lo que sea devuelva nulo, lo gestionaoms con optional
	public Optional<Juego> getJuego (int idJuego){
		return this.juegoCrudRepository.findById(idJuego);
	}
	
	public Juego save (Juego juego) {
		return this.juegoCrudRepository.save(juego);
	}
	
	public Juego create (Juego juego) {
		juego.setCompletado(false);
		
		return this.juegoCrudRepository.save(juego);
	}
	
	public boolean delete (int idJuego) {
		boolean result = false;
		
		if(this.getJuego(idJuego).isPresent()) {
			this.juegoCrudRepository.deleteById(idJuego);
			result = true;
		}
		return result;
	}
	
	public List<Juego> getByPrecio(double min, double max){
		return this.juegoCrudRepository.findByPrecioBetween(min, max);
	}
	
	public boolean completarJuego(int id) {		
		if(this.getJuego(id).isPresent()) {
			Juego juego = this.getJuego(id).get();
			if(!juego.getCompletado()) {
				juego.setCompletado(true);
				this.juegoCrudRepository.save(juego);
				return true;
			}
		}
		return false;
}
		
	public boolean descompletar(int id) {
		if(this.getJuego(id).isPresent()) {
			Juego juego = this.getJuego(id).get();
			if(juego.getCompletado()) {
				juego.setCompletado(false);
				this.juegoCrudRepository.save(juego);
				return true;
			}
		}
		return false;
	}
}
