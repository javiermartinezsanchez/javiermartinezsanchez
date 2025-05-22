package es.uned.aw.ped2025.model.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import es.uned.aw.ped2025.controller.dto.PedidoDTO;
@Service
public class PedidoServiceImpl implements PedidoService {

	@Override
	public Page<PedidoDTO> findAllPaginado(int pagNum, int i, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
		return null;
	}

}
