package es.uned.aw.ped2025.model.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import es.uned.aw.ped2025.controller.dto.DrinkSizeDTO;
@Service
public class DrinkSizeServiceImpl implements DrinkSizeService {

	@Override
	public DrinkSizeDTO getDrinkSize(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<DrinkSizeDTO> findAllPaginado(Integer pagNum, Integer recCount, String sortField,
			String sortDirection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DrinkSizeDTO save(DrinkSizeDTO drinkSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
