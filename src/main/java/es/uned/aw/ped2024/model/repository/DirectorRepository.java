package es.uned.aw.ped2024.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uned.aw.ped2024.model.entities.Director;

public interface DirectorRepository extends JpaRepository<Director, Long>{
	Director findByNombre(String name);
}
