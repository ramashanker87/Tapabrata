package com.student.management.service;

import com.student.management.model.Student;
import com.student.management.repo.StudentRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class StudentConsumer {
    private final StudentRepository studentRepository;

    public StudentConsumer(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RabbitListener(queues = "student.out")
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @RabbitListener(queues = "name.out")
    public void deleteStudent(String name) {
        studentRepository.deleteByName(name);
    }
}