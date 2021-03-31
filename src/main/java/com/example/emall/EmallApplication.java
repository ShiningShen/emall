package com.example.emall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmallApplication {

    public static void main(String[] args) {
        SpringApplication.run ( EmallApplication.class, args );
        System.out.println("http://localhost:8081");
    }

}
