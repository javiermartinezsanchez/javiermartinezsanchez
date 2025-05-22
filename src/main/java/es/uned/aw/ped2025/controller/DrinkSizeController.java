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

import es.uned.aw.ped2025.controller.dto.DrinkSizeDTO;
import es.uned.aw.ped2025.model.service.DrinkSizeService;

/**
 *   Controlador de la entidad Actor
 */
@Controller
@RequestMapping("/admin/drinksize")
public class DrinkSizeController {

	@Autowired
	private DrinkSizeService servicio;

	@ModelAttribute("drinkSize")
	public DrinkSizeDTO nuevo() {
		return new DrinkSizeDTO();
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
		Page<DrinkSizeDTO> listado = servicio.findAllPaginado(pagNum, 5, sortField, sortDirection);
		modelo.addAttribute("listado", listado.getContent());
		modelo.addAttribute("totalItems", listado.getTotalElements());
		modelo.addAttribute("totalPaginas", listado.getTotalPages());
		modelo.addAttribute("currentPag", pagNum);
		modelo.addAttribute("sortField", sortField);
		modelo.addAttribute("sortDirection", sortDirection);
		modelo.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
		modelo.addAttribute("pageUrlPrefix", "/admin/drinksize");

		return "actor";
	}
	@PostMapping
	public String update(@ModelAttribute("actor") DrinkSizeDTO drinkSizeDTO) {
		servicio.save(drinkSizeDTO);
		return "redirect:/admin/drinksize";
	}
	@GetMapping("/new")
	public String newDS() {
		return "drinksize_det";
		
	}
	@GetMapping("/{id}")
	public String get(Model modelo, @PathVariable("id") Long id) {
		modelo.addAttribute("drinkSize", servicio.getDrinkSize(id));
		return "drinksize_det";
	} 
	@GetMapping("/delete/{id}")
	public String deleteDrinkSize(Model modelo, @PathVariable("id") Long id) {
		servicio.delete(id);
		return "drinkSize";
	}
	//private List<DrinkSizeDTO> listDrinkSize2DTO(List<DrinkSize> lista){
	//	return lista.stream().map(DrinkSizeDTO::new).collect(Collectors.toList());	}
}
