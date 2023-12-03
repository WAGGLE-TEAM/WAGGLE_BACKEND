package com.trip.api;

import com.trip.api.exception.GlobalExceptionHandler;
import lombok.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@Generated
@ComponentScan(basePackages = { "com.trip" })
@EntityScan(basePackages = { "com.trip" })
@Import(GlobalExceptionHandler.class)
public class WaggleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaggleApiApplication.class, args);
    }
}
