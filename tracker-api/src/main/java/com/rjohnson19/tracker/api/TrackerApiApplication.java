package com.rjohnson19.tracker.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.rjohnson19.tracker.data.domain")
public class TrackerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackerApiApplication.class, args);
	}
}
