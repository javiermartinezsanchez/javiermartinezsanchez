package es.uned.aw.ped2025.controller.dto;

public class UsuarioRegistroDTO {

	private Long id;
	private String email;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String poblacion;
	private String provincia;
	private String codPostal;
	private String password;
	private boolean enabled;

	public UsuarioRegistroDTO(String nombre, String apellido, String email, String password, boolean enabled) {
		super();
		this.nombre = nombre;
		this.apellidos = apellido;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}

	public UsuarioRegistroDTO() {

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getApellidos() {
		return this.apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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


}
