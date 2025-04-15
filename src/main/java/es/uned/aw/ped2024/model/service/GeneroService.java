package es.uned.aw.ped2024.model.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;

import es.uned.aw.ped2024.controller.dto.GeneroDTO;
import es.uned.aw.ped2024.model.entities.Alergeno;

public interface GeneroService {
	public GeneroDTO save(GeneroDTO genero);
	public List<Alergeno> listarGenero();
	/**
	 * <p>Buscador de Genero por ID</p> 
	 * @param UUID id 
	 * 
	 * @return El DTO de la entidad encontrada.
	 */
	public GeneroDTO getGenero(UUID id);
	public void delete(UUID id);
	
	Page<Alergeno> findAllPaginado(int pagNum, int pagSize, String sortField, String sortDirection);
}
