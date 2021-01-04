package com.example.demo.repo.student;

import com.example.demo.model.Entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface StudentRepository extends PagingAndSortingRepository<Student,Long> {
}
