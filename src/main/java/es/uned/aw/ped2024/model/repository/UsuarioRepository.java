package es.uned.aw.ped2024.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uned.aw.ped2024.model.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String email);
	
	@Override
    void delete(Usuario usuario);
}
