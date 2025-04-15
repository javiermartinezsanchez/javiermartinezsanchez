package es.uned.aw.ped2025.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uned.aw.ped2024.controller.dto.UsuarioRegistroDTO;
import es.uned.aw.ped2024.model.entities.Actor;
import es.uned.aw.ped2024.model.entities.Director;
import es.uned.aw.ped2024.model.entities.Alergeno;
import es.uned.aw.ped2024.model.entities.Role;
import es.uned.aw.ped2024.model.service.ActorService;
import es.uned.aw.ped2024.model.service.DirectorService;
import es.uned.aw.ped2024.model.service.GeneroService;
import es.uned.aw.ped2024.model.service.SocioService;
import es.uned.aw.ped2024.model.service.UsuarioService;

@Controller

public class RegistroUsuarioControlador {

	@Autowired
	private SocioService usuarioService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ActorService actorService;
	
	@Autowired
	private DirectorService directorService;
	
	@Autowired
	private GeneroService generoService;
	
	
	@ModelAttribute("usuario")
	public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
		return new UsuarioRegistroDTO();
	}
	@GetMapping("/registro")
	public String mostrarFormularioDeRegistro(Model modelo) {
		modelo.addAttribute("actores", actorService.listActor());
		modelo.addAttribute("directores", directorService.listarDirector());
		modelo.addAttribute("generos", generoService.listarGenero());
		return "registro";
	}
	
	@PostMapping("/registro")
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO,
			@ModelAttribute("generos") List<Alergeno> generos,
			@ModelAttribute("actores") List<Actor> actores,
			@ModelAttribute("directores") List<Director> directores) {
		registroDTO.setPassword(passwordEncoder.encode(registroDTO.getPassword()));
		usuarioService.newSocio(registroDTO, generos, actores, directores);
		return "redirect:/registro?exito";
	}
	
	@GetMapping("/changePassword")
	public String changePassword() {
		return "changePassword";
		
	}
	@PostMapping("/changePassword")
	public ResponseEntity<?> changePassword(
			 @RequestBody ChangePasswordRequest request,
			 Principal actualUser){
		
		usuarioService.changePassword(request, actualUser);
		return ResponseEntity.ok().build();
	}
}
