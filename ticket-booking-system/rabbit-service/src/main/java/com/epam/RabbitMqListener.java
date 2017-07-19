package com.epam;


import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class RabbitMqListener {
    @RabbitListener(queues = "queue1")
    public void processQueue1(String message) {
        System.err.println("Received from queue 1: " + message);
    }

}