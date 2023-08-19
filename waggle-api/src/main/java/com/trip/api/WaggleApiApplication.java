package com.trip.api;

import lombok.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Generated
@ComponentScan(basePackages = { "com.trip" })
@EntityScan(basePackages = { "com.trip" })
public class WaggleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaggleApiApplication.class, args);
    }
}
