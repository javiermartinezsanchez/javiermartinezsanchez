package es.uned.aw.ped2025.model.service;

import org.springframework.data.domain.Page;

import es.uned.aw.ped2025.controller.dto.PedidoDTO;

public interface PedidoService {

	Page<PedidoDTO> findAllPaginado(int pagNum, int i, String sortField, String sortDirection);

}
