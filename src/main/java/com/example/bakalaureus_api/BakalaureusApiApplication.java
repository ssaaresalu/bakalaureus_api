package com.example.bakalaureus_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BakalaureusApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BakalaureusApiApplication.class, args);
    }

}
