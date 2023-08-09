package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication

public class MovieCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate() {
    	HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
    	httpComponentsClientHttpRequestFactory.setConnectTimeout(3000);
    	
		return new RestTemplate(httpComponentsClientHttpRequestFactory);
	}

   // @Bean
    //@LoadBalanced
    WebClient.Builder webClient(){
		return WebClient.builder();
	}

}
