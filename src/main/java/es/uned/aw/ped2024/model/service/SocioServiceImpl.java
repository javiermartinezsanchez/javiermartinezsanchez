package es.uned.aw.ped2024.model.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import es.uned.aw.ped2024.controller.ChangePasswordRequest;
import es.uned.aw.ped2024.controller.dto.UsuarioRegistroDTO;
import es.uned.aw.ped2024.model.entities.Actor;
import es.uned.aw.ped2024.model.entities.Director;
import es.uned.aw.ped2024.model.entities.Alergeno;
import es.uned.aw.ped2024.model.entities.Cliente;
import es.uned.aw.ped2024.model.entities.Usuario;
import es.uned.aw.ped2024.model.repository.ClienteRepository;

@Service
public class SocioServiceImpl implements SocioService {

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ClienteRepository socioRepository;
	@Override
	public List<Cliente> listSocios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente newSocio(UsuarioRegistroDTO userDTO, List<Alergeno> generos, List<Actor> actores,
			List<Director> directores) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void changePassword(ChangePasswordRequest request, Principal actualUser) {
		
		var user = (Usuario) ((UsernamePasswordAuthenticationToken) actualUser).getPrincipal();
		
		if (!passwordEncoder.matches(request.getActualPassword(),user.getPassword())) {
			throw new IllegalStateException("Wrong password");
		}
		
		if (!request.getNewPassword().equals(request.getRepeatPassword())) {
			throw new IllegalStateException("Password not match!!");
		}
		
		// Modificar la contraseña del usuario y guardarlo
		var socio = socioRepository.getReferenceById(user.getId());
		if (socio != null) {
			
			socio.getUsuario().setPassword(passwordEncoder.encode(request.getNewPassword()));
			
			socioRepository.save(socio);
		}
	}

	@Override
	public Page<Cliente> findAllPaginado(int pagNum, int pagSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? 
				Sort.by(sortField).ascending() : 
				Sort.by(sortField).descending();
	    Pageable pagina = PageRequest.of(pagNum - 1 , pagSize, sort);
	    return this.socioRepository.findAll(pagina);
	}

}
