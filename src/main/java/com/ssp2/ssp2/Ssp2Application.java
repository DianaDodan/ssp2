package com.ssp2.ssp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Ssp2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ssp2Application.class, args);
	}

}
