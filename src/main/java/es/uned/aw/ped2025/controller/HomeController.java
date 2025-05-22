package es.uned.aw.ped2025.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.uned.aw.ped2025.model.service.MenuService;

/**
 * Controlador principal de inicio.
 * 
 * De acuerdo a la política de Acceso definida se generan las vistas de cada
 * Rol.
 * 
 * @param modelo
 * @return
 */
@Controller
public class HomeController {
	
	@Autowired 
	private MenuService menuService;
	
	@GetMapping({"/","/home"})
	public String handleAnonimousHome(Model modelo) {
		modelo.addAttribute("listaopciones", menuService.listContenido());
		return "home";
	}

	@GetMapping("/admin/adminHome")
	public String handleAdminHome(Model modelo) {
		//modelo.addAttribute("usuarios", servicio.listarUsuarios());
		return "adminHome";
	}

}
