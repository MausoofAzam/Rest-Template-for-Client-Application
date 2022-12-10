package com.snort.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class ApiDataConsumerRestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDataConsumerRestTemplateApplication.class, args);
		
		log.info("SBT-ApiDataConsumerRestTemplateApplication started..!");
	}

	
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
