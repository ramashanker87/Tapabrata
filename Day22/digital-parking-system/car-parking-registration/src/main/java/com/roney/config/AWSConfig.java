package com.roney.config;


import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfig {

    @Bean
    public SqsTemplate sqsTemplate() {
        return SqsTemplate.builder().build();
    }
}
