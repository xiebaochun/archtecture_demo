package com.example.restservice.controller;

import com.example.restservice.Greeting;
import com.example.restservice.model.Student;
import com.example.restservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("add")
    public String add(@RequestParam(value = "firstName", defaultValue = "defaultFirstName") String firstName,
                      @RequestParam(value = "lastName", defaultValue = "defaultLastName") String lastName) {
        //return new Greeting(counter.incrementAndGet(), String.format(template, "name"));
        studentRepository.save(new Student(firstName, lastName));
        return "Saved";
    }

    @GetMapping("/get")
    public Student get(@RequestParam(value = "name", defaultValue = "World") String name,
                       @RequestParam(value = "lastName", defaultValue = "defaultLastName") String lastName) {
        return new Student(name, lastName);
    }

    @GetMapping("/getAll")
    public Iterable<Student> getAll() {
        return studentRepository.findAll();
    }
}
