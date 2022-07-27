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
	
	public List<Wine> getAll(){
		return wineRepository.findAll();
	}
	
	public Wine getWineById(Integer id) {
		return wineRepository.findById(id).orElse(null);
	}
	
	public Wine createWine(Wine wine){
        return wineRepository.save(wine);
    }
	
	public void deleteWine(Integer id) {
		wineRepository.deleteById(id);
	}
	
	public Wine updateWine(Wine wine){
        return wineRepository.save(wine);
    }
	
	public List<Wine> findWinesByBestRating(){
		return wineRepository.findWinesByBestRating();
	}
	
	public List<Wine> findSomeWinesByBestRating(int numItems){
		return wineRepository.findWinesByBestRating().subList(0, numItems);
	}

	public List<Wine> findWinesByHighestPrice(){
		return wineRepository.findWinesByHighestPrice();
	}
	
	public List<Wine> findSomeWinesByHighestPrice(int numItems){
		return wineRepository.findWinesByHighestPrice().subList(0, numItems);
	}
	
	public List<Wine> findWinesByRatingPrice(){
		return wineRepository.findWinesByRatingPrice();
	}
	
	public List<Wine> findSomeWinesByRatingPrice(int numItems){
		return wineRepository.findWinesByRatingPrice().subList(0, numItems);
	}

	public List<String> findSomeBestYears(int numItems){
		return wineRepository.findBestYears().subList(0, numItems);
	}

	public List<String> findBestYears(){
		return wineRepository.findBestYears();
	}

	public List<Wine> findByYear(String year){
		return wineRepository.findByYear(year);
	}
}
