package es.uned.aw.ped2025.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import es.uned.aw.ped2024.model.entities.Contenido;
import es.uned.aw.ped2024.model.entities.Director;
import es.uned.aw.ped2024.model.entities.Estado;
import es.uned.aw.ped2024.model.entities.Alergeno;
import es.uned.aw.ped2024.model.entities.PlanSubscripcion;
import es.uned.aw.ped2024.model.entities.Role;
import es.uned.aw.ped2024.model.entities.TipoContenido;
import es.uned.aw.ped2024.model.entities.Usuario;
import es.uned.aw.ped2024.model.repository.ActorRepository;
import es.uned.aw.ped2024.model.repository.ContenidoRepository;
import es.uned.aw.ped2024.model.repository.DirectorRepository;
import es.uned.aw.ped2024.model.repository.EstadoRepository;
import es.uned.aw.ped2024.model.repository.GeneroRepository;
import es.uned.aw.ped2024.model.repository.PlanSubscripcionRepository;
import es.uned.aw.ped2024.model.repository.RoleRepository;
import es.uned.aw.ped2024.model.repository.UsuarioRepository;

/**
 *    Carga inicial de datos de prueba:
 *    
 *    <ul><li>Usuarios</li>
 *    <li>Roles</li>
 *    <li>Artistas</li>
 *    <li>Directores</li>
 *    <li>Generos</li>
 *    <li>Contenidos</li>
 *    <li>Subscriptores</li></li>
 *    </ul>
 */
@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private UsuarioRepository usarioRepository;
	@Autowired
	private RoleRepository rolRepository;

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
    private boolean alreadySetup = false;

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        // == Creamos roles iniciales
        final Role adminRole = createRoleIfNotFound("ROLE_ADMIN");
        final Role userRole = createRoleIfNotFound("ROLE_USER");
        final Role empleadoRole = createRoleIfNotFound("ROLE_EMPLEADO");

        // == Creamos usuarios iniciales
        createUserIfNotFound("admin@correo.com", "Javier", "Martínez", "1234.1234", new ArrayList<>(Arrays.asList(adminRole)));
        createUserIfNotFound("empleado1@correo.com", "Antonio", "López", "test", new ArrayList<>(Arrays.asList(empleadoRole)));
        createUserIfNotFound("cliente1@correo.com", "Macarena", "Carrasco Martín", "socio.1", new ArrayList<>(Arrays.asList(userRole)));

        createEstadoIfNotFound(0, "Nuevo");
        createEstadoIfNotFound(1, "Pagado");
        createEstadoIfNotFound(2, "Pendiente");
        createEstadoIfNotFound(3, "En Elaboración");
        createEstadoIfNotFound(4, "Enviado");
        createEstadoIfNotFound(5, "Recibido");
        
        alreadySetup = true;
    }


	@Transactional
    public Role createRoleIfNotFound(final String name) {
        Role role = rolRepository.findByNombre(name);
        if (role == null) {
            role = new Role(name);
        }
        role = rolRepository.save(role);
     
        return role;
    }

    @Transactional
    public Usuario createUserIfNotFound(final String email, final String firstName, final String lastName, final String password, final Collection<Role> roles) {
        Usuario user = usarioRepository.findByEmail(email);
        if (user == null) {
            user = new Usuario();
            user.setNombre(firstName);
            user.setApellidos(lastName);
            user.setPassword(passwordEncoder.encode(password));
            user.setEmail(email);
            user.setEnabled(true);
        }
        user.setRoles(roles);
        return usarioRepository.save(user);
    }

	@Transactional
	public Estado createEstadoIfNotFound(final Integer id, final String nombre) {
		Estado estado = estadoRepository.findByNombre(nombre);
		if (estado == null) {
			estado = new Estado();
			estado.setIdEstado(id);
			estado.setNombre(nombre);
		}
		return estadoRepository.save(estado);
	}
}

