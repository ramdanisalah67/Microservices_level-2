package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class titleService {


	@Autowired
	private RestTemplate restTemplate ; 
	
	@CircuitBreaker(name = "firstCurcuit",fallbackMethod = "getTitleErrorResponse")

	public String getTitle(String title) {
		return restTemplate.getForObject("http://titleservice/title/"+title, String.class);
	}
	
	
	public String getTitleErrorResponse(Exception e) {
		return "<span style='color:red;'>no Title Error internal on the service 'Title' </span>";
	}
}
