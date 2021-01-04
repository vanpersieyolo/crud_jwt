package com.example.demo.service.student;

import com.example.demo.model.Entity.Student;

import java.util.Optional;

public interface IStudentService {
    Iterable<Student> findAll();
    Student save(Student student);
    void remove (Long id);
    Optional<Student> findById(Long id);
}
