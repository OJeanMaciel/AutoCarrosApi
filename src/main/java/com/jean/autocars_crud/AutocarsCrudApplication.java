package com.jean.autocars_crud;

import com.jean.autocars_crud.model.Cars;
import com.jean.autocars_crud.repository.CarsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AutocarsCrudApplication {

	public static void main(String[] args) {

		SpringApplication.run(AutocarsCrudApplication.class, args);
	}
}
