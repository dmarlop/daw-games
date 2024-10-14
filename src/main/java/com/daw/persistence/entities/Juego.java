package com.daw.persistence.entities;

import java.sql.Date;
import java.time.LocalDateTime;

import com.daw.persistence.entities.enums.Tipo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="juego")
public class Juego {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String genero;
	private String compania;
	private String plataforma;
	private Double precio;
	private Integer descargas;
	
	@Column(name = "fecha_vencimiento")
	private LocalDateTime fechaLanzamiento;
	
	@Column (name = "tipo")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@Column (name = "completado")
	private Boolean completado;
	
	
	
	
	
	
}
