package es.uned.aw.ped2024.model.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Casting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length=50)
	private String nombre;
	@Column(nullable = false, length=50)
	private String Nacionalidad;
	@Column(nullable = false)
	private LocalDate FechaNacimiento;
	
	public Casting() {}
	public Casting(Long id, String nombre, String nacionalidad, LocalDate fechaNacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		Nacionalidad = nacionalidad;
		FechaNacimiento = fechaNacimiento;
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
		return Nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	public LocalDate getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

}
