package es.uned.aw.ped2024.model.service;

import org.springframework.data.domain.Page;

import es.uned.aw.ped2024.model.entities.ListaRepro;

public interface ListaReproService {

	Page<ListaRepro> findAllPaginado(int pagNum, int i, String sortField, String sortDirection);

	ListaRepro add(Long socioId, Long contenidoId);
}
