package com.example.springreact.controller;

import com.example.springreact.Student;
import com.example.springreact.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class WebController {

    @Autowired
    private StudentRepository studentRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/students", produces = "application/json")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{matrikelnummer}")
    public Student getStudentByMatrikelnummer(@PathVariable Integer matrikelnummer) {
        return studentRepository.findByMatrikelnummer(matrikelnummer);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/students")
    void newStudent(@RequestBody Student newStudent) {
        System.out.println(newStudent.toString());
        studentRepository.addStudent(newStudent);
    }
}
