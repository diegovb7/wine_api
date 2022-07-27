package com.wine_api.wine_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wine_api.wine_api.repository.WineRepository;
import com.wine_api.wine_api.wines.Wine;

@Service
public class WineService {

	@Autowired
	private WineRepository wineRepository;

	public List<Wine> getAll() {
		return wineRepository.findAll();
	}

	public Wine getWineById(Integer id) {
		return wineRepository.findById(id).orElse(null);
	}

	public Wine createWine(Wine wine) {
		return wineRepository.save(wine);
	}

	public void deleteWine(Integer id) {
		wineRepository.deleteById(id);
	}

	public Wine updateWine(Wine wine) {
		return wineRepository.save(wine);
	}

	public List<Wine> findWinesByBestRating(Integer numItems) {

		return numItems == null ? wineRepository.findWinesByBestRating()
				: wineRepository.findWinesByBestRating().subList(0, numItems);
	}

	public List<Wine> findWinesByHighestPrice(Integer numItems) {

		return numItems == null ? wineRepository.findWinesByHighestPrice()
				: wineRepository.findWinesByHighestPrice().subList(0, numItems);
	}

	public List<Wine> findWinesByRatingPrice(Integer numItems) {

		return numItems == null ? wineRepository.findWinesByRatingPrice()
				: wineRepository.findWinesByRatingPrice().subList(0, numItems);
	}

	public List<String> findBestYears(Integer numItems) {

		return numItems == null ? wineRepository.findBestYears() : wineRepository.findBestYears().subList(0, numItems);
	}

	public List<Wine> findByYear(String year) {
		return wineRepository.findByYear(year);
	}
}
