package es.uned.aw.ped2024.model.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
@Entity
public class ListaRepro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ListaReproPK listaReproPK;
	
	@MapsId("usuarioId")
	@ManyToOne
	@JoinColumn(name="usuario_id",
		foreignKey=@ForeignKey(name="FK_SOCIO_LISTA"))
	private Cliente socio;
	
	@MapsId("contenidoId")
	@ManyToOne
	@JoinColumn(name="contenido_id",
		foreignKey=@ForeignKey(name="FK_CONTENIDO_LISTA"))
	private Contenido contenido;
	
	@Column(name="fecha_insercion")
	private LocalDateTime fechaAdded;
	
	@Column(name="fecha_ultima_vista")
	private LocalDateTime fechaLastView;
	
	public ListaRepro() {
		this.listaReproPK = new ListaReproPK();
	}

	public ListaRepro(ListaReproPK listaReproPK, Cliente socio, Contenido contenido, LocalDateTime fechaAdded,
			LocalDateTime fechaLastView) {
		super();
		this.listaReproPK = listaReproPK;
		this.socio = socio;
		this.contenido = contenido;
		this.fechaAdded = fechaAdded;
		this.fechaLastView = fechaLastView;
	}

	public ListaReproPK getListaReproPK() {
		return listaReproPK;
	}

	private void setListaReproPK(ListaReproPK listaReproPK) {
		this.listaReproPK = listaReproPK;
	}

	public Cliente getSocio() {
		return socio;
	}

	public void setSocio(Cliente socio) {
		this.socio = socio;
	}

	public Contenido getContenido() {
		return contenido;
	}

	public void setContenido(Contenido contenido) {
		this.contenido = contenido;
	}

	public LocalDateTime getFechaAdded() {
		return fechaAdded;
	}

	public void setFechaAdded(LocalDateTime fechaAdded) {
		this.fechaAdded = fechaAdded;
	}

	public LocalDateTime getFechaLastView() {
		return fechaLastView;
	}

	public void setFechaLastView(LocalDateTime fechaLastView) {
		this.fechaLastView = fechaLastView;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contenido == null) ? 0 : contenido.hashCode());
		result = prime * result + ((fechaAdded == null) ? 0 : fechaAdded.hashCode());
		result = prime * result + ((fechaLastView == null) ? 0 : fechaLastView.hashCode());
		result = prime * result + ((listaReproPK == null) ? 0 : listaReproPK.hashCode());
		result = prime * result + ((socio == null) ? 0 : socio.hashCode());
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
		ListaRepro other = (ListaRepro) obj;
		if (contenido == null) {
			if (other.contenido != null)
				return false;
		} else if (!contenido.equals(other.contenido))
			return false;
		if (fechaAdded == null) {
			if (other.fechaAdded != null)
				return false;
		} else if (!fechaAdded.equals(other.fechaAdded))
			return false;
		if (fechaLastView == null) {
			if (other.fechaLastView != null)
				return false;
		} else if (!fechaLastView.equals(other.fechaLastView))
			return false;
		if (listaReproPK == null) {
			if (other.listaReproPK != null)
				return false;
		} else if (!listaReproPK.equals(other.listaReproPK))
			return false;
		if (socio == null) {
			if (other.socio != null)
				return false;
		} else if (!socio.equals(other.socio))
			return false;
		return true;
	}

	
}
