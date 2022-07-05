package com.example.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component  //to say that this is bean class
//@Service  // for more readability spring provides this annotation ;same as @Component
public class StudentService {

    @GetMapping
    //inorder for this method to serve as restful endpoint.for we want to get something out from our server.
    public List<Student> getStudents(){
        Student s1=new Student(
                1L,
                "Tim",
                "tim@gmail.com",
                LocalDate.of(2000, Month.JANUARY,12),
                22);

        ArrayList<Student> list =  new ArrayList<Student>(Arrays.asList(s1));
//		ArrayList<String> friends =  new ArrayList<>(Arrays.asList("Peter", "Paul"));
//
        return list;
        //return List.of( "Hello" , "World!!!");
    }
}
