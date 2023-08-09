package com.example.demo.Resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content")
public class ContentResource {

	@GetMapping("/{contentId}")
	public String getContent(@PathVariable String contentId) {
		System.out.println("hello");
		return "the content of journal of this day => "+contentId ;
	}
}
