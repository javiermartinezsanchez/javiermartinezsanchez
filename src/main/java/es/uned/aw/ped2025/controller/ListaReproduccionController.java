package es.uned.aw.ped2025.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.uned.aw.ped2024.model.entities.ListaRepro;
import es.uned.aw.ped2024.model.service.ListaReproService;

@Controller
public class ListaReproduccionController {

	@Autowired
	ListaReproService listaReproService;
	
	@RequestMapping("/listarepro")
	public String listListaRepro(final Model model) {
		//model.addAttribute("users", activeUserStore.getUsers());
		return "listarepro";
	}

	@GetMapping("/listarepro/page/{pagNum}")
	public String listadoPaginado(@PathVariable (value = "pagNum") int pagNum, 
										@RequestParam("sortField") String sortField, 
										@RequestParam("sortDirection") String sortDirection, 
										Model modelo) {
		Page<ListaRepro> contents = listaReproService.findAllPaginado(pagNum, 5, sortField, sortDirection);

		modelo.addAttribute("contenidos", contents.getContent());
		modelo.addAttribute("totalItems", contents.getTotalElements());
		modelo.addAttribute("totalPaginas", contents.getTotalPages());
		modelo.addAttribute("currentPag", pagNum);
		modelo.addAttribute("sortField", sortField);
		modelo.addAttribute("sortDirection", sortDirection);
		modelo.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
		modelo.addAttribute("pageUrlPrefix", "/admin/usuario");

		return "listarepro";
	}

}
