package es.uned.aw.ped2024.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uned.aw.ped2024.model.entities.PlanSubscripcion;

public interface PlanSubscripcionRepository extends JpaRepository<PlanSubscripcion, Long> {
	PlanSubscripcion findByNombre(String name);
	List<PlanSubscripcion> findByValid(Boolean valido);
}
