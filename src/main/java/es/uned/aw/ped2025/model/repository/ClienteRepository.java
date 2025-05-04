package es.uned.aw.ped2024.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uned.aw.ped2025.model.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
