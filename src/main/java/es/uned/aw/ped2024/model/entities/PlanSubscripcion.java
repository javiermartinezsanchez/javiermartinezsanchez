package es.uned.aw.ped2024.model.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity(name="plan_subscricion")
public class PlanSubscripcion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length=50)
	private String nombre;
	@Column(nullable = false, length=150)
	private String descripcion;
	@Column(nullable = false)
	private LocalDate fechaInicial;
	@Column(nullable = false)
	private LocalDate fechaFinal;
	@Column(nullable = false)
	private Double precio;
	private String periodicidad;
	private Boolean valid;
	
	public PlanSubscripcion() {};
	
	public PlanSubscripcion(Long id, String nombre, String descripcion, LocalDate fechaInicial, LocalDate fechaFinal,
			Double precio, String periodicidad, Boolean valid) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.precio = precio;
		this.periodicidad = periodicidad;
		this.valid = valid;
	}
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDate getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(LocalDate fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public LocalDate getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getPeriodicidad() {
		return periodicidad;
	}
	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}
