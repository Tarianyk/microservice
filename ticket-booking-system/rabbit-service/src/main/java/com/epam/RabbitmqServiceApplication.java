package com.epam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@Import(RabbitConfiguration.class)
@ComponentScan(basePackages = "com.epam")
public class RabbitmqServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqServiceApplication.class, args);
    }
}