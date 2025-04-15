package es.uned.aw.ped2024.model.service;

import java.util.List;

import org.springframework.data.domain.Page;

import es.uned.aw.ped2024.controller.dto.CastingDTO;
import es.uned.aw.ped2024.model.entities.Artista;


public interface ArtistaService {
	
	public Artista save(CastingDTO artista);
	
	public List<Artista> listArtista();
	
	public CastingDTO getArtista(Long id);

	/**
	 * Recuperamos el listado de Artistas, incluyendo paginación y ordenación
	 * 
	 * @param pagNnum 		Número de página a mostrar
	 * @param pagSize 		Número de registros por página
	 * @param sortField		Campo a ordenar
	 * @param sortDirection	Dirección "ASC" o "DESC"
	 * @return	Una sublista (Page) de {@link Artista}
	 */
	public Page<Artista> findAllPaginado(int pagNnum, int pagSize, String sortField, String sortDirection);

}
