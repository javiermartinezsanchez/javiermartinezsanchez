package es.uned.aw.ped2025.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import es.uned.aw.ped2025.controller.dto.UsuarioRegistroDTO;
import es.uned.aw.ped2025.exception.UserAlreadyExistException;
import es.uned.aw.ped2025.model.entities.Role;
import es.uned.aw.ped2025.model.entities.Usuario;
import es.uned.aw.ped2025.model.repository.RoleRepository;
import es.uned.aw.ped2025.model.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	
	@Autowired
    private UsuarioRepository userRepository;
	
    @Autowired
    private RoleRepository roleRepository;
    
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	
	@Override
	public List<Usuario> listUser() {
		return userRepository.findAll();
	}

    @Override
    public Usuario findUserByEmail(final String email) {
        return userRepository.findByEmail(email);
    }


	@Override
	public Usuario getUserByID(long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public void changeUserPassword(Usuario usuario, String password) {
		usuario.setPassword(passwordEncoder.encode(password));
        userRepository.save(usuario);

	}
	
	

	@Override
	public boolean checkIfValidOldPassword(Usuario user, String password) {
	       return passwordEncoder.matches(password, user.getPassword());
	       	}

	@Override
	public Usuario newUserAccount(UsuarioRegistroDTO userDTO, List<Long> roles) {
	       if (emailExists(userDTO.getEmail())) {
	            throw new UserAlreadyExistException("Ya existe una cuenta con ese e-mail: " + userDTO.getEmail());
	        }
	        final Usuario user = new Usuario();

	        user.setNombre(userDTO.getNombre());
	        user.setApellidos(userDTO.getApellidos());
	        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
	        user.setEmail(userDTO.getEmail());
	        user.setRoles(defineRoles(roles));
	        return userRepository.save(user);

	}

	private List<Role> defineRoles(List<Long> roles) {

		if (roles.isEmpty()) {
			return Collections.singletonList(roleRepository.findByNombre("ROLE_USER"));
		}
		else {
			List<Role> rolesE = new ArrayList<>();
			for (Long id : roles) {
				rolesE.add(roleRepository.findById(id).get());
			}
			return rolesE;
		}
	}

	@Override
	public void delete(Usuario usuario) {
		userRepository.delete(usuario);

	}

	@Override
	public void saveUsuario(Usuario usuario, List<Long> roles) {
        usuario.setRoles(defineRoles(roles));

		userRepository.save(usuario);

	}
	
    private boolean emailExists(final String email) {
        return userRepository.findByEmail(email) != null;
    }

	@Override
	public Page<Usuario> findAllPaginado(int pagNum, int pagSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? 
				Sort.by(sortField).ascending() : 
				Sort.by(sortField).descending();
	    Pageable pagina = PageRequest.of(pagNum - 1 , pagSize, sort);
	    return this.userRepository.findAll(pagina);
	}


}
