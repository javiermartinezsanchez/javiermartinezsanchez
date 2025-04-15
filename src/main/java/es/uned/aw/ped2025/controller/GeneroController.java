package es.uned.aw.ped2025.controller;

import java.util.UUID;

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

import es.uned.aw.ped2024.controller.dto.GeneroDTO;
import es.uned.aw.ped2024.model.entities.Actor;
import es.uned.aw.ped2024.model.entities.Alergeno;
import es.uned.aw.ped2024.model.service.GeneroService;

@Controller
@RequestMapping("/admin/genero")
public class GeneroController {

	@Autowired
	private GeneroService servicio;
		
	@ModelAttribute("detalle")
	public GeneroDTO nuevoDetalle() {
		return new GeneroDTO();
	}
	@GetMapping()
	public String listaGenero(Model modelo) {
		return listadoPaginado(1, "id", "asc",modelo);
	}
	@GetMapping("/page/{pagNum}")
	public String listadoPaginado(@PathVariable (value = "pagNum") int pagNum, 
										@RequestParam("sortField") String sortField, 
										@RequestParam("sortDirection") String sortDirection, 
										Model modelo) {
		Page<Alergeno> generos = servicio.findAllPaginado(pagNum, 5, sortField, sortDirection);

		modelo.addAttribute("generos", generos.getContent());
		modelo.addAttribute("totalItems", generos.getTotalElements());
		modelo.addAttribute("totalPaginas", generos.getTotalPages());
		modelo.addAttribute("currentPag", pagNum);
		modelo.addAttribute("sortField", sortField);
		modelo.addAttribute("sortDirection", sortDirection);
		modelo.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
		modelo.addAttribute("pageUrlPrefix", "/admin/genero");

		return "genero";
	}

	
	
	@GetMapping("/new")
	public String newGenero() {
		return "genero_det";
		
	}
	@GetMapping("/{id}")
	public String getGeneroDetail(Model modelo, @PathVariable("id") UUID id) {
		modelo.addAttribute("detalle", servicio.getGenero(id));
		return "genero_det";
	}
	@GetMapping("/delete/{id}")
	public String delete(Model modelo, @PathVariable("id") UUID id) {
		servicio.delete(id);
		return "redirect:/admin/genero";
	}
	@PostMapping
	public String save(@ModelAttribute("detalle") GeneroDTO genero) {
		servicio.save(genero);
		return "redirect:/admin/genero";
	}

	
}
