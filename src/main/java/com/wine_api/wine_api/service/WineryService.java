package com.wine_api.wine_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wine_api.wine_api.repository.WineryRepository;
import com.wine_api.wine_api.wines.Winery;

@Service
public class WineryService {
	
	@Autowired
	private WineryRepository wineryRepository;
	
	public List<Winery> getAll(){
		return wineryRepository.findAll();
	}
	
	public Winery getWineryById(Integer id) {
		return wineryRepository.findById(id).orElse(null);
	}
	
	public Winery createWinery(Winery winery){
        return wineryRepository.save(winery);
    }
	
	public void deleteWinery(Integer id) {
		wineryRepository.deleteById(id);
	}
	
	public Winery updateWinery(Winery winery){
        return wineryRepository.save(winery);
    }

}
