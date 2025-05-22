package es.uned.aw.ped2025.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uned.aw.ped2025.model.entities.DrinkSize;

public interface DrinkSizeRepository extends JpaRepository<DrinkSize, Long> {
	DrinkSize findByNombre(String name);
	
}

