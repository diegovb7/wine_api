package com.wine_api.wine_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wine_api.wine_api.service.RegionService;
import com.wine_api.wine_api.wines.Region;

@RestController
@RequestMapping("/api/")
public class RegionController {

	@Autowired
	private RegionService regionService;

	@GetMapping("/region")
	public ResponseEntity<List<Region>> getRegions(){
		
		List<Region> regions = regionService.getAll();
		
		if(regions.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity<>(regions, HttpStatus.OK);
	}
	
	@PostMapping("/region")
	public ResponseEntity<Region> createRegion(@RequestBody Region region) {
		return new ResponseEntity<>(regionService.createRegion(region), HttpStatus.OK);
	}
	
	@PutMapping("/region")
	public ResponseEntity<Region> updateRegion(@RequestBody Region region) {
		return new ResponseEntity<>(regionService.updateRegion(region), HttpStatus.OK);
	}
	
	@DeleteMapping("/region/{id}")
	public void deleteRegion(@PathVariable Integer id) {
		regionService.deleteRegion(id);
	}	
	
	@GetMapping("/region/{id}")
	public ResponseEntity<Region> getRegion(@PathVariable Integer id){
		
		Region region = regionService.getRegionById(id);
		
		if(region == null) {
			return ResponseEntity.notFound().build();
		}
		
		return new ResponseEntity<>(region, HttpStatus.OK);
	}
}
