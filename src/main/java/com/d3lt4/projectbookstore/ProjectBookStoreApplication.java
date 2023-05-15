package com.d3lt4.projectbookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ProjectBookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectBookStoreApplication.class, args);
	}

}
