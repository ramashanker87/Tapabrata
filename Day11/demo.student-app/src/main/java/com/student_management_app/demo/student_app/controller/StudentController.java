package com.student_management_app.demo.student_app.controller;


import com.student_management_app.demo.student_app.model.Student;
import com.student_management_app.demo.student_app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("read")
    public List<Student> read(){
        return studentService.getAllStudents();
    }

    @PostMapping("/save")
    public Student createStudent( @RequestBody Student student) {
        System.out.println("Received student: " + student);
        return studentService.saveStudent(student);

    }

}
