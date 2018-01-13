package com.spsolutions.grand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RosterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RosterServiceApplication.class, args);
	}
}
