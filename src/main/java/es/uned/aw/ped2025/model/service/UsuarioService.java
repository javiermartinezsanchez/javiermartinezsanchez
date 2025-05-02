package es.uned.aw.ped2025.model.service;

import java.util.List;

import org.springframework.data.domain.Page;

import es.uned.aw.ped2025.controller.dto.UsuarioRegistroDTO;
import es.uned.aw.ped2025.model.entities.Role;
import es.uned.aw.ped2025.model.entities.Usuario;

public interface UsuarioService {
	
	/**
	 * Obtenemos el listado de usuarios existentes.
	 * 
	 * @return Listado de usuarios.
	 */
	List<Usuario> listUser();
	/**
	 * Recuperamos el listado de Usuarios, incluyendo paginación y ordenación
	 * 
	 * @param pagNnum 		Número de página a mostrar
	 * @param pagSize 		Número de registros por página
	 * @param sortField		Campo a ordenar
	 * @param sortDirection	Dirección "ASC" o "DESC"
	 * @return	Una sublista (Page) de {@link Usuario}
	 */
	public Page<Usuario> findAllPaginado(int pagNnum, int pagSize, String sortField, String sortDirection);
	
	/**
	 * Búsqueda de un usuario por su email.
	 * @param email Dirección email de 
	 * @return 
	 * <b>Usuario</b> o null si no se ha encontrado.
	 */
	Usuario findUserByEmail(String email);
	
	/**
	 * 
	 * @param id de usuario a buscar
	 * @return <b>Optional</b> del usuario encontrado
	 */
	Usuario getUserByID(long id);
	
	/**
	 * Modificación de password de usuario.
	 * 
	 * @param usuario Usuario actual
	 * @param password Nueva password
	 */
	void changeUserPassword(Usuario usuario, String password);
	/**
	 * 
	 * @param user Usuario actual
	 * @param password Actual a comprobar
	 * @return <b>True</b> si coincide, <b>false</b> si no
	 */
	boolean checkIfValidOldPassword(Usuario user, String password);
	/**
	 * Registro de nuevo usuario
	 * 
	 * @param
	 * userDTO DTO con la información del nuevo usuario
	 * 
	 * @return
	 * <b>Usuario</b> Nuevo usuario dado de alta.
	 */
	Usuario newUserAccount(UsuarioRegistroDTO userDTO, List<Long> roles);
	
	/**
	 * Borrado de un usuario
	 * @param usuario Usuario a eliminar
	 *   
	 */
	void delete(Usuario usuario);
	/**
	 * Actualizamos información de un usuario.
	 * 
	 * @param usuario a guardar.
	 */
	void saveUsuario(Usuario usuario, List<Long> roles);
}
