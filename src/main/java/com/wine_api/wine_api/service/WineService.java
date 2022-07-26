package com.wine_api.wine_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wine_api.wine_api.repository.WineRepository;

@Service
public class WineService {

    @Autowired
    WineRepository wineRepository;
}
