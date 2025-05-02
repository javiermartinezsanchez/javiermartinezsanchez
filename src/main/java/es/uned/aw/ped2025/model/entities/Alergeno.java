package es.uned.aw.ped2025.model.entities;

import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// https://www.baeldung.com/java-hibernate-uuid-primary-key
@Entity
public class Alergeno {
	
	@Id
	@UuidGenerator
	private UUID id;
	@Column(nullable=false, length=50)
	private String nombre;
	@Column(nullable=false, length=150)
	private String rutaImagen;
	
	public Alergeno() {}
	public Alergeno(String nombre) {
		this.nombre = nombre;
	}

	public UUID getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	
	public String getRutaImagen() {
		return this.rutaImagen;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((rutaImagen == null) ? 0 : rutaImagen.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alergeno other = (Alergeno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (rutaImagen == null) {
			if (other.rutaImagen != null)
				return false;
		} else if (!rutaImagen.equals(other.rutaImagen))
			return false;
		return true;
	}

}