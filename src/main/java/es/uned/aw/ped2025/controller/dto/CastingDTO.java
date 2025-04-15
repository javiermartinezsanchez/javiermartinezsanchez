package es.uned.aw.ped2025.controller.dto;

import java.time.LocalDate;

import es.uned.aw.ped2024.model.entities.Actor;
import es.uned.aw.ped2024.model.entities.Director;

public class CastingDTO {
	private Long id;
	private String nombre;
	private String nacionalidad;
	private LocalDate fechaNacimiento;
	
	public CastingDTO(Long id, String nombre, String nacionalidad, LocalDate fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
	}

	public CastingDTO() {
	}
	public CastingDTO(Actor actor) {
		this(actor.getId(), 
				actor.getNombre(), 
				actor.getNacionalidad(), 
				actor.getFechaNacimiento());
	}
	public CastingDTO(Director director) {
		this(director.getId(), 
				director.getNombre(), 
				director.getNacionalidad(), 
				director.getFechaNacimiento());
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
}
