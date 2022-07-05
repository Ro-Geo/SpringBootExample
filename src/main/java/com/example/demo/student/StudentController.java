package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//this class will have all the resources for API

@RestController
@RequestMapping(path="api/v1/student")    //instead of going to localhost:8080 we now want api/v1/student
public class StudentController {

    private final StudentService studentService;

    @Autowired  //we are saying that this StudentService should be autowired means it should be instantiated for us and injected into this constructor.Also we need tell the code that the "Studentservice" class to be instatiated by annotating '@Component' above that class definition
    public StudentController(StudentService studentService) {
        /*this.studentService = new StudentService();  //we should avoid things like this and use dependency injection instead */
        this.studentService = studentService;
    }

    @GetMapping
    //inorder for this method to serve as restful endpoint.for we want to get something out from our server.
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
}
