package com.trip.api;

import lombok.Generated;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@Generated
@ComponentScan(basePackages = { "com.trip" })
@EntityScan(basePackages = { "com.trip" })
@EnableJpaAuditing
public class WaggleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaggleApiApplication.class, args);
    }
}
