package es.uned.aw.ped2025.controller;

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

import es.uned.aw.ped2024.model.entities.PlanSubscripcion;
import es.uned.aw.ped2024.model.service.PlanSubscripcionService;

@Controller
public class PlanSubscripcionController {
	
	
	@Autowired
	PlanSubscripcionService service;
	
	@ModelAttribute("planSubscripcion")
	public PlanSubscripcion nuevoPlan() {
		return new PlanSubscripcion();
	}
	
	@RequestMapping("/admin/planSubscripcion")
	public String listaPlanesSubscripcion(Model modelo) {
		return listadoPaginado(1, "id", "asc",modelo);
	}
	@GetMapping("/admin/planSubscripcion/page/{pagNum}")
	private String listadoPaginado(@PathVariable (value = "pagNum") int pagNum, 
			@RequestParam("sortField") String sortField, 
			@RequestParam("sortDirection") String sortDirection, 
			Model modelo) {
		
			Page<PlanSubscripcion> psList = service.findAllPaginado(pagNum, 10, sortField, sortDirection);

			modelo.addAttribute("plansuscriptions", psList.getContent());
			modelo.addAttribute("totalItems", psList.getTotalElements());
			modelo.addAttribute("totalPaginas", psList.getTotalPages());
			modelo.addAttribute("currentPag", pagNum);
			modelo.addAttribute("sortField", sortField);
			modelo.addAttribute("sortDirection", sortDirection);
			modelo.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
			modelo.addAttribute("pageUrlPrefix", "/admin/planSubscripcion");

			return "planSubscripcion";
		}


	@RequestMapping("/admin/planSubscripcion/new")
	public String newPlanesSubscripcion() {

		return "planSubscripcion_det";
	}
	@PostMapping("/admin/planSubscripcion")
	public String updateArtista(@ModelAttribute("planSubscripcion") PlanSubscripcion ps) {
		service.save(ps);
		return "redirect:/admin/planSubscripcion";
	}
	@GetMapping("/admin/planSubscripcion/{id}")
	public String getPlanDetail(Model modelo, @PathVariable("id") Long id) {
		modelo.addAttribute("planSubscripcion", service.get(id));
		return "planSubscripcion_det";
	}
	@GetMapping("/admin/planSubscripcion/delete/{id}")
	public String planDelete(Model modelo, @PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/admin/planSubscripcion";
	}

}
