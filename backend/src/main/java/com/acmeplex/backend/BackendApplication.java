package com.acmeplex.backend;

import com.acmeplex.backend.model.*;
import com.acmeplex.backend.repository.MovieRepository;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.acmeplex.backend.repository")  // Scans for JPA Repositories in the specified package
@ComponentScan(basePackages = { "com.acmeplex.backend" })  // Scans for Spring beans in the specified package
@EntityScan("com.acmeplex.backend.model")
public class BackendApplication implements CommandLineRunner {

	@Autowired
	MovieRepository movieRepository;
	public static void main(String[] args){
		// Load .env file
		Dotenv dotenv = Dotenv.load();

		// Pass environment variables to Spring
		System.setProperty("spring.datasource.url", dotenv.get("DATABASE_URL"));
		System.setProperty("spring.datasource.username", dotenv.get("DB_USERNAME"));
		System.setProperty("spring.datasource.password", dotenv.get("DB_PASSWORD"));

		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server is running successfully.");
	}
}
