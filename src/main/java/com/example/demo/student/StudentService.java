package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*@Component  //to say that this is bean class*/
@Service  // for more readability spring provides this annotation ;same as @Component
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping                //inorder for this method to serve as restful endpoint.for we want to get something out from our server.
    public List<Student> getStudents(){

//		ArrayList<String> friends =  new ArrayList<>(Arrays.asList("Peter", "Paul"));
        return studentRepository.findAll();                //this returns a list to us
    }

    public void addNewStudent(Student student) {
        System.out.println(student);
    }
}
