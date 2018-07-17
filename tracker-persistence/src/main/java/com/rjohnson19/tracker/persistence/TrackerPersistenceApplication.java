package com.rjohnson19.tracker.persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.rjohnson19.tracker.data.domain")
public class TrackerPersistenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrackerPersistenceApplication.class, args);
    }
}
