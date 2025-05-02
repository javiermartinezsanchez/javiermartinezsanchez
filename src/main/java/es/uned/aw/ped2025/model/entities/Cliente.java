package es.uned.aw.ped2025.model.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
/**
 *   <b>Cliente</b>
 *   
 *   <p>Entidad principal de los clientes en la que se reflejan los datos básicos del mismo.
 *   
 *   <p>El id se genera en la tabla de {@code Usuario}
 */
@Entity
@Table(name="Clientes")
public class Cliente {

	@Id
	@Column(name="usuario_id")
	private Long id;
	
	@Column(name="Direccion", length=50, nullable=false)
	private String direccion;
	@Column(name="Poblacion", length=50, nullable=false)
	private String poblacion;
	@Column(name="Provincia", length=50, nullable=false)
	private String provincia;
	@Column(name="cod_postal", length=5, nullable=false)
	private String codPostal;
	@Column(name="tarjeta_credito", length=16, nullable=false)
	private String creditCard;

	@OneToOne
	@MapsId
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public Cliente() {}

	public Cliente(Long id, String apellidos, String direccion, String poblacion, String provincia, String codPostal,
			Usuario usuario) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.provincia = provincia;
		this.codPostal = codPostal;
		
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApellidos() {
		return this.usuario.getApellidos();
	}

	public void setApellidos(String apellidos) {
		this.usuario.setApellidos(apellidos);
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPostal == null) ? 0 : codPostal.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((poblacion == null) ? 0 : poblacion.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Cliente other = (Cliente) obj;
		if (codPostal == null) {
			if (other.codPostal != null)
				return false;
		} else if (!codPostal.equals(other.codPostal))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (poblacion == null) {
			if (other.poblacion != null)
				return false;
		} else if (!poblacion.equals(other.poblacion))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
