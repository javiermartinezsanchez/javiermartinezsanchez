package es.uned.aw.ped2024.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import es.uned.aw.ped2024.model.entities.Contenido;
import es.uned.aw.ped2024.model.repository.ContenidoRepository;
@Service
public class ContenidoServiceImpl implements ContenidoService {

	@Autowired
	private ContenidoRepository contenidoRepository;
	
	@Override
	public Contenido save(Contenido contenido) {
		
		return contenidoRepository.save(contenido);
	}

	@Override
	public List<Contenido> listContenido() {
		return contenidoRepository.findAll();
	}

	@Override
	public Contenido getContenido(Long id) {
		return contenidoRepository.getReferenceById(id);
	}

	@Override
	public Page<Contenido> findAllPaginado(int pagNum, int pagSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? 
				Sort.by(sortField).ascending() : 
				Sort.by(sortField).descending();
	    Pageable pagina = PageRequest.of(pagNum - 1 , pagSize, sort);
	    return this.contenidoRepository.findAll(pagina);

	}

	@Override
	public void deleteContenido(Long id) {
		contenidoRepository.deleteById(id);
	}

	@Override
	public Page<Contenido> findNovedadesPaginado(int pagNum, int pagSize) {
		return findAllPaginado(pagNum, pagSize, "fechaEstreno", "desc");
	}

}
