package com.example.demo.Resources;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.Models.CatalogItem;
import com.example.demo.Models.Movie;
import com.example.demo.Models.Rating;
import com.example.demo.Models.UserRating;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private WebClient.Builder webClient ;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId){
		
		
		//call resource that he found on microservice 'rating-data-service'
		
		
		UserRating userRating = restTemplate.getForObject("http://ratingdatah/ratingdata/users/"+userId,UserRating.class)	;	
		
		
		return userRating.getRatings().stream().map(rating -> {
		Movie myMovie =	restTemplate.getForObject("http://movieinfoservice/movies/"+rating.getMovieId(),Movie.class);
			
	/*		Movie myMovie =	 webClient.build()
							.get()
							.uri("http://movieInfoService/movies/"+rating.getMovieId())
							.retrieve()
							.bodyToMono(Movie.class)
							.block(); */
			
			return 	new CatalogItem(myMovie.getName(), "Test", rating.getRating());
		}).toList();	 
		
	}
}









