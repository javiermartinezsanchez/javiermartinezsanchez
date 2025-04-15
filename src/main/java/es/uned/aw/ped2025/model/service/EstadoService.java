package es.uned.aw.ped2025.model.service;

import java.util.List;

import org.springframework.data.domain.Page;

import es.uned.aw.ped2024.controller.dto.CastingDTO;
import es.uned.aw.ped2024.model.entities.Actor;


public interface EstadoService {
	
	public Estado save(EstadoDTO actorDTO);
	
	public List<Estado> listEstado();
	
	public EstadoDTO getEstado(Integer id);

	/**
	 * Recuperamos el listado de Actores, incluyendo paginación y ordenación
	 * 
	 * @param pagNnum 		Número de página a mostrar
	 * @param pagSize 		Número de registros por página
	 * @param sortField		Campo a ordenar
	 * @param sortDirection	Dirección "ASC" o "DESC"
	 * @return	Una sublista (Page) de {@link Actor}
	 */
	public Page<Estado> findAllPaginado(int pagNnum, int pagSize, String sortField, String sortDirection);

	
	public void deleteEstado(Integer id);
	
}
