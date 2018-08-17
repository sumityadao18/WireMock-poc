package com.test.microService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class MicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceApplication.class, args);
	}

	@GetMapping(value = "/test")
	public String getValue(){
		RestTemplate restTemplate = new RestTemplate();
		String value = restTemplate
				.getForObject("http://localhost:8010/helloWorld",String.class);
		return value + "test";
	}
}
