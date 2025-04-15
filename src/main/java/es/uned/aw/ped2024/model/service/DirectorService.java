package es.uned.aw.ped2024.model.service;

import java.util.List;

import org.springframework.data.domain.Page;

import es.uned.aw.ped2024.controller.dto.CastingDTO;
import es.uned.aw.ped2024.model.entities.Director;

public interface DirectorService {

	public Director guardar(CastingDTO director);
	
	public List<Director> listarDirector();

	/**
	 * Recuperamos el listado de Directores, incluyendo paginación y ordenación
	 * 
	 * @param pagNnum 		Número de página a mostrar
	 * @param pagSize 		Número de registros por página
	 * @param sortField		Campo a ordenar
	 * @param sortDirection	Dirección "ASC" o "DESC"
	 * @return	Una sublista (Page) de {@link Director}
	 */
	public Page<Director> findAllPaginado(int pagNnum, int pagSize, String sortField, String sortDirection);

	
	public CastingDTO getDirector(Long id);
}
