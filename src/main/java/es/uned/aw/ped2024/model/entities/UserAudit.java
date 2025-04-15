package es.uned.aw.ped2024.model.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Auditoria_accesos")
public class UserAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombreUsuario;
	private String mensaje;
	private LocalDateTime timeStamp;
	public UserAudit() {
		super();
	}
	public UserAudit(String nombreUsuario, String mensaje, LocalDateTime timeStamp) {
		this.nombreUsuario = nombreUsuario;
		this.mensaje = mensaje;
		this.timeStamp = timeStamp;
	}
	public Long getId() {
		return id;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
