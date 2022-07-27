package com.wine_api.wine_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wine_api.wine_api.wines.Wine;

@Repository
public interface WineRepository extends JpaRepository<Wine, Integer>{

//	@Query(value = "select * from wine order by rating DESC limit 10", nativeQuery = true)
//	List<Wine> findWinesByBestRating();
//	
//	@Query(value = "select * from wine order by price DESC limit 10", nativeQuery = true)
//	List<Wine> findWinesByHighestPrice();
	
	@Query(value = "select * from wine order by rating DESC", nativeQuery = true)
	List<Wine> findWinesByBestRating();
	
	@Query(value = "select * from wine order by price DESC", nativeQuery = true)
	List<Wine> findWinesByHighestPrice();
	
}
