package es.uned.aw.ped2025.model.service;

import java.util.List;

import org.springframework.data.domain.Page;

import es.uned.aw.ped2025.controller.dto.EstadoDTO;
import es.uned.aw.ped2025.model.entities.Estado;

public interface EstadoService {
	
	public Estado save(EstadoDTO actorDTO);
	
	public List<EstadoDTO> list();
	
	public EstadoDTO get(Integer id);

	/**
	 * Recuperamos el listado de Estadoluyendo paginación y ordenación
	 * 
	 * @param pagNnum 		Número de página a mostrar
	 * @param pagSize 		Número de registros por página
	 * @param sortField		Campo a ordenar
	 * @param sortDirection	Dirección "ASC" o "DESC"
	 * @return	Una sublista (Page) de {@link Estado}
	 */
	public Page<EstadoDTO> findAllPaginado(int pagNnum, int pagSize, String sortField, String sortDirection);
	
	public void deleteEstado(Integer id);
	
}
