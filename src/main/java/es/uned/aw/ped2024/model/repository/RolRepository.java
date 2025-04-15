package es.uned.aw.ped2024.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uned.aw.ped2024.model.entities.Role;


public interface RolRepository extends JpaRepository<Role, Long> {

    Role findByNombre(String nombre);

    @Override
    void delete(Role role);

}
