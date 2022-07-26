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
	
}
