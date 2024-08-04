package com.example.rating.hotelRating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer 
public class HotelRatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelRatingApplication.class, args);
	}

}
