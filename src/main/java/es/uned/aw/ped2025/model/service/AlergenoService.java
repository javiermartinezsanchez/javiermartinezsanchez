package es.uned.aw.ped2025.model.service;

import java.util.List;

import org.springframework.data.domain.Page;

import es.uned.aw.ped2025.controller.dto.AlergenoDTO;
import es.uned.aw.ped2025.model.entities.Alergeno;

public interface AlergenoService {

	public Alergeno save(AlergenoDTO alergeno);
	
	public List<Alergeno> list();
	
	public AlergenoDTO get();
	
	public Page<Alergeno> findAll(int pagNnum, int pageSize, String sortField, String sortDirection);
}
