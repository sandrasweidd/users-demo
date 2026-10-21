package com.example.usersdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Nqtet el bidaye. Spring bifattesh 3ala kel el classes taht hal package
// w bi3mol objects (Beans) men yalli 3layhon @Service, @RestController, ...
@SpringBootApplication
public class UsersDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(UsersDemoApplication.class, args);
    }
}
