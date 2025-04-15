package es.uned.aw.ped2025.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.uned.aw.ped2024.controller.dto.CastingDTO;
import es.uned.aw.ped2024.model.entities.Contenido;
import es.uned.aw.ped2024.model.service.ActorService;
import es.uned.aw.ped2024.model.service.ContenidoService;
import es.uned.aw.ped2024.model.service.DirectorService;
import es.uned.aw.ped2024.model.service.GeneroService;

/**
 * Controlador de gestión de contenidos.
 * 
 * Nos devolverá el listado de "novedades"
 * Rol.
 * 
 * @param modelo
 * @return
 */

@Controller
public class ContenidoController {

	@Autowired
	private ContenidoService contentService;
	
	@Autowired
	private GeneroService generoService;
	
	@Autowired
	private ActorService actorService;
	
	@Autowired
	private DirectorService directorService;
	
	@ModelAttribute("contenido")
	public Contenido nuevoContenido() {
		return new Contenido();
	}
	
	@GetMapping("/gestor/contenido")
	public String contenidos(Model modelo) {
	return listadoPaginado(1, "id", "asc",modelo);
	}
	
	@GetMapping("/gestor/contenido/page/{pagNum}")
	public String listadoPaginado(@PathVariable (value = "pagNum") int pagNum, 
										@RequestParam("sortField") String sortField, 
										@RequestParam("sortDirection") String sortDirection, 
										Model modelo) {
		Page<Contenido> contenidos = contentService.findAllPaginado(pagNum, 5, sortField, sortDirection);

		modelo.addAttribute("contenidos", contenidos.getContent());
		modelo.addAttribute("totalItems", contenidos.getTotalElements());
		modelo.addAttribute("totalPaginas", contenidos.getTotalPages());
		modelo.addAttribute("currentPag", pagNum);
		modelo.addAttribute("sortField", sortField);
		modelo.addAttribute("sortDirection", sortDirection);
		modelo.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
		modelo.addAttribute("pageUrlPrefix", "/gestor/contenido");

		return "contenido";
	}
	@GetMapping("/gestor/contenido/new")
	public String newContenido(Model modelo) {
		modelo.addAttribute("generos", generoService.listarGenero());
		modelo.addAttribute("actores", actorService.listActor());
		modelo.addAttribute("directores", directorService.listarDirector());
		return "contenido_det";
	}
	@PostMapping("/gestor/contenido")
	public String updateContent(@ModelAttribute("contenido") Contenido contenido) {
		contentService.save(contenido);
		return "redirect:/gestor/contenido";
	}
	@GetMapping("/contenido/novedades")
	public String listadoNovedades(Model modelo) {
		return listadoNovedadesPaginado(1,modelo);
	}
	@GetMapping("/contenido/novedades/page/{pagNum}")
	public String listadoNovedadesPaginado(@PathVariable (value = "pagNum") int pagNum, 
										Model modelo) {
		Page<Contenido> contenidos = contentService.findNovedadesPaginado(pagNum, 5);

		modelo.addAttribute("contenidos", contenidos.getContent());
		
		return "";
	}
}
