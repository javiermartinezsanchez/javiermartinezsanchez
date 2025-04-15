package es.uned.aw.ped2024.model.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class ListaReproPK implements Serializable{

	private static final long serialVersionUID = 1L;
	long usuarioId;
	long contenidoId;
	
	public ListaReproPK() {};
	
	public ListaReproPK(long id_socio, long id_contenido) {
		
		this.usuarioId = id_socio;
		this.contenidoId = id_contenido;
	}
	public long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(long id_socio) {
		this.usuarioId = id_socio;
	}
	public long getContenidoId() {
		return contenidoId;
	}
	public void setContenidoId(long id_contenido) {
		this.contenidoId = id_contenido;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (contenidoId ^ (contenidoId >>> 32));
		result = prime * result + (int) (usuarioId ^ (usuarioId >>> 32));
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
		ListaReproPK other = (ListaReproPK) obj;
		if (contenidoId != other.contenidoId)
			return false;
		if (usuarioId != other.usuarioId)
			return false;
		return true;
	}
}
