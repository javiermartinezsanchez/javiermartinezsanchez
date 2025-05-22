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

import es.uned.aw.ped2025.controller.dto.EstadoDTO;
import es.uned.aw.ped2025.model.service.EstadoService;
/**
 *   Controlador de la entidad Estado
 */
@Controller
@RequestMapping("/admin/estado")
public class EstadoController {

	@Autowired
	private EstadoService servicio;
	
	@ModelAttribute("estado")
	public EstadoDTO newEstado() {
		return new EstadoDTO();
	}
	
	@GetMapping
	public String list(Model modelo) {
		return listadoPaginado(1, "id", "asc",modelo);
	}
	@GetMapping("/page/{pagNum}")
	public String listadoPaginado(@PathVariable (value = "pagNum") int pagNum, 
										@RequestParam("sortField") String sortField, 
										@RequestParam("sortDirection") String sortDirection, 
										Model modelo) {
		Page<EstadoDTO> listado = servicio.findAllPaginado(pagNum, 5, sortField, sortDirection);

		modelo.addAttribute("listado", listado.getContent());
		modelo.addAttribute("totalItems", listado.getTotalElements());
		modelo.addAttribute("totalPaginas", listado.getTotalPages());
		modelo.addAttribute("currentPag", pagNum);
		modelo.addAttribute("sortField", sortField);
		modelo.addAttribute("sortDirection", sortDirection);
		modelo.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
		modelo.addAttribute("pageUrlPrefix", "/admin/estado");
		return "director";
	}

	@PostMapping
	public String addEstado(@ModelAttribute("estado") EstadoDTO estadoDTO) {
		servicio.save(estadoDTO);
		return "redirect:/admin/estado?exito";
	}
	@GetMapping("/new")
	public String addEstado() {
		return "estado_det";
		
	}
	@GetMapping("/{id}")
	public String getEstadoDetail(Model modelo, @PathVariable("id") int id) {
		modelo.addAttribute("estado", servicio.get(id));
		return "estado_det";
	}
	//private List<CastingDTO> list2DTO(List<Director> lista){
	//	return lista.stream().map(CastingDTO::new).collect(Collectors.toList());	}

}
