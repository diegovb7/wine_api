package com.wine_api.wine_api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wine_api.wine_api.wines.Wine;

@Repository
public interface WineRepository extends JpaRepository<Wine, Integer>{

	@Query(value = "select * from wine order by rating DESC", nativeQuery = true)
	List<Wine> findWinesByBestRating(Pageable topLimit);
	
	@Query(value = "select * from wine order by price DESC", nativeQuery = true)
	List<Wine> findWinesByHighestPrice(Pageable topLimit);
	
	@Query(value = "select * from wine order by rating/price desc", nativeQuery = true)
	List<Wine> findWinesByRatingPrice(Pageable topLimit);

    @Query(value = "select year from wine group by year order by avg(rating) desc", nativeQuery = true)
	List<String> findBestYears(Pageable topLimit);
	
    List<Wine> findByYear(String year);
}
