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

import com.wine_api.wine_api.service.WineService;
import com.wine_api.wine_api.wines.Wine;

@RestController
@RequestMapping("/api/wine")
public class WineController {
	
	@Autowired
	private WineService wineService;

	@GetMapping()
	public ResponseEntity<List<Wine>> getWines(){
		
		List<Wine> wines = wineService.getAll();
		
		if(wines.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity<>(wines, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Wine> createWine(@RequestBody Wine wine) {
		return new ResponseEntity<>(wineService.createWine(wine), HttpStatus.OK);
	}
	
	@PutMapping()
	public ResponseEntity<Wine> updateWine(@RequestBody Wine wine) {
		return new ResponseEntity<>(wineService.updateWine(wine), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteWine(@PathVariable Integer id) {
		wineService.deleteWine(id);
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Wine> getWine(@PathVariable Integer id){
		
		Wine wine = wineService.getWineById(id);
		
		if(wine == null) {
			return ResponseEntity.notFound().build();
		}
		
		return new ResponseEntity<>(wine, HttpStatus.OK);
	}

	
}
