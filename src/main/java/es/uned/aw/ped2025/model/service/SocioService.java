package es.uned.aw.ped2024.model.service;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;

import es.uned.aw.ped2025.controller.ChangePasswordRequest;
import es.uned.aw.ped2025.controller.dto.UsuarioRegistroDTO;
import es.uned.aw.ped2025.model.entities.Actor;
import es.uned.aw.ped2025.model.entities.Director;
import es.uned.aw.ped2025.model.entities.Genero;
import es.uned.aw.ped2025.model.entities.Cliente;

public interface SocioService {
	/**
	 * Obtenemos el listado de socios existentes.
	 * 
	 * @return Listado de {@link Cliente}
	 */
	public List<Cliente> listSocios();
	
	/**
	 * Recuperamos el listado de Socios, incluyendo paginación y ordenación
	 * 
	 * @param pagNnum 		Número de página a mostrar
	 * @param pagSize 		Número de registros por página
	 * @param sortField		Campo a ordenar
	 * @param sortDirection	Dirección "ASC" o "DESC"
	 * @return	Una sublista (Page) de {@link Cliente}
	 */
	public Page<Cliente> findAllPaginado(int pagNnum, int pagSize, String sortField, String sortDirection);

	public Cliente newSocio(UsuarioRegistroDTO userDTO, 
			List<Alergeno> generos, 
			List<Actor> actores,
			List<Director> directores) ;

	public void changePassword(ChangePasswordRequest request, Principal actualUser);
}
