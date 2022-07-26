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

import com.wine_api.wine_api.service.TypeService;
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
	
	@PostMapping("/type")
	public ResponseEntity<Type> createType(@RequestBody Type type) {
		return new ResponseEntity<>(typeService.createType(type), HttpStatus.OK);
	}
	
	@PutMapping("/type")
	public ResponseEntity<Type> updateType(@RequestBody Type type) {
		return new ResponseEntity<>(typeService.updateType(type), HttpStatus.OK);
	}
	
	@DeleteMapping("/type/{id}")
	public void deleteType(@PathVariable Integer id) {
		typeService.deleteType(id);
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
