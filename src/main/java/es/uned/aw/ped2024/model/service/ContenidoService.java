package es.uned.aw.ped2024.model.service;

import java.util.List;

import org.springframework.data.domain.Page;

import es.uned.aw.ped2024.model.entities.Contenido;

public interface ContenidoService {
	public Contenido save(Contenido actorDTO);
	
	public List<Contenido> listContenido();
	
	public Contenido getContenido(Long id);

	/**
	 * Recuperamos el listado de Contenidos, incluyendo paginación y ordenación
	 * 
	 * @param pagNnum 		Número de página a mostrar
	 * @param pagSize 		Número de registros por página
	 * @param sortField		Campo a ordenar
	 * @param sortDirection	Dirección "ASC" o "DESC"
	 * @return	Una sublista (Page) de {@link Contenido}
	 */
	public Page<Contenido> findAllPaginado(int pagNnum, int pagSize, String sortField, String sortDirection);
	
	public void deleteContenido(Long id);

	public Page<Contenido> findNovedadesPaginado(int pagNum, int i);

}
