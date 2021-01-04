package com.example.demo.controller.student;

import com.example.demo.model.Entity.Student;
import com.example.demo.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;

@RestController
@RequestMapping("/api/crud")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Student>> findAll(Pageable pageable){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Student> save (Student student){
        return new ResponseEntity<>(studentService.save(student),HttpStatus.OK);
    }
    @GetMapping("/findById")
    public ResponseEntity<Student> findById(Long id){
        return new ResponseEntity<>(studentService.findById(id).get(), HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity remove(Long id){
        studentService.remove(id);
        return new ResponseEntity (HttpStatus.OK);
    }

}
