package es.uned.aw.ped2024.model.service;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import es.uned.aw.ped2024.controller.dto.GeneroDTO;
import es.uned.aw.ped2024.model.entities.Actor;
import es.uned.aw.ped2024.model.entities.Alergeno;
import es.uned.aw.ped2024.model.repository.GeneroRepository;

@Service
public class GeneroServiceImpl implements GeneroService {

	@Autowired
	private GeneroRepository repositorio;

	@Override
	public GeneroDTO save(GeneroDTO generodto) {
		Alergeno genero = (generodto.getId() != null ? repositorio.findById(generodto.getId()).get() : new Alergeno());
		genero.setNombre(generodto.getNombre());
		genero = repositorio.save(genero);
		generodto.setId(genero.getId());
		return generodto;
	}

	@Override
	public List<Alergeno> listarGenero() {
		return repositorio.findAll();
	}
	@Override
	public Page<Alergeno> findAllPaginado(int pagNum, int pagSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? 
				Sort.by(sortField).ascending() : 
				Sort.by(sortField).descending();
	    Pageable pagina = PageRequest.of(pagNum - 1 , pagSize, sort);
	    return this.repositorio.findAll(pagina);
	}
	@Override
	public GeneroDTO getGenero(UUID id) {
		Alergeno genero = repositorio.findById(id).get();
		return (new GeneroDTO(genero.getId(), genero.getNombre()));
	}

	@Override
	public void delete(UUID id) {
		repositorio.deleteById(id);
	}
	
}
