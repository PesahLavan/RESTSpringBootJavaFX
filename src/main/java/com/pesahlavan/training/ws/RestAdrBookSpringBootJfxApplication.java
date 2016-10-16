package com.pesahlavan.training.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.pesahlavan.training"})
public class RestAdrBookSpringBootJfxApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestAdrBookSpringBootJfxApplication.class, args);
	}
}
