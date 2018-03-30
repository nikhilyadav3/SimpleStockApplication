package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com")
@ComponentScan("com")
@EnableJpaRepositories("com")
public class JpMorganStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpMorganStockApplication.class, args);
	}
}
