package com.lucassilva.travel_info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TravelInfoApplication {

	public static void main(String[] args) {

		SpringApplication.run(TravelInfoApplication.class, args);
	}

}
