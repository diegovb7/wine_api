package com.wine_api.wine_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wine_api.wine_api.repository.WineRepository;

@Component
public class Executor implements CommandLineRunner{
	
	@Autowired
	WineRepository wineRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Data");
		
		System.out.println(wineRepository.findWinesByBestRating());
		
	}

}
