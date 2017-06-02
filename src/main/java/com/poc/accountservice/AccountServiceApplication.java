package com.poc.accountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * This is a learners project. Lessons for developing micro services using spring.
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.poc.accountservice.entity"} )
@EnableJpaRepositories(basePackages = {"com.poc.accountservice.repositories"})

public class AccountServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
}
