package com.rjohnson19.tracker.api;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.rjohnson19.tracker.data.domain")
@EnableJpaRepositories("com.rjohnson19.tracker.persistence.repository")
public class TrackerApiApplication {

    // teaches Jackson to support Java 8 Date/Time classes.
    @Bean
    public JavaTimeModule javaTimeModule() {
        return new JavaTimeModule();
    }

    public static void main(String[] args) {
        SpringApplication.run(TrackerApiApplication.class, args);
    }
}
