package es.uned.aw.ped2024.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uned.aw.ped2024.model.entities.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
	Artista findByNombre(String name);
	
}

