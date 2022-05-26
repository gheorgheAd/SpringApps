package com.example.myapp.controller;

import com.example.myapp.entity.Student;
import com.example.myapp.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
//    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    private Student getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
//    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    private void deleteStudentById(@PathVariable("id") int id){
        studentService.removeStudentById(id);
    }

    @PutMapping
//    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @PostMapping
//    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
    }
}
