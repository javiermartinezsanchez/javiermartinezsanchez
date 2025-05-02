package es.uned.aw.ped2025.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uned.aw.ped2025.model.entities.Role;
import es.uned.aw.ped2025.model.repository.RoleRepository;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	@Override
	public List<Role> listAll() {
		
		return roleRepository.findAll();
	}

}
