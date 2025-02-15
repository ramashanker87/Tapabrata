package com.student.management.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue studentQueue() {
        return new Queue("student.out");
    }

    @Bean
    public Queue nameQueue() {
        return new Queue("name.out");
    }
}
