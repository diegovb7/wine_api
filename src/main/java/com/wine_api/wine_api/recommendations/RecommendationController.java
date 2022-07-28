package com.wine_api.wine_api.recommendations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wine_api.wine_api.service.WineService;
import com.wine_api.wine_api.wines.Wine;

@RestController
@RequestMapping("/api/recommend")
public class RecommendationController {

	@Autowired
	private WineService wineService;

	private Pageable topLimit = null;

	@GetMapping("/best")
	public ResponseEntity<List<Wine>> getBestRatedWines(@RequestParam(required = false) Integer top) {

		checkTopValueIsNull(top);

		List<Wine> wines = wineService.findWinesByBestRating(topLimit);

		if (wines.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return new ResponseEntity<>(wines, HttpStatus.OK);
	}

	@GetMapping("/expensive")
	public ResponseEntity<List<Wine>> getHighestPricedWines(@RequestParam(required = false) Integer top) {

		checkTopValueIsNull(top);

		List<Wine> wines = wineService.findWinesByHighestPrice(topLimit);

		if (wines.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return new ResponseEntity<>(wines, HttpStatus.OK);
	}

	@GetMapping("/bang")
	public ResponseEntity<List<Wine>> getWinesByRatingPrice(@RequestParam(required = false) Integer top) {

		checkTopValueIsNull(top);

		List<Wine> wines = wineService.findWinesByRatingPrice(topLimit);

		if (wines.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return new ResponseEntity<>(wines, HttpStatus.OK);
	}

	@GetMapping("/vintage")
	public ResponseEntity<Map<String, List<Wine>>> getWinesByBestYears(@RequestParam(required = false) Integer top) {

		Map<String, List<Wine>> map = new HashMap<>();

		checkTopValueIsNull(top);

		List<String> years = wineService.findBestYears(topLimit);

		years.stream().forEach(s -> map.put(s, wineService.findByYear(s)));

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	private void checkTopValueIsNull(Integer top) {
		if (top != null) {
			topLimit = PageRequest.of(0, top);
		}
	}

}
