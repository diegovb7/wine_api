package com.wine_api.wine_api.service;

import java.util.List;

import com.wine_api.wine_api.wines.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wine_api.wine_api.repository.TypeRepository;

@Service
public class TypeService {
    
    @Autowired
    TypeRepository typeRepository;

    //CREATE
    public Type create(Type type){
        return typeRepository.save(type);
    }

    //READ

    public List<Type> getAll(){
        return typeRepository.findAll();
    }

    public Type getTypeById(Long id){
        return typeRepository.findById(id).get();
    }

    //UPDATE

    //public Type update(Type type){
        
    //}

    //DELETE




}
