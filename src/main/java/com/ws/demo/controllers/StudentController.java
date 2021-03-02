package com.ws.demo.controllers;

import com.ws.demo.exception.StudentNotFoundException;
import com.ws.demo.models.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    @PostMapping(value = "")
    public ResponseEntity<Object> createStudent(@RequestBody Student student){
        studentsRepo.put(student.getId(), student);
        return new ResponseEntity<>("Student Created", HttpStatus.CREATED);
    }

    @PutMapping(value = "{studentId}")
    public ResponseEntity<Object> updateStudent(@PathVariable("studentId") String studentId, @RequestBody Student student){
        if(!studentsRepo.containsKey(studentId)){
            throw new StudentNotFoundException();
        }

        studentsRepo.remove(studentId);
        student.setId(studentId);
        studentsRepo.put(studentId, student);
        return new ResponseEntity<>("Student updated",HttpStatus.OK);
    }

    @DeleteMapping(value = "{studentId}")
    public ResponseEntity<Object> DeleteStudentById(@PathVariable String studentId){
        studentsRepo.remove(studentId);
        return new ResponseEntity<>("Student is deleted",HttpStatus.OK);
    }
}

