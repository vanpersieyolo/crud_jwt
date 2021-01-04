package com.example.demo.controller.student;

import com.example.demo.model.AppUser;
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

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<Student>> findAll(){
        return new ResponseEntity<>( studentService.findAll(),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Student> save (@RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        Student student = studentService.findById(id).get();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity remove(@PathVariable Long id){
        studentService.remove(id);
        return new ResponseEntity (HttpStatus.OK);
    }

}
