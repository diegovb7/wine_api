package com.wine_api.wine_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wine_api.wine_api.repository.TypeRepository;
import com.wine_api.wine_api.wines.Type;

@Service
public class TypeService {
    
    @Autowired
    TypeRepository typeRepository;

    public List<Type> getAll(){
        return typeRepository.findAll();
    }

    public Type getTypeById(Integer id){
        return typeRepository.findById(id).get();
    }    

    public Type createType(Type type){
        return typeRepository.save(type);
    }

    public void deleteType(Integer id) {
    	typeRepository.deleteById(id);
	}
	
	public Type updateType(Type type){
        return typeRepository.save(type);
    }




}
