package com.roney.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParkingSqsService {

    private final SqsTemplate sqsTemplate;
    private final ObjectMapper objectMapper;

    public void sendMessage(String queueName, Object message) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(message);
            sqsTemplate.send(queueName, jsonMessage);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize message", e);
        }
    }
}

