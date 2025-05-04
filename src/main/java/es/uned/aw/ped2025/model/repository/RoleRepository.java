package es.uned.aw.ped2025.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uned.aw.ped2025.model.entities.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByNombre(String nombre);
}
