package es.uned.aw.ped2025.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import es.uned.aw.ped2024.controller.dto.CastingDTO;
import es.uned.aw.ped2024.model.entities.Actor;
import es.uned.aw.ped2024.model.service.ActorService;

/**
 *   Controlador de la entidad Actor
 */
@Controller
@RequestMapping("/admin/actor")
public class ArtistaController {

	@Autowired
	private ActorService servicio;

	@ModelAttribute("actor")
	public CastingDTO nuevoActor() {
		return new CastingDTO();
	}
	@GetMapping
	public String actores(Model modelo) {

		return listadoPaginado(1, "id", "asc",modelo);
	}
	@GetMapping("/page/{pagNum}")
	public String listadoPaginado(@PathVariable (value = "pagNum") int pagNum, 
										@RequestParam("sortField") String sortField, 
										@RequestParam("sortDirection") String sortDirection, 
										Model modelo) {
		Page<Actor> actores = servicio.findAllPaginado(pagNum, 5, sortField, sortDirection);

		modelo.addAttribute("actores", listActor2DTO(actores.getContent()));
		modelo.addAttribute("totalItems", actores.getTotalElements());
		modelo.addAttribute("totalPaginas", actores.getTotalPages());
		modelo.addAttribute("currentPag", pagNum);
		modelo.addAttribute("sortField", sortField);
		modelo.addAttribute("sortDirection", sortDirection);
		modelo.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
		modelo.addAttribute("pageUrlPrefix", "/admin/actor");

		return "actor";
	}
	@PostMapping
	public String updateArtista(@ModelAttribute("actor") CastingDTO castingDTO) {
		servicio.save(castingDTO);
		return "redirect:/admin/actor";
	}
	@GetMapping("/new")
	public String newActor() {
		return "actor_det";
		
	}
	@GetMapping("/{id}")
	public String getActor(Model modelo, @PathVariable("id") Long id) {
		modelo.addAttribute("actor", servicio.getActor(id));
		return "actor_det";
	}
	@GetMapping("/delete/{id}")
	public String deleteActor(Model modelo, @PathVariable("id") Long id) {
		servicio.deleteActor(id);
		return "actor";
	}
	private List<CastingDTO> listActor2DTO(List<Actor> lista){
		return lista.stream().map(CastingDTO::new).collect(Collectors.toList());	}
}
