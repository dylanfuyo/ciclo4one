package com.proyecto.saylor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EntityScan(basePackages = {"com.proyecto.saylor"})
@SpringBootApplication
@EnableConfigurationProperties

public class SayorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SayorApplication.class, args);
	}

}
