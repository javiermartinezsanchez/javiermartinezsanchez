package es.uned.aw.ped2024.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import es.uned.aw.ped2024.model.entities.PlanSubscripcion;
import es.uned.aw.ped2024.model.repository.PlanSubscripcionRepository;
@Service
public class PlanSubscripcionServiceImpl implements PlanSubscripcionService {

	@Autowired
	private PlanSubscripcionRepository psRepo;
	@Override
	public PlanSubscripcion save(PlanSubscripcion ps) {
		return psRepo.save(ps);
	}

	@Override
	public List<PlanSubscripcion> listPlanSubscripcion() {
		return psRepo.findAll();
	}

	@Override
	public List<PlanSubscripcion> listPlanSubscripcionActivos() {
		return psRepo.findByValid(true);
	}

	@Override
	public PlanSubscripcion get(Long id) {
		return psRepo.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		psRepo.delete(psRepo.findById(id).get());
	}

	@Override
	public Page<PlanSubscripcion> findAllPaginado(int pagNum, int pagSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? 
				Sort.by(sortField).ascending() : 
				Sort.by(sortField).descending();
	    Pageable pagina = PageRequest.of(pagNum - 1 , pagSize, sort);
	    return psRepo.findAll(pagina);

	}

}
