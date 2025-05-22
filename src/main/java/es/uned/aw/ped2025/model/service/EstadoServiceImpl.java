package es.uned.aw.ped2025.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import es.uned.aw.ped2025.controller.dto.EstadoDTO;
import es.uned.aw.ped2025.model.entities.Estado;
@Service
public class EstadoServiceImpl implements EstadoService {

	@Override
	public Estado save(EstadoDTO actorDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EstadoDTO> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstadoDTO get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<EstadoDTO> findAllPaginado(int pagNnum, int pagSize, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEstado(Integer id) {
		// TODO Auto-generated method stub

	}

}
