package com.rjohnson19.tracker.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.rjohnson19.tracker.data.domain")
@EnableJpaRepositories("com.rjohnson19.tracker.persistence.repository")
public class TrackerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackerApiApplication.class, args);
	}
}
