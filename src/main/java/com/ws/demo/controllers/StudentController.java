package com.ws.demo.controllers;

import com.ws.demo.models.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/api/student")
public class StudentController {
    private static Map<String, Student> studentsRepo = new HashMap<>();

    static {
        Student honey = new Student("1", "Honey", 23, "h@a.com", "subject1");
        Student almond = new Student("2", "Almond", 21, "a@a.com", "subject2");
        studentsRepo.put(honey.getId(), honey);
        studentsRepo.put(almond.getId(), almond);
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getStudent() {
        return new ResponseEntity<>(studentsRepo.values(), HttpStatus.OK);
    }

    @GetMapping(value = "{studentId}")
    public ResponseEntity<Object> GetStudentById(@PathVariable String studentId){
        return new ResponseEntity<>(studentsRepo.get(studentId),HttpStatus.OK);
    }
    @PostMapping(value = "create")
    public ResponseEntity<Object> createStudent(@RequestBody Student student){
        studentsRepo.put(student.getId(), student);
        return new ResponseEntity<>("Student Created", HttpStatus.CREATED);
    }
}

