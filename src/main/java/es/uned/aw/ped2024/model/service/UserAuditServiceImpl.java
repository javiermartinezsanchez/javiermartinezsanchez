package es.uned.aw.ped2024.model.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import es.uned.aw.ped2024.model.entities.UserAudit;
import es.uned.aw.ped2024.model.repository.UserAuditRepository;
@Service
public class UserAuditServiceImpl implements UserAuditService {

	@Autowired
	UserAuditRepository repository;
	
	@Override
	public void save(String nombreUsuario, String mensaje) {
		repository.save(new UserAudit(nombreUsuario, mensaje, LocalDateTime.now()));
	}

	@Override
	public Page<UserAudit> findAllPaginado(int pagNum, int pagSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? 
				Sort.by(sortField).ascending() : 
				Sort.by(sortField).descending();
	    Pageable pagina = PageRequest.of(pagNum - 1 , pagSize, sort);
	    return this.repository.findAll(pagina);

	}

}
