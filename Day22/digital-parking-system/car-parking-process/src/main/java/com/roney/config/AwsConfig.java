package com.roney.config;


import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class AwsConfig {

    @Bean
    public SqsTemplate sqsTemplate() {
        return SqsTemplate.builder().build();
    }

    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create("YOUR_AWS_ACCESS_KEY", "YOUR_AWS_SECRET_KEY")))
                .build();
    }
}

