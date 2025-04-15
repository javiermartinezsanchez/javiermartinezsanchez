package es.uned.aw.ped2024.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uned.aw.ped2024.model.entities.Contenido;

public interface ContenidoRepository extends JpaRepository<Contenido, Long>{

	Contenido findByTitulo(String titulo);

}
