package es.uned.aw.ped2024.model.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import es.uned.aw.ped2024.controller.dto.CastingDTO;
import es.uned.aw.ped2024.model.entities.Actor;
import es.uned.aw.ped2024.model.repository.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorRepository repositorio;

	@Override
	public Actor save(CastingDTO castingDTO) {
		Actor actor = (castingDTO.getId() != null ? repositorio.findById(castingDTO.getId()).get() : new Actor());
		actor.setNombre(castingDTO.getNombre());
		actor.setNacionalidad(castingDTO.getNacionalidad());
		actor.setFechaNacimiento(castingDTO.getFechaNacimiento());
		return repositorio.save(actor);
	}

	@Override
	public List<Actor> listActor() {
		
		return repositorio.findAll();
	}
	@Override
	public CastingDTO getActor(Long id) {
		Actor actor = repositorio.findById(id).get();
		return new CastingDTO(actor.getId(), actor.getNombre(), actor.getNacionalidad(), actor.getFechaNacimiento());
		
	}

	@Override
	public Page<Actor> findAllPaginado(int pagNum, int pagSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? 
				Sort.by(sortField).ascending() : 
				Sort.by(sortField).descending();
	    Pageable pagina = PageRequest.of(pagNum - 1 , pagSize, sort);
	    return this.repositorio.findAll(pagina);
	    
	    //.stream().map(CastingDTO::new).toList();
    //return null;
	}
	public void deleteActor(Long id) {
		this.repositorio.delete(repositorio.findById(id).get());
	}
}
