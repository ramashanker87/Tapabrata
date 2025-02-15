package com.student.management.repo;

import com.student.management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    void deleteByName(String name);
}