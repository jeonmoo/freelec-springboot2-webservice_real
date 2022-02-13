package com.jojoldu.book_real.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FreelecSpringboot2WebserviceRealApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreelecSpringboot2WebserviceRealApplication.class, args);
    }

}
