package com.example.demo.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Services.ContentService;
import com.example.demo.Services.titleService;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/journal")
public class journalResource {

	@Autowired
	private RestTemplate restTemplate ;
	@Autowired
	private titleService titleService ;
	@Autowired
	private ContentService contentService ;
	
	@GetMapping("/{title}/{content}")

	public String getJournal(@PathVariable String title, @PathVariable String content)
	{
		System.out.println("n");
		String myTitle = titleService.getTitle(title);
		String myContent = contentService.getContent(content);
		return "Title & Content :"+myTitle+myContent;
	}
	

	
	
	
}


