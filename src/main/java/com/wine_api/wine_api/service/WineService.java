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
	
	public Wine getWineById(Long id) {
		return wineRepository.findById(id).orElse(null);
	}
	
}
