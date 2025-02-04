package com.student_management_app.demo.student_app.service;


import com.student_management_app.demo.student_app.model.Student;
import com.student_management_app.demo.student_app.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student saveStudent(Student student) {
        System.out.println("Saving student: " + student);
        return repo.save(student);
    }
}
