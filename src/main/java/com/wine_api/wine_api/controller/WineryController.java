package com.wine_api.wine_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wine_api.wine_api.service.WineService;
import com.wine_api.wine_api.service.WineryService;
import com.wine_api.wine_api.wines.Wine;
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
	
	@GetMapping("/winery/{id}")
	public ResponseEntity<Winery> getWine(@PathVariable Integer id){
		
		Winery winery = wineryService.getWineById(id);
		
		if(winery == null) {
			return ResponseEntity.notFound().build();
		}
		
		return new ResponseEntity<>(winery, HttpStatus.OK);
	}

}
