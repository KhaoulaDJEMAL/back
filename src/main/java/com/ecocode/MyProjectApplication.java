package com.ecocode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ecocode.entities.User;
import com.ecocode.repositories.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.ecocode.repositories"})
@EntityScan(basePackages = "com.ecocode.entities")
public class MyProjectApplication implements CommandLineRunner {


	
	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}








}
