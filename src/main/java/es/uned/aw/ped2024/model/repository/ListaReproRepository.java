package es.uned.aw.ped2024.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uned.aw.ped2024.model.entities.ListaRepro;
import es.uned.aw.ped2024.model.entities.ListaReproPK;

public interface ListaReproRepository extends JpaRepository<ListaRepro, ListaReproPK> {
	
}
