package es.uned.aw.ped2024.model.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import es.uned.aw.ped2024.model.entities.ListaRepro;
import es.uned.aw.ped2024.model.repository.ListaReproRepository;

@Service
public class ListaReproServiceImpl implements ListaReproService {

	@Autowired
	private ListaReproRepository listaRepro;
	@Override
	public Page<ListaRepro> findAllPaginado(int pagNum, int i, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListaRepro add(Long socioId, Long contenidoId) {
		ListaRepro newListaRepro = new ListaRepro();
		
		newListaRepro.getListaReproPK().setUsuarioId(socioId);
		newListaRepro.getListaReproPK().setContenidoId(contenidoId);
		newListaRepro.setFechaAdded(LocalDateTime.now());
		
		return listaRepro.save(newListaRepro);
	}

}
