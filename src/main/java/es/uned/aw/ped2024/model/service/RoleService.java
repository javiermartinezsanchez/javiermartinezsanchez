package es.uned.aw.ped2024.model.service;

import java.util.List;

import es.uned.aw.ped2024.model.entities.Role;

/**
 * Interfaz del servico de Role
 **/
public interface RoleService {

	/**
	 * <b>ListAll</b>
	 * 
	 * @return Listado de Roles existentes
	 * */
	public List<Role> listAll();
}
