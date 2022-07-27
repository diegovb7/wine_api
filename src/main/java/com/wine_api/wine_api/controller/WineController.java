package com.wine_api.wine_api.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wine_api.wine_api.service.WineService;
import com.wine_api.wine_api.wines.Wine;

@RestController
@RequestMapping("/api")
public class WineController {
	
	@Autowired
	private WineService wineService;

	@GetMapping("/wine")
	public ResponseEntity<List<Wine>> getWines(){
		
		List<Wine> wines = wineService.getAll();
		
		if(wines.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity<>(wines, HttpStatus.OK);
	}
	
	@PostMapping("/wine")
	public ResponseEntity<Wine> createWine(@RequestBody Wine wine) {
		return new ResponseEntity<>(wineService.createWine(wine), HttpStatus.OK);
	}
	
	@PutMapping("/wine")
	public ResponseEntity<Wine> updateWine(@RequestBody Wine wine) {
		return new ResponseEntity<>(wineService.updateWine(wine), HttpStatus.OK);
	}
	
	@DeleteMapping("/wine/{id}")
	public void deleteWine(@PathVariable Integer id) {
		wineService.deleteWine(id);
	}	
	
	@GetMapping("/wine/{id}")
	public ResponseEntity<Wine> getWine(@PathVariable Integer id){
		
		Wine wine = wineService.getWineById(id);
		
		if(wine == null) {
			return ResponseEntity.notFound().build();
		}
		
		return new ResponseEntity<>(wine, HttpStatus.OK);
	}

	@GetMapping("/recommend/best")
	public ResponseEntity<List<Wine>> getBestRatedWines(@RequestParam(required = false) Integer top){
		
		if(top == null) {
			return new ResponseEntity<>(wineService.findWinesByBestRating(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(wineService.findSomeWinesByBestRating(top), HttpStatus.OK);
		}
//		List<Wine> wines = wineService.findWinesByBestRating();
//
//		Stream<Wine> w = wines.stream().limit(10);
//
//		return new ResponseEntity<>(w.collect(Collectors.toList()), HttpStatus.OK);
	}
	
	@GetMapping("/expensive")
	public ResponseEntity<List<Wine>> getHighestPricedWines(@RequestParam(required = false) Integer top){
		
		if(top == null) {
			return new ResponseEntity<>(wineService.findWinesByHighestPrice(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(wineService.findSomeWinesByHighestPrice(top), HttpStatus.OK);
		}
	}
	
	@GetMapping("/bang")
	public ResponseEntity<List<Wine>> getWinesByRatingPrice(@RequestParam(required = false) Integer top){
		
		if(top == null) {
			return new ResponseEntity<>(wineService.findWinesByRatingPrice(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(wineService.findSomeWinesByRatingPrice(top), HttpStatus.OK);
		}
	}

	@GetMapping("/vintage")
	public ResponseEntity<Map<String, List<Wine>>> getWinesByBestYears(@RequestParam(required = false) Integer top){

		Map<String, List<Wine>> map = new HashMap<>();

		List<String> years = wineService.findSomeBestYears(top);

		for(String year : years){
			map.put(year, wineService.findByYear(year));
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
		/* 
		if(top == null) {
			return new ResponseEntity<>(wineService.findWinesByRatingPrice(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(wineService.findSomeWinesByRatingPrice(top), HttpStatus.OK);
		}
		*/
	}
}
