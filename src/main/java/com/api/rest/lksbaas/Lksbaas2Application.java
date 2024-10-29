package com.api.rest.lksbaas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SuppressWarnings("unused")

@SpringBootApplication
@EntityScan(basePackages = "com.api.rest.lksbaas.model")
@EnableJpaRepositories(basePackages = "com.api.rest.lksbaas.repository")
public class Lksbaas2Application {
    public static void main(String[] args) {
        SpringApplication.run(Lksbaas2Application.class, args);
    }
}
