package com.wine_api.wine_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wine_api.wine_api.service.TypeService;
import com.wine_api.wine_api.service.WineService;
import com.wine_api.wine_api.wines.Type;

@RestController
@RequestMapping("/api/")
public class TypeController {

	@Autowired
	private TypeService typeService;

	@GetMapping("/type")
	public ResponseEntity<List<Type>> getTypes(){
		
		List<Type> types = typeService.getAll();
		
		if(types.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity<>(types, HttpStatus.OK);
	}
	
	@GetMapping("/type/{id}")
	public ResponseEntity<Type> getWine(@PathVariable Integer id){
		
		Type type = typeService.getTypeById(id);
		
		if(type == null) {
			return ResponseEntity.notFound().build();
		}
		
		return new ResponseEntity<>(type, HttpStatus.OK);
	}
}
