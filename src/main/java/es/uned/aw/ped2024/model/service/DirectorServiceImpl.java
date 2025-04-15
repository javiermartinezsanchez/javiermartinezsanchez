package es.uned.aw.ped2024.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import es.uned.aw.ped2024.controller.dto.CastingDTO;
import es.uned.aw.ped2024.model.entities.Director;
import es.uned.aw.ped2024.model.repository.DirectorRepository;

@Service
public class DirectorServiceImpl implements DirectorService {

	@Autowired
	private DirectorRepository repositorio;
	@Override
	public Director guardar(CastingDTO directorDTO) {
		Director director = repositorio.findById(directorDTO.getId()).orElse(new Director());
		director.setNombre(directorDTO.getNombre());
		director.setNacionalidad(directorDTO.getNacionalidad());
		director.setFechaNacimiento(directorDTO.getFechaNacimiento());
		return repositorio.save(director);
	}

	@Override
	public List<Director> listarDirector() {
		
		return repositorio.findAll();
	}
	@Override
	public Page<Director> findAllPaginado(int pagNum, int pagSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? 
				Sort.by(sortField).ascending() : 
				Sort.by(sortField).descending();
	    Pageable pagina = PageRequest.of(pagNum - 1 , pagSize, sort);
	    return this.repositorio.findAll(pagina);
	}
	@Override
	public CastingDTO getDirector(Long id) {
		Director director= repositorio.findById(id).get();
		return new CastingDTO(director.getId(), director.getNombre(), director.getNacionalidad(), director.getFechaNacimiento());

	}

}
