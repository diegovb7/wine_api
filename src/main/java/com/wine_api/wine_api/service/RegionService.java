package com.wine_api.wine_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wine_api.wine_api.repository.RegionRepository;
import com.wine_api.wine_api.wines.Region;

@Service
public class RegionService {

	@Autowired
	private RegionRepository regionRepository;
	
	public List<Region> getAll(){
		return regionRepository.findAll();
	}
	
	public Region getRegionById(Integer id) {
		return regionRepository.findById(id).orElse(null);
	}
	
	public Region createRegion(Region region){
        return regionRepository.save(region);
    }
	
	public void deleteRegion(Integer id) {
		regionRepository.deleteById(id);
	}
	
	public Region updateRegion(Region region){
        return regionRepository.save(region);
    }
}
