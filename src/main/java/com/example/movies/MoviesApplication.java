package com.example.movies;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
		Dotenv dotenv = Dotenv.configure().load();

		// Pass environment variables to SpringApplication
		SpringApplication application = new SpringApplication(MoviesApplication.class);
		application.setDefaultProperties(Collections.singletonMap("MONGO_CLUSTER", dotenv.get("MONGO_CLUSTER")));
		application.run(args);
	}

}
