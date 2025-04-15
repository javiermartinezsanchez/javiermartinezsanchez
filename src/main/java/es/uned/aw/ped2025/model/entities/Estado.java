package es.uned.aw.ped2025.model.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Estado {

	@Id
	private int idEstado;
	@Column(nullable=false, length=50)
	private String nombre;
	
	public Estado() {}
	
	public Estado(int idEstado, String nombre) {
		this.idEstado = idEstado;
		this.nombre = nombre;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idEstado, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		return idEstado == other.idEstado && Objects.equals(nombre, other.nombre);
	}
	@Override
	public String toString() {
		return "Estado [idEstado=" + idEstado + ", nombre=" + nombre + "]";
	}
}
