package es.uned.aw.ped2024.model.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import es.uned.aw.ped2024.controller.dto.CastingDTO;
import es.uned.aw.ped2024.model.entities.Artista;
import es.uned.aw.ped2024.model.repository.ArtistaRepository;

@Service
public class ArtistaServiceImpl implements ArtistaService {

	@Autowired
	private ArtistaRepository repositorio;

	@Override
	public Artista save(CastingDTO castingDTO) {
		//if () {
		Artista artista = (castingDTO.getId() != null ? repositorio.findById(castingDTO.getId()).get() : new Artista());
		artista.setNombre(castingDTO.getNombre());
		artista.setNacionalidad(castingDTO.getNacionalidad());
		artista.setFechaNacimiento(castingDTO.getFechaNacimiento());
		return repositorio.save(artista);
	}

	@Override
	public List<Artista> listArtista() {
		
		return repositorio.findAll();
	}
	@Override
	public CastingDTO getArtista(Long id) {
		Artista artista = repositorio.findById(id).get();
		return new CastingDTO(artista.getId(), artista.getNombre(), artista.getNacionalidad(), artista.getFechaNacimiento());
		
	}

	@Override
	public Page<Artista> findAllPaginado(int pagNum, int pagSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? 
				Sort.by(sortField).ascending() : 
				Sort.by(sortField).descending();
	    Pageable pagina = PageRequest.of(pagNum - 1 , pagSize, sort);
	    return this.repositorio.findAll(pagina);
	    
	    //.stream().map(CastingDTO::new).toList();
    //return null;
	}
}
