package es.uned.aw.ped2024.model.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="contenidos")
public class Contenido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private TipoContenido tipoContenido;
	@Column(name="titulo", nullable = false, length=50 )
	private String titulo;
	@Column(name="productora", nullable = false, length=50 )
	private String productora;
	
	@ManyToMany
	@JoinTable(
	name="contenido_directores",
	joinColumns=@JoinColumn(name="id_contenido",
	foreignKey=@ForeignKey(name="FK_contenido"),
	nullable=false),
	inverseJoinColumns=@JoinColumn(name="id_director",
	foreignKey=@ForeignKey(name="FK_director"),
	nullable=false)
	)
	private List<Director> director;
	
	@ManyToMany
	@JoinTable(
	name="contenido_actor",
	joinColumns=@JoinColumn(name="id_contenido",
	foreignKey=@ForeignKey(name="FK_contenido_actor"),
	nullable=false),
	inverseJoinColumns=@JoinColumn(name="id_actor",
	foreignKey=@ForeignKey(name="FK_actor"),
	nullable=false)
	)
	private List<Actor> actores;
	
	@Column(name="fecha_estreno")
	private LocalDate fechaEstreno;
	
	@ManyToOne
	@JoinColumn(name = "id_genero")
	private Alergeno genero;
	/**
	 *    Guardamos el path o la URL externa de la imágen de la carátula.
	 */
	@Column(name="path_caratula")
	private String pathCaratula;
	
	/**
	 *    Guardamos el path o la URL externa del contenido para su visualización.
	 */
	@Column(name="path_contenido")
	private String pathContenido;

	public Contenido(Long id, TipoContenido tipoContenido, String titulo, List<Director> director, List<Actor> actores,
			LocalDate fechaEstreno, Alergeno genero, String pathCaratula, String pathContenido) {
		super();
		this.id = id;
		this.tipoContenido = tipoContenido;
		this.titulo = titulo;
		this.director = director;
		this.actores = actores;
		this.fechaEstreno = fechaEstreno;
		this.genero = genero;
		this.pathCaratula = pathCaratula;
		this.pathContenido = pathContenido;
	}
	public Contenido() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoContenido getTipoContenido() {
		return tipoContenido;
	}
	public void setTipoContenido(TipoContenido tipoContenido) {
		this.tipoContenido = tipoContenido;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<Director> getDirector() {
		return director;
	}
	public void setDirector(List<Director> director) {
		this.director = director;
	}
	public List<Actor> getActores() {
		return actores;
	}
	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}
	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public Alergeno getGenero() {
		return genero;
	}
	public void setGenero(Alergeno genero) {
		this.genero = genero;
	}
	public String getPathCaratula() {
		return pathCaratula;
	}
	public void setPathCaratula(String pathCaratula) {
		this.pathCaratula = pathCaratula;
	}
	public String getPathContenido() {
		return pathContenido;
	}
	public void setPathContenido(String pathContenido) {
		this.pathContenido = pathContenido;
	}
	public String getProductora() {
		return productora;
	}
	public void setProductora(String productora) {
		this.productora = productora;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actores == null) ? 0 : actores.hashCode());
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((fechaEstreno == null) ? 0 : fechaEstreno.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pathCaratula == null) ? 0 : pathCaratula.hashCode());
		result = prime * result + ((pathContenido == null) ? 0 : pathContenido.hashCode());
		result = prime * result + ((productora == null) ? 0 : productora.hashCode());
		result = prime * result + ((tipoContenido == null) ? 0 : tipoContenido.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Contenido other = (Contenido) obj;
		if (actores == null) {
			if (other.actores != null)
				return false;
		} else if (!actores.equals(other.actores))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (fechaEstreno == null) {
			if (other.fechaEstreno != null)
				return false;
		} else if (!fechaEstreno.equals(other.fechaEstreno))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pathCaratula == null) {
			if (other.pathCaratula != null)
				return false;
		} else if (!pathCaratula.equals(other.pathCaratula))
			return false;
		if (pathContenido == null) {
			if (other.pathContenido != null)
				return false;
		} else if (!pathContenido.equals(other.pathContenido))
			return false;
		if (productora == null) {
			if (other.productora != null)
				return false;
		} else if (!productora.equals(other.productora))
			return false;
		if (tipoContenido != other.tipoContenido)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
}
