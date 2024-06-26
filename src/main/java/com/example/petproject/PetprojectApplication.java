package com.example.petproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PetprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetprojectApplication.class, args);
	}
}