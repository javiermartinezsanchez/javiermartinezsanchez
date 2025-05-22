package es.uned.aw.ped2025.model.service;

import org.springframework.data.domain.Page;

import es.uned.aw.ped2025.controller.dto.DrinkSizeDTO;

public interface DrinkSizeService {
	
	DrinkSizeDTO getDrinkSize(Long id);
	
	Page<DrinkSizeDTO> findAllPaginado(Integer pagNum, Integer recCount, String sortField, String sortDirection);
	
	DrinkSizeDTO save(DrinkSizeDTO drinkSize);
	
	void delete(Long id);
}
