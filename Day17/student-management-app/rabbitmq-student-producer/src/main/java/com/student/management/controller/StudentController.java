package com.student.management.controller;

import com.student.management.model.Student;
import com.student.management.service.StudentProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentProducer studentProducer;

    public StudentController(StudentProducer studentProducer) {
        this.studentProducer = studentProducer;
    }

    @PostMapping("/save")
    public String saveStudent(@RequestBody Student student) {
        studentProducer.sendStudent(student);
        return "Student sent to queue!";
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam String name) {
        studentProducer.sendName(name);
        return "Student delete request sent to queue!";
    }
}