package es.uned.aw.ped2025.controller.dto;

public class EstadoDTO {
	private Integer id;
	
	private String nombre;

	public EstadoDTO(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public EstadoDTO() {	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
