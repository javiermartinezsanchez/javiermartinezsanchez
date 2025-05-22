package es.uned.aw.ped2025.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.uned.aw.ped2025.controller.dto.PedidoDTO;
import es.uned.aw.ped2025.model.service.PedidoService;
/**
 * Controlador de los pedidos
 * 
 * 
 */
@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	PedidoService pedidoService;
	
	@GetMapping
	public String listaRepro(Model modelo) {
		return listadoPaginado(1, "id", "asc",modelo);
	}
	@PostMapping("/add/{id}")
	public String addListContenido(Model modelo, @PathVariable("id") Long id) {
		return "Añadir a la lista";
	}
	@PostMapping("/delete/{id}")
	public String deleteListContenido(Model modelo, @PathVariable("id") Long id) {
		return "Borrar de la lista";
	}
	
	@GetMapping("/page/{pagNum}")
	public String listadoPaginado(@PathVariable (value = "pagNum") int pagNum, 
										@RequestParam("sortField") String sortField, 
										@RequestParam("sortDirection") String sortDirection, 
										Model modelo) {
		Page<PedidoDTO> pedidos = pedidoService.findAllPaginado(pagNum, 5, sortField, sortDirection);

		modelo.addAttribute("pedidos", pedidos.getContent());
		modelo.addAttribute("totalItems", pedidos.getTotalElements());
		modelo.addAttribute("totalPaginas", pedidos.getTotalPages());
		modelo.addAttribute("currentPag", pagNum);
		modelo.addAttribute("sortField", sortField);
		modelo.addAttribute("sortDirection", sortDirection);
		modelo.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
		modelo.addAttribute("pageUrlPrefix", "/pedido/contenido");

		return "listarepro";
	}

	
}
