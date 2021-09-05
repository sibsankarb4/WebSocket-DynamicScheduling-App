package com.boot.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class WebSocketDynamicSchedulingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSocketDynamicSchedulingAppApplication.class, args);
	}
	
	@Bean
   	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
   		return new RestTemplate();
   	}

}
