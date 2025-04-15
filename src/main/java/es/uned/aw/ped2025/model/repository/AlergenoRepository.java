package es.uned.aw.ped2025.model.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uned.aw.ped2025.model.entities.Alergeno;

public interface AlergenoRepository extends JpaRepository<Alergeno, UUID>{
	Alergeno findByNombre(String name);
}
