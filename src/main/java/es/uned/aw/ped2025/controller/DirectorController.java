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
import es.uned.aw.ped2024.model.entities.Director;
import es.uned.aw.ped2024.model.service.DirectorService;
/**
 *   Controlador de la entidad Director
 */
@Controller
@RequestMapping("/admin/director")
public class DirectorController {

	@Autowired
	private DirectorService servicio;
	
	@ModelAttribute("director")
	public CastingDTO nuevoDirector() {
		return new CastingDTO();
	}
	
	@GetMapping
	public String listDirector(Model modelo) {
		return listadoPaginado(1, "id", "asc",modelo);
	}
	@GetMapping("/page/{pagNum}")
	public String listadoPaginado(@PathVariable (value = "pagNum") int pagNum, 
										@RequestParam("sortField") String sortField, 
										@RequestParam("sortDirection") String sortDirection, 
										Model modelo) {
		Page<Director> directores = servicio.findAllPaginado(pagNum, 5, sortField, sortDirection);

		modelo.addAttribute("directores", list2DTO(directores.getContent()));
		modelo.addAttribute("totalItems", directores.getTotalElements());
		modelo.addAttribute("totalPaginas", directores.getTotalPages());
		modelo.addAttribute("currentPag", pagNum);
		modelo.addAttribute("sortField", sortField);
		modelo.addAttribute("sortDirection", sortDirection);
		modelo.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
		modelo.addAttribute("pageUrlPrefix", "/admin/director");
		return "director";
	}

	@PostMapping
	public String addDirector(@ModelAttribute("director") CastingDTO castingDTO) {
		servicio.guardar(castingDTO);
		return "redirect:/admin/director?exito";
	}
	@GetMapping("/new")
	public String newDirector() {
		return "director_det";
		
	}
	@GetMapping("/{id}")
	public String getDirectorDetail(Model modelo, @PathVariable("id") Long id) {
		modelo.addAttribute("director", servicio.getDirector(id));
		return "director_det";
	}
	private List<CastingDTO> list2DTO(List<Director> lista){
		return lista.stream().map(CastingDTO::new).collect(Collectors.toList());	}

}
