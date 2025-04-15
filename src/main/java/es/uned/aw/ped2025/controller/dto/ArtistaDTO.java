package es.uned.aw.ped2025.controller.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;

/* 
 * Projection para utilizar el patrón DTO de la entidad Artista
 *  
 */
public interface ArtistaDTO {
	Long getId();
	String getNombre();
	String getNacionalidad();
	LocalDate getFechaNacimiento();
}
