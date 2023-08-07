package com.example.demo.Resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Rating;
import com.example.demo.Models.UserRating;

@RestController
@RequestMapping("/ratingdata")
public class ratingResource {
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable String movieId)
	{
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("/users/{userId}")
	public UserRating getAllRating(@PathVariable String userId)
	{
	List<Rating> ratings = Arrays.asList(
			new Rating("1", 4),
			new Rating("2", 7)
			);
	UserRating userRating = new UserRating(ratings);
	return userRating ;
	
	}
}
