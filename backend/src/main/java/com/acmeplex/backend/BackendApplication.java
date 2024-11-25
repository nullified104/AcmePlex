package com.acmeplex.backend;

import com.acmeplex.backend.model.*;
import com.acmeplex.backend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	@Autowired
	MovieRepository movieRepository;
	public static void main(String[] args){
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Movie m = new Movie("Venom", "Action", 180);
		movieRepository.save(m);
		System.out.println("Server is running successfully.");
	}
}
