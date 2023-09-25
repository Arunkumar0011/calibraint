package com.calibraint.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

/**
 * In the 'SQLDataFromCSV' project, retrieve data from a CSV file using traditional SQL queries
 *  without relying on any third-party libraries.
 * 
 */

@SpringBootApplication
@OpenAPIDefinition
public class CalibraintApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalibraintApplication.class, args);
	}

}
