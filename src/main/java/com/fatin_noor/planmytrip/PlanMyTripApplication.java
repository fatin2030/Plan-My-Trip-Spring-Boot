package com.fatin_noor.planmytrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication(scanBasePackages = "com.fatin_noor.planmytrip")
@EnableRetry
public class PlanMyTripApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanMyTripApplication.class, args);
	}

}
