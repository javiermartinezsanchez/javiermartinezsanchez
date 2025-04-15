package es.uned.aw.ped2025.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.uned.aw.ped2024.model.entities.Actor;
import es.uned.aw.ped2024.model.entities.Role;
import es.uned.aw.ped2024.model.entities.Usuario;
import es.uned.aw.ped2024.model.service.RoleService;
import es.uned.aw.ped2024.model.service.UsuarioService;
import es.uned.aw.ped2024.config.ActiveUserStore;
import es.uned.aw.ped2024.controller.dto.CastingDTO;

@Controller
public class AdminUserController {

	@Autowired
	ActiveUserStore activeUserStore;
	
	@Autowired
	private UsuarioService userService;
	@Autowired
	private RoleService roleService;

	@ModelAttribute("usuario")
	public Usuario nuevoUsuario() {
		return new Usuario();
	}

	@RequestMapping("/admin/usuario/new")
	public String newUser(final Model model) {
		model.addAttribute("roles", roleService.listAll());
		return "user_det";
	}
	@RequestMapping("/admin/userslogged")
	public String listLoggedUsers(final Model model) {
		model.addAttribute("users", activeUserStore.getUsers());
		return "listuserconected";
	}

	@RequestMapping("/admin/usuario")
	public String listUsers(final Model model) {
		return listadoPaginado(1,"id","asc",model);
		//model.addAttribute("users", userService.listUser());
		//return "users";
	}
	@GetMapping("/admin/usuario/{id}")
	public String getUsuario(Model modelo, @PathVariable("id") Long id) {
		modelo.addAttribute("usuario", userService.getUserByID(id));
		modelo.addAttribute("roles", roleService.listAll());
		return "user_det";
	}
	@PostMapping("/admin/usuario")
	public String saveUsuario(@ModelAttribute("usuario") Usuario user, @RequestParam("role") List<Long> roles) {
        System.out.println(roles);
		userService.saveUsuario(user, roles);
		return "redirect:/admin/usuario";
	}
	@GetMapping("/admin/usuario/page/{pagNum}")
	public String listadoPaginado(@PathVariable (value = "pagNum") int pagNum, 
										@RequestParam("sortField") String sortField, 
										@RequestParam("sortDirection") String sortDirection, 
										Model modelo) {
		Page<Usuario> users = userService.findAllPaginado(pagNum, 5, sortField, sortDirection);

		modelo.addAttribute("users", users.getContent());
		modelo.addAttribute("totalItems", users.getTotalElements());
		modelo.addAttribute("totalPaginas", users.getTotalPages());
		modelo.addAttribute("currentPag", pagNum);
		modelo.addAttribute("sortField", sortField);
		modelo.addAttribute("sortDirection", sortDirection);
		modelo.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
		modelo.addAttribute("pageUrlPrefix", "/admin/usuario");

		return "users";
	}

}
