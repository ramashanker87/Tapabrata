package com.student.management.controller;

import com.student.management.model.Student;
import com.student.management.repo.StudentRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/read")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestParam String name, @RequestParam int age) {
        return studentRepository.findByName(name)
                .map(student -> {
                    student.setAge(age);
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam String name) {
        return studentRepository.findByName(name)
                .map(student -> {
                    studentRepository.delete(student);
                    return "Student deleted successfully";
                })
                .orElse("Student not found");
    }
}
