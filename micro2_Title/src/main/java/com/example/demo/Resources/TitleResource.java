package com.example.demo.Resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;

@RestController
@RequestMapping("/title")
public class TitleResource {

	@GetMapping("/{titleId}")
	public String getTitle(@PathVariable String titleId) {
		System.out.println("hello title");
		return "<h1>"+titleId+"</h1><br>" ;
	}
}
