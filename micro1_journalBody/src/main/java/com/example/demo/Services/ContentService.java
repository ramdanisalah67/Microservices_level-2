package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ContentService {

	@Autowired
	private RestTemplate restTemplate ;
	
	
	@CircuitBreaker(name = "firstCurcuit",fallbackMethod = "getContentEroorReponse")

	public String getContent(String content ) {
		return restTemplate.getForObject("http://contentservice/content/"+content, String.class);
	}
	
	
	public String getContentEroorReponse(Exception e) {
		return  "<span style='color:red;'>no Content Error internal on the service 'Content' </span>";
	}
}
