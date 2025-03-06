package com.tapabrata.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessageChannel;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;
import com.patient.management.model.Patient;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@Service
public class SQSService {

    @Value("${cloud.aws.sqs.queue.name}")
    private String queueName;

    private final QueueMessagingTemplate queueMessagingTemplate;

    public SQSService(QueueMessagingTemplate queueMessagingTemplate) {
        this.queueMessagingTemplate = queueMessagingTemplate;
    }

    public void sendMessage(Patient patient, String disease) {
        String messageBody = "Patient Info: " + patient.getName() + ", Disease: " + disease;
        Message<String> message = MessageBuilder.withPayload(messageBody).build();
        queueMessagingTemplate.send(queueName, message);
    }

    public String receiveMessage() {
        Message<?> message = queueMessagingTemplate.receive(queueName);
        return message != null ? message.getPayload().toString() : "No messages in queue";
    }
}

