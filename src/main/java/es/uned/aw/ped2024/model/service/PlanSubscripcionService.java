package es.uned.aw.ped2024.model.service;

import java.util.List;

import org.springframework.data.domain.Page;

import es.uned.aw.ped2024.model.entities.PlanSubscripcion;

public interface PlanSubscripcionService {

	/**
	 * Guardamos la entidad, si el "id" no existe la añadimos, si no se actualiza.
	 * 
	 * @param ps La entidad a guardar.
	 * 
	 * @return <b>PlanSubscripcion</b> La entidad guardada.
	 */
	public PlanSubscripcion save(PlanSubscripcion ps);
	public List<PlanSubscripcion> listPlanSubscripcion();
	public List<PlanSubscripcion> listPlanSubscripcionActivos();
	public PlanSubscripcion get(Long id);
	/**
	 * <p>Borrado de la una entidad {@link PlanSubscripcion} 
	 * @param id Identificador a borrar
	 */
	public void delete(Long id);
	/**
	 * Recuperamos el listado de Planes de Subscripció, incluyendo paginación y ordenación
	 * 
	 * @param pagNnum 		Número de página a mostrar
	 * @param pagSize 		Número de registros por página
	 * @param sortField		Campo a ordenar
	 * @param sortDirection	Dirección "ASC" o "DESC"
	 * @return	Una sublista (Page) de {@link PlanSubscripcion}
	 */
	public Page<PlanSubscripcion> findAllPaginado(int pagNnum, int pagSize, String sortField, String sortDirection);

}
