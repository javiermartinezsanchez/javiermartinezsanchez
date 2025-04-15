package es.uned.aw.ped2024.model.service;

import org.springframework.data.domain.Page;

import es.uned.aw.ped2024.model.entities.UserAudit;

public interface UserAuditService {

	/**
	 * Guardamos nuevo registro de auditoría.
	 * 
	 * @param nombreUsuario Usuario a auditar
	 * @param mensaje       Mensaje de auditoría
	 */
	public void save(String nombreUsuario, String mensaje);
	
	/**
	 * Recuperación de registro de auditoría. 
	 * 
	 * <p>Devuelve una {@link Page}  de la auditoría
	 * @param pagNnum Número de página a devolver (0 es la inicial)
	 * @param pagSize Offset o tamaño de la página a devolver.
	 * @param sortField Campo por el que se ordena
	 * @param sortDirection Dirección de la ordenación <b>ASC</b> o <b>DES</b>
	 * @return Una página de los datos requeridos.
	 */
	public Page<UserAudit> findAllPaginado(int pagNnum, int pagSize, String sortField, String sortDirection);

}
