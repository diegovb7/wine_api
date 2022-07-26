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

import com.wine_api.wine_api.service.WineryService;
import com.wine_api.wine_api.wines.Winery;

@RestController
@RequestMapping("/api/")
public class WineryController {
	
	@Autowired
	private WineryService wineryService;

	@GetMapping("/winery")
	public ResponseEntity<List<Winery>> getWinerys(){
		
		List<Winery> winerys = wineryService.getAll();
		
		if(winerys.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity<>(winerys, HttpStatus.OK);
	}
	
	@PostMapping("/winery")
	public ResponseEntity<Winery> createWinery(@RequestBody Winery winery) {
		return new ResponseEntity<>(wineryService.createWinery(winery), HttpStatus.OK);
	}
	
	@PutMapping("/winery")
	public ResponseEntity<Winery> updateWinery(@RequestBody Winery winery) {
		return new ResponseEntity<>(wineryService.updateWinery(winery), HttpStatus.OK);
	}
	
	@DeleteMapping("/winery/{id}")
	public void deleteWinery(@PathVariable Integer id) {
		wineryService.deleteWinery(id);
	}	
	
	@GetMapping("/winery/{id}")
	public ResponseEntity<Winery> getWinery(@PathVariable Integer id){
		
		Winery winery = wineryService.getWineryById(id);
		
		if(winery == null) {
			return ResponseEntity.notFound().build();
		}
		
		return new ResponseEntity<>(winery, HttpStatus.OK);
	}

}
