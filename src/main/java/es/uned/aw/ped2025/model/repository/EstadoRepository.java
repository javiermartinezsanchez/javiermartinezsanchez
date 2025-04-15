package es.uned.aw.ped2025.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uned.aw.ped2025.model.entities.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	Estado findByNombre(String name);
}

