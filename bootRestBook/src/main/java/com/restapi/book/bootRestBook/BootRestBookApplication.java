package com.restapi.book.bootRestBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
public class BootRestBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootRestBookApplication.class, args);
	}

}
