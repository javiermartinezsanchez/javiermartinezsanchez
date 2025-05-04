package es.uned.aw.ped2024.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uned.aw.ped2025.model.entities.UserAudit;

public interface UserAuditRepository extends JpaRepository<UserAudit, Long> {

}
