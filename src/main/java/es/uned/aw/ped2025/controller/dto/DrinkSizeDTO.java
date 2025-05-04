package es.uned.aw.ped2025.controller.dto;

import java.time.LocalDate;

/* 
 * Projection para utilizar el patrón DTO de la entidad Actor
 *  
 */
public interface ActorDTO {
	Long getId();
	String getNombre();
	String getNacionalidad();
	LocalDate getFechaNacimiento();
}
