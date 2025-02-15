package com.student.management.service;


import com.student.management.model.Student;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentProducer {
    private final RabbitTemplate rabbitTemplate;

    public StudentProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendStudent(Student student) {
        rabbitTemplate.convertAndSend("student.out", student);
    }

    public void sendName(String name) {
        rabbitTemplate.convertAndSend("name.out", name);
    }
}