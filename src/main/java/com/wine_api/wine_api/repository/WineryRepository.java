package com.wine_api.wine_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wine_api.wine_api.wines.Winery;

@Repository
public interface WineryRepository extends JpaRepository<Winery, Long>{

}
